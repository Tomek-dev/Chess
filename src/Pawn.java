
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Chess {
    private int direction;
    private ImageIcon[] buttonimage = new ImageIcon[4]; //0 - Queen, 1 - Knight, 2 - Bishop, 3 - Rook
    private ImageIcon[] enterimage = new ImageIcon[4]; //0 - Queen, 1 - Knight, 2 - Bishop, 3 - Rook
    Pawn(Panel panel, Board board, boolean color)
    {
        super(panel, board, color);
        if(color)
        {
            direction = 1;
            icon = new ImageIcon(getClass().getResource("resources\\icons\\darkpawn.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickeddarkpawn.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selecteddarkpawn.png"));
            buttonimage[0] = new ImageIcon(getClass().getResource("resources\\button\\buttondarkqueen.png"));
            buttonimage[1] = new ImageIcon(getClass().getResource("resources\\button\\buttondarkknight.png"));
            buttonimage[2] = new ImageIcon(getClass().getResource("resources\\button\\buttondarkbishop.png"));
            buttonimage[3] = new ImageIcon(getClass().getResource("resources\\button\\buttondarkrook.png"));
            enterimage[0] = new ImageIcon(getClass().getResource("resources\\enter\\enterdarkqueen.png"));
            enterimage[1] = new ImageIcon(getClass().getResource("resources\\enter\\enterdarkknight.png"));
            enterimage[2] = new ImageIcon(getClass().getResource("resources\\enter\\enterdarkbishop.png"));
            enterimage[3] = new ImageIcon(getClass().getResource("resources\\enter\\enterdarkrook.png"));
        }else
        {
            direction = -1;
            icon = new ImageIcon(getClass().getResource("resources\\icons\\whitepawn.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickedwhitepawn.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selectedwhitepawn.png"));
            buttonimage[0] = new ImageIcon(getClass().getResource("resources\\button\\buttonwhitequeen.png"));
            buttonimage[1] = new ImageIcon(getClass().getResource("resources\\button\\buttonwhiteknight.png"));
            buttonimage[2] = new ImageIcon(getClass().getResource("resources\\button\\buttonwhitebishop.png"));
            buttonimage[3] = new ImageIcon(getClass().getResource("resources\\button\\buttonwhiterook.png"));
            enterimage[0] = new ImageIcon(getClass().getResource("resources\\enter\\enterwhitequeen.png"));
            enterimage[1] = new ImageIcon(getClass().getResource("resources\\enter\\enterwhiteknight.png"));
            enterimage[2] = new ImageIcon(getClass().getResource("resources\\enter\\enterwhitebishop.png"));
            enterimage[3] = new ImageIcon(getClass().getResource("resources\\enter\\enterwhiterook.png"));
        }
        setIcon(icon);
    }
    protected void Change()
    {
        if(color)
            board.getBlackchess().remove(this);
        else
            board.getWhitechess().remove(this);
        Chess[] choice = new Chess[4];  //0 - Queen, 1 - Knight, 2 - Bishop, 3 - Rook
        choice[0] = new Queen(board.getPanel(row,column), board, color);
        choice[1] = new Knight(board.getPanel(row,column), board, color);
        choice[2] = new Bishop(board.getPanel(row,column), board, color);
        choice[3] = new Rook(board.getPanel(row,column), board, color);
        board.getPanel(row,column).setLayout(new GridLayout(2,2));
        JButton[] button = new JButton[4]; //0 - Queen, 1 - Knight, 2 - Bishop, 3 - Rook
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton(buttonimage[i]);
            button[i].setOpaque(false);
            button[i].setContentAreaFilled(false);
            button[i].setBorderPainted(false);
            button[i].setFocusPainted(false);
            int finalI = i;
            button[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    button[finalI].setIcon(enterimage[finalI]);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    button[finalI].setIcon(buttonimage[finalI]);
                }
            });
            button[i].addActionListener(e -> {
                for (Component component : board.getPanel(row, column).getComponents()) {
                    board.getPanel(row,column).remove(component);
                }
                board.getPanel(row,column).revalidate();
                board.getPanel(row,column).repaint();
                board.getPanel(row,column).setLayout(new GridLayout(1,1));
                board.getPanel(row,column).add(choice[finalI]);
                if(color)
                    board.getBlackchess().add(choice[finalI]);
                else
                    board.getWhitechess().add(choice[finalI]);
            });
            board.getPanel(row, column).add(button[i]);
        }
        board.getPanel(row, column).revalidate();
        board.getPanel(row, column).repaint();
    }

    @Override
    protected List<Chess> beatPosibility() {
        List<Chess> list = new ArrayList<>();
        if(row+direction>=0&&row+direction<=7&&column+1<=7&&board.getPanel(row+direction,column+1).isOccupied())
        {
            for(Component component : board.getPanel(row+direction,column+1).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row+direction>=0&&row+direction<=7&&column-1>=0&&board.getPanel(row+direction,column-1).isOccupied())
        {
            for(Component component : board.getPanel(row+direction,column-1).getComponents())
            {
                list.add((Chess) component);
            }
        }
        return list;
    }

    @Override
    protected List<Pick> movePosibility() {
        List<Pick> list = new ArrayList<>();
        if(row+direction>=0&&row+direction<=7&&!board.getPanel(row+direction,column).isOccupied())
        {
            list.add(new Pick(board.getPanel(row + direction, column)));
            if(color && row == 1&&!board.getPanel(row + (2 * direction), column).isOccupied())
                list.add(new Pick(board.getPanel(row + (2 * direction), column)));
            else if(!color && row == 6&&!board.getPanel(row + (2 * direction), column).isOccupied())
                list.add(new Pick(board.getPanel(row + (2 * direction), column)));
        }
        return list;
    }
}