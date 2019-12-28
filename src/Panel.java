import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Panel extends JPanel {
    private boolean occupied;
    private int row;
    private int column;
    private Board board;
    Panel(int row, int column)
    {
        this.board = board;
        this.row = row;
        this.column = column;
        setPreferredSize(new Dimension(80,80));
        setLayout(new GridLayout(1,1));

        occupied = false;
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
