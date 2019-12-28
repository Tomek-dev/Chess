import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Bishop extends Chess {
    private int[] choice = new int[8];
    Bishop(Panel panel, Board board, boolean color)
    {
        super(panel, board, color);
        for (int i = 0; i < choice.length; i++) {
            choice[i] = 1;
        }

        if(color)
        {
            icon = new ImageIcon(getClass().getResource("resources\\icons\\darkbishop.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickeddarkbishop.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selecteddarkbishop.png"));
        }else
        {
            icon =new ImageIcon(getClass().getResource("resources\\icons\\whitebishop.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickedwhitebishop.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selectedwhitebishop.png"));
        }
        setIcon(icon);
    }

    @Override
    protected List<Chess> beatPosibility() {
        List<Chess> list = new ArrayList<>();

        if(row+ choice[1] <=7&&column+choice[4]<=7&&board.getPanel(row+ choice[1],column+choice[4]).isOccupied())
        {
            for(Component component : board.getPanel(row+ choice[1],column+choice[4]).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row+choice[6]<=7&&column-choice[5]>=0&&board.getPanel(row+choice[6],column-choice[5]).isOccupied())
        {
            for(Component component : board.getPanel(row+choice[6],column-choice[5]).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row- choice[0] >=0&&column+choice[3]<=7&&board.getPanel(row- choice[0],column+choice[3]).isOccupied())
        {
            for(Component component : board.getPanel(row- choice[0],column+choice[3]).getComponents())
            {
                list.add((Chess) component);
            }
        }
        if(row-choice[7]>=0&&column-choice[2]>=0&&board.getPanel(row-choice[7],column-choice[2]).isOccupied())
        {
            for(Component component : board.getPanel(row-choice[7],column-choice[2]).getComponents())
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
        List<Pick> list = new ArrayList<>();
        while(row+ choice[1] <=7&&column+choice[4]<=7&&!board.getPanel(row+ choice[1],column+choice[4]).isOccupied())
        {
            list.add(new Pick(board.getPanel(row+ choice[1], column+choice[4])));
            choice[4]++;
            choice[1]++;
        }
        while(row+choice[6]<=7&&column-choice[5]>=0&&!board.getPanel(row+choice[6],column-choice[5]).isOccupied())
        {
            list.add(new Pick(board.getPanel(row+choice[6], column-choice[5])));
            choice[5]++;
            choice[6]++;
        }
        while(row- choice[0] >=0&&column+choice[3]<=7&&!board.getPanel(row- choice[0],column+choice[3]).isOccupied())
        {
            list.add(new Pick(board.getPanel(row- choice[0], column+choice[3])));
            choice[3]++;
            choice[0]++;
        }
        while(row-choice[7]>=0&&column-choice[2]>=0&&!board.getPanel(row-choice[7],column-choice[2]).isOccupied())
        {
            list.add(new Pick(board.getPanel(row-choice[7], column-choice[2])));
            choice[2]++;
            choice[7]++;
        }
        return list;
    }

}
