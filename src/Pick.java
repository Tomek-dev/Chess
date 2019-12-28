import javax.swing.*;

public class Pick extends JButton {
    private Panel panel;
    private int row;
    private int column;
    Pick(Panel panel)
    {
        this.panel = panel;
        this.row = panel.getRow();
        this.column = panel.getColumn();

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setIcon(new ImageIcon(getClass().getResource("resources\\icons\\dot.png")));

    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

}
