import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class King extends Chess {
    King(Panel panel, Board board, boolean color) {
        super(panel, board, color);
        if(color)
        {
            icon = new ImageIcon(getClass().getResource("resources\\icons\\darkking.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickeddarkking.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selecteddarkking.png"));
        }else
        {
            icon = new ImageIcon(getClass().getResource("resources\\icons\\whiteking.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickedwhiteking.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selectedwhiteking.png"));
        }
        setIcon(icon);
    }

    @Override
    protected List<Chess> beatPosibility() {
        List<Chess> list = new ArrayList<>();
        if(row-1>=0&&board.getPanel(row-1,column).isOccupied())
        {
            for(Component component : board.getPanel(row-1, column).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row+1<=7&&board.getPanel(row+1,column).isOccupied())
        {
            for(Component component : board.getPanel(row+1, column).getComponents())
            {
                list.add((Chess) component);
            }

        }
        if(column-1>=0&&board.getPanel(row,column-1).isOccupied())
        {
            for(Component component : board.getPanel(row, column-1).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(column+1<=7&&board.getPanel(row,column+1).isOccupied())
        {
            for(Component component : board.getPanel(row, column+1).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row-1>=0&&column-1>=0&&board.getPanel(row-1,column-1).isOccupied())
        {
            for(Component component : board.getPanel(row-1, column-1).getComponents())
            {
                list.add((Chess) component);
            }

        }
        if(row-1>=0&&column+1<=7&&board.getPanel(row-1,column+1).isOccupied())
        {
            for(Component component : board.getPanel(row-1, column+1).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row+1<=7&&column+1<=7&&board.getPanel(row+1,column+1).isOccupied())
        {
            for(Component component : board.getPanel(row+1, column+1).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row+1<=7&&column-1>=0&&board.getPanel(row+1,column-1).isOccupied())
        {
            for(Component component : board.getPanel(row+1, column-1).getComponents())
            {
                list.add((Chess) component);
            }
        }
        return list;
    }

    @Override
    protected List<Pick> movePosibility() {
        List<Pick> list = new ArrayList<>();
        if(row-1>=0&&!board.getPanel(row-1,column).isOccupied())
        {
                list.add(new Pick(board.getPanel(row -1, column)));
        }
        if(row+1<=7&&!board.getPanel(row+1,column).isOccupied())
        {
                list.add(new Pick(board.getPanel(row +1, column)));
        }
        if(column-1>=0&&!board.getPanel(row,column-1).isOccupied())
        {
                list.add(new Pick(board.getPanel(row, column-1)));
        }
        if(column+1<=7&&!board.getPanel(row,column+1).isOccupied())
        {
                list.add(new Pick(board.getPanel(row, column+1)));
        }
        if(row-1>=0&&column-1>=0&&!board.getPanel(row-1,column-1).isOccupied())
        {
                list.add(new Pick(board.getPanel(row-1, column-1)));
        }
        if(row-1>=0&&column+1<=7&&!board.getPanel(row-1,column+1).isOccupied())
        {
                list.add(new Pick(board.getPanel(row-1, column+1)));
        }
        if(row+1<=7&&column+1<=7&&!board.getPanel(row+1,column+1).isOccupied())
        {
                list.add(new Pick(board.getPanel(row+1, column+1)));
        }
        if(row+1<=7&&column-1>=0&&!board.getPanel(row+1,column-1).isOccupied())
        {
                list.add(new Pick(board.getPanel(row+1, column-1)));
        }
        return list;
    }
}
