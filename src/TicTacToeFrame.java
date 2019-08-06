import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TicTacToeFrame extends JFrame {
    public Container cp;
    public JTextField name1;
    public JTextField name2;
    private int whoFirst;
    public String name;
    public JLabel whoTurn;
    JFrame endGame;
    public int p1 = 0;
    public int p2 = 0;



    public TicTacToeFrame(int h, int w) {
        setSize(h, w);
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        cp = getContentPane();
        whoFirst = 1;
    }

    public void startGameFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 0));
        JLabel header = new JLabel("TicTacToe Game");
        header.setForeground(Color.BLUE);
        header.setFont(new Font("Calibri", Font.BOLD, 30));
        header.setHorizontalAlignment(JLabel.CENTER);
        SelectButton s1 = new SelectButton("Start", this);
        panel.add(header);
        panel.add(s1);
        cp.add(panel);
        setVisible(true);
    }


    public void enterNameFrame() {
        cp.removeAll();
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0, 2));

        panel.setBackground(Color.GRAY);
        JLabel player1 = new JLabel("Player 1:");
        player1.setFont(new Font("Calibri", Font.BOLD, 30));
        name1 = new JTextField();
        name1.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 25));
        panel.setLayout(new GridLayout(3, 0));
        panel1.add(player1);
        panel1.add(name1);
        panel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(0, 2));
        JLabel player2 = new JLabel("Player 2:");
        player2.setFont(new Font("Calibri", Font.BOLD, 30));
        name2 = new JTextField();
        name2.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 25));
        panel2.add(player2);
        panel2.add(name2);
        panel.add(panel2);
        StartButton s = new StartButton("Start", this, false);

        panel.add(s);

        cp.add(panel);
        setVisible(true);

    }

    public void gameFrame() {

        name = name1.getText();
        TicTacToe tic = new TicTacToe(this);
        cp.removeAll();
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel.setLayout(new BorderLayout());
        panel1.setBackground(Color.BLACK);
        PlayButton[] button = new PlayButton[9];
        panel1.setLayout(new GridLayout(3, 3, 4, 4));
        for (int i = 0; i < 9; i++) {
            button[i] = new PlayButton(this, whoFirst, i, tic);
            button[i].setBackground(Color.WHITE);
            panel1.add(button[i]);
        }
        whoTurn = new JLabel("Turn: " + name);
        whoTurn.setFont(new Font("Calibri", Font.BOLD, 20));
        panel.add(whoTurn, BorderLayout.NORTH);
        panel.add(panel1, BorderLayout.CENTER);
        cp.add(panel);
        setVisible(true);
        whoFirst++;
    }

    public void endGame(String s) {
        endGame = new JFrame();
        endGame.setSize(400, 200);
        endGame.setLocation(50, 100);
        endGame.setLayout(new GridLayout(4, 0));
        JPanel panel1 = new JPanel();
        JLabel label = new JLabel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();

        label.setText("The game is finished " + s);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 20));
        endGame.add(label);

        String m = " has won!!";
        if (s.equals(name1.getText() + m)) {
            p1++;
        } else if (s.equals(name2.getText() + m)) {
            p2++;
        }

        label1.setText(name1.getText() + " : " + p1);
        label2.setText(name2.getText() + " : " + p2);

        StartButton sb = new StartButton("Play Again", this, true);
        panel1.add(sb);

        ExitButton ex = new ExitButton("Exit", this);
        panel1.add(ex);

        endGame.add(label1);
        endGame.add(label2);

        endGame.add(panel1);
        endGame.setVisible(true);
    }
}
