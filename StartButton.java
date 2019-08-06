import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton implements ActionListener {
    private TicTacToeFrame f;
    private boolean b;

    public StartButton(String name, TicTacToeFrame fr, boolean b) {
        super(name);
        f = fr;
        this.b = b;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        f.gameFrame();
        if(b)
        {
           f.endGame.setVisible(false);
        }

    }
}
