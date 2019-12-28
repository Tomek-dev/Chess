import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

abstract public class Chess extends JButton {
    protected Panel panel;                          //
    protected boolean color;                        //
    protected Board board;                          //
    protected int row;                              //
    protected int column;                           //
    protected boolean clicked;                      //
    protected boolean listener;                     //
    protected ImageIcon icon;                       //
    protected ImageIcon clickedicon;                //
    protected ImageIcon selectedicon;               //
    protected Chess lastchess;                      //
    protected Chess source;                         //
    Chess(Panel panel, Board board, boolean color)
    {
        this.panel = panel;
        this.board = board;
        this.color = color;
        panel.setOccupied(true);
        row = panel.getRow();
        column = panel.getColumn();
        clicked = false;
        listener = false;
        source = this;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        addActionListener(new ClickActionListener());
    }

    /**
     *
     * @return
     */
    protected abstract List<Pick> movePosibility();

    /**
     *
     * @return
     */
    protected abstract List<Chess> beatPosibility();

    /**
     *
     */
    private void clearing()
    {
        for (Pick element : movePosibility()) {
            for(Component component : board.getPanel(element.getRow(),element.getColumn()).getComponents())
            {
                board.getPanel(element.getRow(),element.getColumn()).remove(component);
            }
            board.getPanel(element.getRow(),element.getColumn()).revalidate();
            board.getPanel(element.getRow(), element.getColumn()).repaint();
        }
        for (Chess element : beatPosibility()) {
            element.listener = false;
            element.lastchess = null;
            element.setIcon(element.icon);
        }
        clicked = false;
        setIcon(icon);
    }

    /**
     *
     */
    private class ClickActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!listener)
            {
                setIcon(clickedicon);
                if(!clicked)
                {
                    for (Pick element : movePosibility()) {
                        board.getPanel(element.getRow(),element.getColumn()).add(element);
                        element.addActionListener(new MoveActionListener());
                    }
                }
                board.revalidate();
                clicked = true;
                board.addMouseListener(new ChessMouseListener());
                for (Chess element : beatPosibility())
                    if(element.color != color)
                    {
                        element.listener = true;
                        element.lastchess = source;
                        element.setIcon(element.selectedicon);
                    }
            }
            else
            {
                board.getPanel(row, column).remove(source);
                board.getPanel(row, column).setOccupied(false);
                board.getPanel(row, column).revalidate();
                board.getPanel(row, column).repaint();
                clearing();
                board.getPanel(lastchess.row, lastchess.column).remove(lastchess);
                board.getPanel(lastchess.row, lastchess.column).setOccupied(false);
                board.getPanel(lastchess.row, lastchess.column).revalidate();
                board.getPanel(lastchess.row, lastchess.column).repaint();
                lastchess.clearing();
                for (Pick element : lastchess.movePosibility()) {
                    board.getPanel(element.getRow(), element.getColumn()).remove(element);
                    board.getPanel(element.getRow(), element.getColumn()).revalidate();
                    board.getPanel(element.getRow(), element.getColumn()).repaint();
                }
                for (Pick element : movePosibility()) {
                    board.getPanel(element.getRow(), element.getColumn()).remove(element);
                    board.getPanel(element.getRow(), element.getColumn()).revalidate();
                    board.getPanel(element.getRow(), element.getColumn()).repaint();
                }
                for(Chess element : lastchess.beatPosibility())
                {
                    element.setIcon(element.icon);
                    element.listener = false;
                }
                if(color)
                    board.getBlackchess().remove(source);
                else
                    board.getWhitechess().remove(source);
                board.getPanel(row,column).setOccupied(true);
                lastchess.row = row;
                lastchess.column = column;
                /*if(lastchess instanceof Pawn)
                {
                    if(lastchess.row == 0 || lastchess.row == 7)
                        ((Pawn) lastchess).Change();
                    else
                        board.getPanel(row,column).add(lastchess);
                }
                else*/
                board.getPanel(row,column).add(lastchess);
                lastchess.clicked = false;
                lastchess.setIcon(lastchess.icon);
            }
        }
    }

    /**
     *
     */
    private class ChessMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            clearing();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    /**
     *
     */
    protected class MoveActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            Pick sourcepick = (Pick) e.getSource();
            SwingUtilities.invokeLater(() -> {
                clearing();
                board.getPanel(row,column).remove(source);
                board.getPanel(row,column).setOccupied(false);
                board.getPanel(row, column).revalidate();
                board.getPanel(row, column).repaint();
                row=sourcepick.getRow();
                column=sourcepick.getColumn();
                board.getPanel(row,column).add(source);
                board.getPanel(row,column).setOccupied(true);
                clicked = false;
                setIcon(icon);
            });
        }
    }
}
