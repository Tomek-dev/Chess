import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Queen extends Chess {
    private int[] choice = new int[12];
    Queen(Panel panel, Board board, boolean color) {
        super(panel, board, color);
        for (int i = 0; i < choice.length; i++) {
            choice[i] = 1;
        }
        if(color)
        {
            icon = new ImageIcon(getClass().getResource("resources\\icons\\darkqueen.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickeddarkqueen.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selecteddarkqueen.png"));
        }else
        {
            icon = new ImageIcon(getClass().getResource("resources\\icons\\whitequeen.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickedwhitequeen.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selectedwhitequeen.png"));
        }
        setIcon(icon);
    }

    @Override
    protected List<Chess> beatPosibility() {
        List<Chess> list = new ArrayList<>();
        if(row+ choice[5] <=7&&column+choice[8]<=7&&board.getPanel(row+ choice[5],column+choice[8]).isOccupied())
        {
            for(Component component : board.getPanel(row+ choice[5],column+choice[8]).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row+choice[10]<=7&&column-choice[9]>=0&&board.getPanel(row+choice[10],column-choice[9]).isOccupied())
        {
            for(Component component : board.getPanel(row+choice[10],column-choice[9]).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row- choice[4] >=0&&column+choice[7]<=7&&board.getPanel(row- choice[4],column+choice[7]).isOccupied())
        {
            for(Component component : board.getPanel(row- choice[4],column+choice[7]).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row-choice[11]>=0&&column-choice[6]>=0&&board.getPanel(row-choice[11],column-choice[6]).isOccupied())
        {
            for(Component component : board.getPanel(row-choice[11],column-choice[6]).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(column-choice[1]>=0&&board.getPanel(row, column-choice[1]).isOccupied())
        {
            for(Component component : board.getPanel(row, column-choice[1]).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(column+choice[0]<=7&&board.getPanel(row, column+choice[0]).isOccupied())
        {
            for(Component component : board.getPanel(row, column+choice[0]).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row+choice[3]<=7&&board.getPanel(row+choice[3], column).isOccupied())
        {
            for(Component component : board.getPanel(row+choice[3], column).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row-choice[2]>=0&&board.getPanel(row-choice[2], column).isOccupied())
        {
            for(Component component : board.getPanel(row-choice[2], column).getComponents())
            {
                list.add((Chess) component);
            }
        }
        /*      Don't change place of this loop     */
        for (int i = 0; i < choice.length; i++) {
            choice[i] = 1;
        }
        /*                                          */
        return list;
    }

    @Override
    protected List<Pick> movePosibility() {
        List<Pick> list = new LinkedList<>();
        while (row - choice[2] >= 0 && !board.getPanel(row - choice[2], column).isOccupied()) {
            list.add(new Pick(board.getPanel(row - choice[2], column)));
            choice[2]++;
        }
        while (row + choice[3] <= 7 && !board.getPanel(row + choice[3], column).isOccupied())
        {
            list.add(new Pick(board.getPanel(row + choice[3], column)));
            choice[3]++;
        }
        while (column + choice[0] <= 7 && !board.getPanel(row, column + choice[0]).isOccupied())
        {
            list.add(new Pick(board.getPanel(row, column + choice[0])));
            choice[0]++;
        }
        while (column - choice[1] >= 0 && !board.getPanel(row, column - choice[1]).isOccupied()) {
            list.add(new Pick(board.getPanel(row, column - choice[1])));
            choice[1]++;
        }
        while(row+ choice[5] <=7&&column+choice[8]<=7&&!board.getPanel(row+ choice[5],column+choice[8]).isOccupied())
        {
            list.add(new Pick(board.getPanel(row+ choice[5], column+choice[8])));
            choice[8]++;
            choice[5]++;
        }
        while(row+choice[10]<=7&&column-choice[9]>=0&&!board.getPanel(row+choice[10],column-choice[9]).isOccupied())
        {
            list.add(new Pick(board.getPanel(row+choice[10], column-choice[9])));
            choice[9]++;
            choice[10]++;
        }
        while(row- choice[4] >=0&&column+choice[7]<=7&&!board.getPanel(row- choice[4],column+choice[7]).isOccupied())
        {
            list.add(new Pick(board.getPanel(row- choice[4], column+choice[7])));
            choice[7]++;
            choice[4]++;
        }
        while(row-choice[11]>=0&&column-choice[6]>=0&&!board.getPanel(row-choice[11],column-choice[6]).isOccupied())
        {
            list.add(new Pick(board.getPanel(row-choice[11], column-choice[6])));
            choice[6]++;
            choice[11]++;
        }
        return list;
    }
}
