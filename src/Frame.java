import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Frame()
    {
        Board board = new Board();
        add(board);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();
    }
}
