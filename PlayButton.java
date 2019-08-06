import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayButton extends JButton implements ActionListener {
    private TicTacToeFrame f;
    private TicTacToe t;
    private int whoFirst;
    private int position;
    private static int count;
    private boolean isPressd;

    public PlayButton(TicTacToeFrame fr, int whoFirst, int position, TicTacToe tic) {

        f = fr;
        addActionListener(this);

        count = whoFirst;
        t = tic;
        this.position = position;
    }

    public void actionPerformed(ActionEvent e) {
        if (isPressd) {
            return;
        }
        isPressd = true;
        count++;

        String rez = "";
        int row = position / 3;
        int col = position % 3;


        if (count % 2 == 0) {
            try {
                Image img = ImageIO.read(getClass().getResource("O1.png"));
                setIcon(new ImageIcon(img));
                rez = t.game(1, row, col);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            f.name = f.name2.getText();

        } else {
            try {
                Image img = ImageIO.read(getClass().getResource("X1.png"));
                setIcon(new ImageIcon(img));
                rez = t.game(0, row, col);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            f.name = f.name1.getText();

        }
        f.whoTurn.setText("Turn :" + f.name);
        if (!rez.equals(".")) {
            f.endGame(rez);
        }
    }
}
