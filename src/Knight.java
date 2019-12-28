import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Chess {
    Knight(Panel panel, Board board, boolean color) {
        super(panel, board, color);
        if(color)
        {
            icon = new ImageIcon(getClass().getResource("resources\\icons\\darkknight.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickeddarkknight.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selecteddarkknight.png"));
        }else
        {
            icon = new ImageIcon(getClass().getResource("resources\\icons\\whiteknight.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickedwhiteknight.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selectedwhiteknight.png"));
        }
        setIcon(icon);
    }

    @Override
    protected List<Chess> beatPosibility() {
        List<Chess> list = new ArrayList<>();
        int j = -2;
        for(int i = -1; -3 < i; i--)
        {
            if(row+i>=0&&column+j>=0&&board.getPanel(row+i,column+j).isOccupied())
            {
                for(Component component : board.getPanel(row+i,column+j).getComponents())
                {
                    list.add((Chess) component);
                }
            }
            j++;
        }
        j = -2;
        for(int i = 1; i<3; i++)
        {
            if(row+i<=7&&column+j>=0&&board.getPanel(row+i,column+j).isOccupied())
            {
                    for(Component component : board.getPanel(row+i,column+j).getComponents())
                    {
                        list.add((Chess) component);
                    }
            }
            j++;
        }
        int p = 2;
        for(int i = -1; -3<i; i--)
        {
            if(row+i>=0&&column+p<=7&&board.getPanel(row+i,column+p).isOccupied())
            {
                    for(Component component : board.getPanel(row+i,column+p).getComponents())
                    {
                        list.add((Chess) component);
                    }
            }
            p--;
        }
        p = 2;
        for(int i = 1; i < 3; i++)
        {
            if(row+i<=7&&column+p<=7&&board.getPanel(row+i,column+p).isOccupied())
            {
                    for(Component component : board.getPanel(row+i,column+p).getComponents())
                    {
                        list.add((Chess) component);
                    }
            }
            p--;
        }
        return list;
    }

    @Override
    protected List<Pick> movePosibility() {
        List<Pick> list = new ArrayList<>();
        int j = -2;
        for(int i = -1; -3 < i; i--)
        {
            if(row+i>=0&&column+j>=0&&!board.getPanel(row+i,column+j).isOccupied())
            {
                    list.add(new Pick(board.getPanel(row+i, column+j)));
            }
            j++;
        }
        j = -2;
        for(int i = 1; i<3; i++)
        {
            if(row+i<=7&&column+j>=0&&!board.getPanel(row+i,column+j).isOccupied())
            {
                    list.add(new Pick(board.getPanel(row+i, column+j)));
            }
            j++;
        }
        int p = 2;
        for(int i = -1; -3<i; i--)
        {
            if(row+i>=0&&column+p<=7&&!board.getPanel(row+i,column+p).isOccupied())
            {
                    list.add(new Pick(board.getPanel(row+i, column+p)));
            }
            p--;
        }
        p = 2;
        for(int i = 1; i < 3; i++)
        {
            if(row+i<=7&&column+p<=7&&!board.getPanel(row+i,column+p).isOccupied())
            {
                    list.add(new Pick(board.getPanel(row+i, column+p)));
            }
            p--;
        }
        return list;
    }
}
