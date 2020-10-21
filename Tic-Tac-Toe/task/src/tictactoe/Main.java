package tictactoe;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    static char[][] arr = new char[5][9];

    public static void printBoard() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void creatBoard() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 9; ++j) {
                arr[i][j] = ' ';
            }
        }
        for (int i = 0; i < 9; ++i) {
            arr[0][i] = '-';
            arr[4][i] = '-';
        }
        for (int i = 1; i < 4; ++i) {
            arr[i][0] = '|';
            arr[i][8] = '|';
        }
    }

    public static boolean checkStatus() {
        int x = 1, y = 2;
        int xCounter = 0, oCounter = 0;
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (arr[i][j] == 'X')
                    xCounter++;
                else if (arr[i][j] == 'O')
                    oCounter++;
            }

        }


        boolean xWin = false, oWin = false;
        for (int i = 1; i <= 3; i++) {
            if (arr[i][2] == arr[i][4] && arr[i][4] == arr[i][6]) {
                if (arr[i][2] == 'X')
                    xWin = true;
                else if (arr[i][2] == 'O')
                    oWin = true;
            }
        }


        for (int i = 2; i <= 6; i += 2) {
            if (arr[1][i] == arr[2][i] && arr[2][i] == arr[3][i]) {
                if (arr[1][i] == 'X')
                    xWin = true;
                else if (arr[1][i] == 'O')
                    oWin = true;

            }
        }
        if (arr[1][2] == arr[2][4] && arr[2][4] == arr[3][6]) {
            if (arr[1][2] == 'X')
                xWin = true;
            else if (arr[1][2] == 'O')
                oWin = true;

        }
        if (arr[3][2] == arr[2][4] && arr[2][4] == arr[1][6]) {
            if (arr[3][2] == 'X')
                xWin = true;
            else if (arr[3][2] == 'O')
                oWin = true;

        }

        if (xWin) {
            System.out.println("X wins");
            return true;
        } else if (oWin) {
            System.out.println("O wins");
            return true;
        } else if (xCounter + oCounter != 9)
            return false;
        else
            System.out.println("Draw");
        return true;
    }


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        creatBoard();
        printBoard();
        int userX, userY;
        int turn = 1;
        while (true) {
            char sym;
            if (turn % 2 == 1) {
                sym = 'X';
            } else
                sym = 'O';
            turn++;
            while (true) {
                System.out.print("Enter the coordinates: ");
                userX = 0;
                userY = 0;


                if (sc.hasNextInt()) {
                    userY = sc.nextInt();
                    if (sc.hasNextInt()) {
                        userX = sc.nextInt();
                    } else {
                        System.out.println("You should enter numbers!");

                        continue;
                    }
                } else {
                    System.out.println("You should enter numbers!");
                    sc.nextLine();


                    continue;
                }

                if (userX == 3)
                    userX = 1;
                else if (userX == 1)
                    userX = 3;
                if (userX < 1 || userX > 3 || userY < 1 || userY > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                if (arr[userX][userY * 2] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                break;

            }

            arr[userX][userY * 2] = sym;
            printBoard();
            if (checkStatus())
                break;


        }

    }


}
