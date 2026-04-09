import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        char[][] board = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };
        char player = 'X';
        int number = 0;
        int row = 10;
        int col = 10;

        for (int i = 0; i < 9; i++) {
            printBoard(board);

            if (player == 'X') {
                System.out.println("Player X enter number (1-9): ");
                number = input.nextInt();
            }else{
                number = random.nextInt(0,10);
            }
            switch (number) {
                case 1:
                    row = 0;
                    col = 0;
                    break;
                case 2:
                    row = 0;
                    col = 1;
                    break;
                case 3:
                    row = 0;
                    col = 2;
                    break;
                case 4: {
                    row = 1;
                    col = 0;
                    break;
                }
                case 5: {
                    row = 1;
                    col = 1;
                    break;
                }
                case 6: {
                    row = 1;
                    col = 2;
                    break;
                }
                case 7: {
                    row = 2;
                    col = 0;
                    break;
                }
                case 8: {
                    row = 2;
                    col = 1;
                    break;
                }
                case 9: {
                    row = 2;
                    col = 2;
                    break;
                }
            }


            if (board[row][col] == 'X' || board[row][col] == 'O') {
                if (player == 'X') {
                    System.out.println("Position already taken, try again.");
                    i--;
                } else {
                    i--;
                }
                continue;
            }

            board[row][col] = player;

            if (checkWin(board, player)) {
                printBoard(board);
                System.out.println("Player " + player + " Wins!");
                break;
            }

            if (player == 'X') {
                player = 'O';
            }
            else
                player = 'X';

        }

    }

    public static void printBoard(char[][] board) {

        System.out.println();

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------");
        }
    }
    public static boolean checkWin(char[][] board, char player) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player)
                return true;
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player &&
                    board[1][i] == player &&
                    board[2][i] == player)
                return true;
        }

        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player)
            return true;

        if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player)
            return true;

        return false;


    }
}