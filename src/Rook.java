import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Chess{
    private int[] choice = new int[4];
    Rook(Panel panel, Board board, boolean color)
    {
        super(panel, board, color);
        for (int i = 0; i < choice.length; i++) {
            choice[i] = 1;
        }
        if(color)
        {
            icon = new ImageIcon(getClass().getResource("resources\\icons\\darkrook.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickeddarkrook.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selecteddarkrook.png"));
        }else
        {
            icon = new ImageIcon(getClass().getResource("resources\\icons\\whiterook.png"));
            clickedicon = new ImageIcon(getClass().getResource("resources\\clicked\\clickedwhiterook.png"));
            selectedicon = new ImageIcon(getClass().getResource("resources\\selected\\selectedwhiterook.png"));
        }
        setIcon(icon);
    }

    @Override
    protected List<Chess> beatPosibility() {
        List<Chess> list = new ArrayList<>();
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
        List<Pick> list = new ArrayList<>();
        while(row-choice[2]>=0&&!board.getPanel(row-choice[2],column).isOccupied())
        {
            list.add(new Pick(board.getPanel(row-choice[2],column)));
            choice[2]++;
        }
        while(row+choice[3]<=7&&!board.getPanel(row+choice[3],column).isOccupied())
        {
            list.add(new Pick(board.getPanel(row+choice[3],column)));
            choice[3]++;
        }
        while(column+choice[0]<=7&&!board.getPanel(row,column+choice[0]).isOccupied())
        {
            list.add(new Pick(board.getPanel(row,column+choice[0])));
            choice[0]++;
        }
        while(column-choice[1]>=0&&!board.getPanel(row,column-choice[1]).isOccupied())
        {
            list.add(new Pick(board.getPanel(row,column-choice[1])));
            choice[1]++;
        }
        return list;
    }
}
