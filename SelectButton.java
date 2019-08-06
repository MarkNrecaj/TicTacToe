import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectButton extends JButton implements ActionListener {
    private TicTacToeFrame f;
    private TicTacToe t;

    public SelectButton(String name, TicTacToeFrame fr) {
        super(name);
        f = fr;
        addActionListener(this);
        t = new TicTacToe(f);
    }

    public void actionPerformed(ActionEvent e) {
        f.enterNameFrame();


    }
}
