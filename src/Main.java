import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Choose game mode:");
        System.out.println("1. Play one round");
        System.out.println("2. Play three rounds (best of 3)");
        int mode = input.nextInt();

        int rounds;

        if (mode == 2) {
            rounds = 3;
        } else {
            rounds = 1;
        }

        int xWins = 0;
        int oWins = 0;

        for (int r = 1; r <= rounds; r++) {
            char[][] board = {
                    {'1', '2', '3'},
                    {'4', '5', '6'},
                    {'7', '8', '9'}
            };

            char player = 'X';
            int number;
            int row = 10;
            int col = 10;

            System.out.println("\nRound " + r);

            for (int i = 0; i < 9; i++) {

                printBoard(board);

                if (player == 'X') {
                    System.out.println("Player X enter number (1-9): ");
                    number = input.nextInt();
                } else {
                    number = random.nextInt(1, 10);
                    System.out.println("Computer choose: " + number);
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
                        System.out.println("Position already taken, enter a valid position.");
                        i--;
                    } else {
                        i--;
                    }
                    continue;
                }


                board[row][col] = player;

                if (checkWin(board, player)) {
                    printBoard(board);
                    System.out.println("Player " + player + " Wins Round " + r);
                    if (player == 'X') {
                        xWins++;
                    } else oWins++;
                    break;
                }


                if (player == 'X') {
                    player = 'O';
                } else
                    player = 'X';

            }
            if (mode == 2) {
                if (xWins == 2 || oWins == 2)
                    break;
            }
        }
        System.out.println("Final Result: ");
        System.out.println("Player X Wins: " + xWins);
        System.out.println("Bot Wins: " + oWins);

        if (xWins > oWins) {
            System.out.println("Player X is the Winner!");
        } else if (oWins > xWins) {
            System.out.println("Bot is the Winner!");
        } else System.out.println("Draw!");

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
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;


    }
}