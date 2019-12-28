import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Board extends JPanel {
    private Panel[][] panel = new Panel[8][8];
    private List<Chess> blackchess = new LinkedList<>();
    private List<Chess> whitechess = new LinkedList<>();
    Board()
    {
        setLayout(new GridLayout(8,8));
        draw();
        whiteFigure();
        blackFigure();
    }
    private void draw()
    {
        boolean color = true;
        for(int i = 0; i < panel.length; i++)
        {
            for(int j = 0; j <panel[i].length; j++)
            {
                panel[i][j] = new Panel(i,j);
                if(color) panel[i][j].setBackground(Color.decode("#f0d9b5"));
                else panel[i][j].setBackground(Color.decode("#b58863"));
                color = !color;
                this.add(panel[i][j]);
            }
            color = !color;
        }
    }
   private void blackFigure()
    {
        int index = 8;
        blackchess.add(new Rook(panel[0][0], this,true));
        panel[0][0].add(blackchess.get(0));
        blackchess.add(new Rook(panel[0][7], this,true));
        panel[0][7].add(blackchess.get(1));
        blackchess.add(new Knight(panel[0][1], this,true));
        panel[0][1].add(blackchess.get(2));
        blackchess.add(new Knight(panel[0][6], this,true));
        panel[0][6].add(blackchess.get(3));
        blackchess.add(new Bishop(panel[0][2], this,true));
        panel[0][2].add(blackchess.get(4));
        blackchess.add(new Bishop(panel[0][5], this,true));
        panel[0][5].add(blackchess.get(5));
        blackchess.add(new Queen(panel[0][3], this,true));
        panel[0][3].add(blackchess.get(6));
        blackchess.add(new King(panel[0][4], this,true));
        panel[0][4].add(blackchess.get(7));
        for(int i = 0; i <= 7; i++)
        {
            blackchess.add(new Pawn(panel[1][i], this,true));
            panel[1][i].add(blackchess.get(index));
            index++;
        }
    }
    private void whiteFigure()
    {
        int index = 8;
        whitechess.add(new Rook(panel[7][0], this,false));
        panel[7][0].add(whitechess.get(0));
        whitechess.add(new Rook(panel[7][7], this,false));
        panel[7][7].add(whitechess.get(1));
        whitechess.add(new Knight(panel[7][1], this,false));
        panel[7][1].add(whitechess.get(2));
        whitechess.add(new Knight(panel[7][6], this,false));
        panel[7][6].add(whitechess.get(3));
        whitechess.add(new Bishop(panel[7][2], this,false));
        panel[7][2].add(whitechess.get(4));
        whitechess.add(new Bishop(panel[7][5], this,false));
        panel[7][5].add(whitechess.get(5));
        whitechess.add(new Queen(panel[7][3], this,false));
        panel[7][3].add(whitechess.get(6));
        whitechess.add(new King(panel[7][4], this,false));
        panel[7][4].add(whitechess.get(7));
        for(int i = 0; i <= 7; i++)
        {
            whitechess.add(new Pawn(panel[6][i], this,false));
            panel[6][i].add(whitechess.get(index));
            index++;
        }
    }

    public Panel getPanel(int row, int column) {
        return panel[row][column];
    }

    public List<Chess> getBlackchess() {
        return blackchess;
    }

    public List<Chess> getWhitechess() {
        return whitechess;
    }
}
