
public class TicTacToe {
    private static int firstPlayer = 1;
    private static int secondPlayer = 2;
    public String rez = ".";
    TicTacToeFrame f;
    private int z;
    private int matrix[][] = new int[3][3];
    private boolean isFinished;
    private int count;

    public TicTacToe(TicTacToeFrame f) {
        this.f = f;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = -1;
            }
        }

    }

    public void setValue(int who, int row, int col) {
        if (who == firstPlayer)
            matrix[row][col] = firstPlayer;
        else
            matrix[row][col] = secondPlayer;
    }

    public String game(int who, int row, int col) {

        if (isFinished)
            return rez;
        setValue(who, row, col);

        {
            if (checkForWinner(matrix) == 1) {
                isFinished = true;
                rez = f.name + " has won!!";
            } else if (checkForWinner(matrix) == 2) {
                isFinished = true;
                rez = f.name + " has won!!";
            }
        }
        if (gameIsFinished(matrix) == 4 && count >= 8) {
            isFinished = true;
            rez = "as Draw!!";
        }
        count++;
        return rez;
    }


    public int gameIsFinished(int[][] a) {
        int b = 4;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == 0) {
                    b = 3;
                }
            }
        return b;
    }

    public int checkForWinner(int[][] a) {
        int b = -1;
        for (int i = 0; i < 3; i++) {
            if (a[i][0] == a[i][1] && a[i][1] == a[i][2] && (a[i][0] == 1 || a[i][0] == 2)) {
                b = a[i][0];
            }
            if (a[0][i] == a[1][i] && a[1][i] == a[2][i] && (a[0][i] == 1 || a[0][i] == 2)) {
                b = a[0][i];
            }
        }
        if (a[0][0] == a[1][1] && a[1][1] == a[2][2] && (a[0][0] == 1 || a[0][0] == 2)) {
            b = a[0][0];
        }
        if (a[0][2] == a[1][1] && a[1][1] == a[2][0] && (a[0][2] == 1 || a[0][2] == 2)) {
            b = a[0][2];
        }
        return b;
    }
}
