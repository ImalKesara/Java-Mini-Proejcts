package TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {

        Board board = new Board();
        Player me = new Player('X', "Imal kesara");
        Player computer = new Player('O', "Computer", true);
        Player currentPlayer = me;

        while (!board.isFull()) {
            if (currentPlayer == me) {
                currentPlayer = computer;
                int[] arr = currentPlayer.getMove(board);
                int x = arr[0];
                int y = arr[1];
                board.insertMove(x, y, currentPlayer.getSymbol());
            } else {
                currentPlayer = me;
                int[] arr = currentPlayer.getMove(board);
                int x = arr[0];
                int y = arr[1];
                board.insertMove(x, y, currentPlayer.getSymbol());
            }
        }
    }
}
