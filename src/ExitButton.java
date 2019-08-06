import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton implements ActionListener {
    private TicTacToeFrame f;


    public ExitButton(String name, TicTacToeFrame fr) {
        super(name);
        f = fr;
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
