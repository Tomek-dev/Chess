
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Chess {
    private int direction;
    private ImageIcon buttonqueen;
    private ImageIcon buttonbishop;
    private ImageIcon buttonrook;
    private ImageIcon buttonknight;
    private ImageIcon enterqueen;
    private ImageIcon enterbishop;
    private ImageIcon enterrook;
    private ImageIcon enterknight;
    Pawn(Panel panel, Board board, boolean color)
    {
        super(panel, board, color);
        if(color)
        {
            direction = 1;
            icon = new ImageIcon(getClass().getResource("resources\\icons\\darkpawn.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickeddarkpawn.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selecteddarkpawn.png"));
            /*buttonbishop = new ImageIcon(getClass().getResource("resources\\button\\buttondarkbishop.png"));
            buttonqueen = new ImageIcon(getClass().getResource("resources\\button\\buttondarkqueen.png"));
            buttonknight = new ImageIcon(getClass().getResource("resources\\button\\buttondarkknight.png"));
            buttonrook = new ImageIcon(getClass().getResource("resources\\button\\buttondarkrook.png"));
            enterqueen = new ImageIcon(getClass().getResource("resources\\enter\\enterdarkqueen.png"));
            enterbishop = new ImageIcon(getClass().getResource("resources\\enter\\enterdarkbishop.png"));
            enterknight = new ImageIcon(getClass().getResource("resources\\enter\\enterdarkknight.png"));
            enterrook = new ImageIcon(getClass().getResource("resources\\enter\\enterdarkrook.png"));*/
        }else
        {
            direction = -1;
            icon = new ImageIcon(getClass().getResource("resources\\icons\\whitepawn.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickedwhitepawn.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selectedwhitepawn.png"));
            /*buttonbishop = new ImageIcon(getClass().getResource("resources\\button\\buttonwhitebishop.png"));
            buttonqueen = new ImageIcon(getClass().getResource("resources\\button\\buttonwhitequeen.png"));
            buttonknight = new ImageIcon(getClass().getResource("resources\\button\\buttonwhiteknight.png"));
            buttonrook = new ImageIcon(getClass().getResource("resources\\button\\buttonwhiterook.png"));
            enterqueen = new ImageIcon(getClass().getResource("resources\\enter\\enterwhitequeen.png"));
            enterbishop = new ImageIcon(getClass().getResource("resources\\enter\\enterwhitebishop.png"));
            enterknight = new ImageIcon(getClass().getResource("resources\\enter\\enterwhiteknight.png"));
            enterrook = new ImageIcon(getClass().getResource("resources\\enter\\enterwhiterook.png"));*/
        }
        setIcon(icon);
    }
    /*public void Change()
    {
            //if(color) board.getBlackchess().remove(this);
            //else board.getWhitechess().remove(this);
            board.getPanel(row,column).setLayout(new GridLayout(2,2));
            JButton[] button = new JButton[4]; //0 - Queen, 1 - Knight, 2 - Bishop, 3 - Rook
            button[0] = new JButton(buttonqueen);
            button[0].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    button[0].setIcon(enterqueen);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    button[0].setIcon(buttonqueen);
                }
            });
            button[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Component component : board.getPanel(row, column).getComponents()) {
                        board.getPanel(row,column).remove(component);
                    }
                    board.getPanel(row,column).revalidate();
                    board.getPanel(row,column).repaint();
                    board.getPanel(row,column).setLayout(new GridLayout(1,1));
                    board.getPanel(row,column).add(new Queen(board.getPanel(row,column), board, color));
                }
            });
            button[1] = new JButton(buttonknight);
            button[1].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    button[1].setIcon(enterknight);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    button[1].setIcon(buttonknight);
                }
            });
            button[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component component : board.getPanel(row, column).getComponents()) {
                    board.getPanel(row,column).remove(component);
                }
                board.getPanel(row,column).revalidate();
                board.getPanel(row,column).repaint();
                board.getPanel(row,column).setLayout(new GridLayout(1,1));
                board.getPanel(row,column).add(new Knight(board.getPanel(row,column), board, color));
            }
        });
            button[2] = new JButton(buttonbishop);
            button[2].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    button[2].setIcon(enterbishop);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    button[2].setIcon(buttonbishop);
                }
            });
            button[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component component : board.getPanel(row, column).getComponents()) {
                    board.getPanel(row,column).remove(component);
                }
                board.getPanel(row,column).revalidate();
                board.getPanel(row,column).repaint();
                board.getPanel(row,column).setLayout(new GridLayout(1,1));
                board.getPanel(row,column).add(new Bishop(board.getPanel(row,column), board, color));
            }
        });
            button[3] = new JButton(buttonrook);
            button[3].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    button[3].setIcon(enterrook);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    button[3].setIcon(buttonrook);
                }
            });
            button[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component component : board.getPanel(row, column).getComponents()) {
                    board.getPanel(row,column).remove(component);
                }
                board.getPanel(row,column).revalidate();
                board.getPanel(row,column).repaint();
                board.getPanel(row,column).setLayout(new GridLayout(1,1));
                board.getPanel(row,column).add(new Rook(board.getPanel(row,column), board, color));
            }
        });
            for (JButton element : button) {
                element.setOpaque(false);
                element.setContentAreaFilled(false);
                element.setBorderPainted(false);
                element.setFocusPainted(false);
                board.getPanel(row, column).add(element);
                board.getPanel(row, column).revalidate();
                board.getPanel(row, column).repaint();
            }
            /*for (Chess whitechess : board.getWhitechess()) {
                whitechess.removeActionListener(this.actionListener);
            }
            for (Chess blackchess : board.getBlackchess()) {
                blackchess.removeActionListener(this.actionListener);
            }

    }*/

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