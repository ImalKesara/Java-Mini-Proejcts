package TicTacToe;

public class Board {
    final char[][] girds = new char[3][3];

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                girds[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < girds.length; i++) {
            for (int j = 0; j < girds[i].length; j++) {
                System.out.print(j % 2 == 1 ? girds[i][j] : "|" + girds[i][j] + "|");
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int column) {
        if (row >= 0 && row < 3 && column >= 0 && column < 3) {
            if (girds[row][column] == '-') {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (girds[i][j] == '-') {
                    return false;
                }
            }
        }
        //draw scenario
        return true;
    }

    public boolean winner(char symbol) {

        if ((girds[0][0] == symbol) && (girds[1][1] == symbol) && (girds[2][2] == symbol) ||
                (girds[0][2] == symbol) && (girds[1][1] == symbol) && (girds[2][0] == symbol)) {
            return true;
        }

        for (int row = 0; row < girds.length; row++) {
            int rowCount = 0;
            int columnCount = 0;

            //horizontal scenario
            for (int column = 0; column < girds.length; column++) {
                if (girds[row][column] == symbol) {
                    rowCount++;
                }
            }
            //vertical scenario
            for (int column = 0; column < girds.length; column++) {
                if (girds[column][row] == symbol) {
                    columnCount++;
                }
            }
            if (rowCount == 3 || columnCount == 3) {
                return true;
            }
        }
        return false;
    }

    public void insertMove(int row, int column, char symbol) {
        isFull();
        girds[row][column] = symbol;
        printBoard();
    }
}
