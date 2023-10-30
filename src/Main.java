import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize char to display the array
        char [][] table = {
                {'1','2','3'},
                {'4','5','6'},
                {'7','8','9'}
        };

        // initialize an int to play it
        int round = 1;
        boolean victory = false;

        while (!victory) {
            displaysTheGrid(table);

            int choice;

            if (round == 1) {
                choice = requestRound("Player X, select a box (1-9) : ");
            } else {
                choice = requestRound("Player 0, select a box (1-9) : ");
            }

            if (placeCoup(table, choice, round)) {
                victory = verifyVictory(table, round);
                if (victory) {
                    displaysTheGrid(table);
                    System.out.println("the player " + (round == 1 ? "X" : "O") + " to win");
                } else if (completedTable(table)) {
                    displaysTheGrid(table);
                    System.out.println("egality");
                    break;
                }
                round = (round == 1) ? 2 : 1;
            } else {
                System.out.println("box filled, please try again");
            }
        }
    }

    //Displays the tic-tac-toe grid
    public static void displaysTheGrid(char[][] table) {
        for (int line = 0; line < 3; line++) {
            for (int colonne = 0; colonne < 3; colonne++) {
                System.out.print(table[line][colonne]);
                if (colonne < 2) {
                    System.out.print(" | ");
                }

            }
            System.out.println();

            if (line < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }


    //Ask the player to choose a square
    public static int requestRound(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }



    //place a shot on the grid
    public static boolean placeCoup(char[][] table, int choice, int round) {
        char symbol = (round == 1) ? 'X' : 'O';
        for (int line = 0; line < 3; line++) {
            for (int colonne = 0; colonne < 3; colonne++) {
                if (table[line][colonne] == Character.forDigit(choice, 10)) {
                    table[line][colonne] = symbol;
                    return true;
                }
            }
        }
        return false;
    }




    //checks whether a player has won

    public static boolean verifyVictory(char[][] table, int round) {
        char symbol = (round == 1) ? 'X' : 'O';

        // check row and column
        for (int i = 0; i < 3; i++) {
            // check horizontal
            if (table[i][0] == symbol && table[i][1] == symbol && table[i][2] == symbol) {
                return true;
            }
            // check vertical
            if (table[0][i] == symbol && table[1][0] == symbol && table[2][i] == symbol) {
                return true;
            }
        }

        // check diagonal lines
        // check from left to right
        if (table[0][0] == symbol && table[1][1] == symbol && table[2][2] == symbol) {
            return true;
        }
        // check from right to left
        if (table[2][2] == symbol && table[1][1] == symbol && table[2][0] == symbol) {
            return true;
        }
        return false;
    }




    public static boolean completedTable(char[][] table) {
        for (int line = 0; line < 3; line++) {
            for (int colonne = 0; colonne < 3; colonne++){
                if (table[line][colonne] != 'X' && table[line][colonne] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
}
