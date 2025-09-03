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
        int count = 0;
        if ((girds[0][0] == symbol) && (girds[1][1] == symbol) && (girds[2][2] == symbol)) {
            count = 3;
        } else if ((girds[0][2] == symbol) && (girds[1][1] == symbol) && (girds[2][0] == symbol)) {
            count = 3;
        } else {
            for (int row = 0; row < girds[row].length; row++) {
                //horizontal scenario
                for (int column = 0; column < girds[column].length; column++) {
                    if (girds[row][column] == symbol) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
                //vertical scenario
                for (int column = 0; column < girds[column].length; column++) {
                    if (girds[column][row] == symbol) {
                        count++;
                    } else {
                        count = 0;
                    }
                }

            }
        }
        return count == 3;
    }


    public void insertMove(int row, int column, char symbol) {
        girds[row][column] = symbol;
        printBoard();
    }


}
