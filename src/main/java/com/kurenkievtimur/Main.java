package com.kurenkievtimur;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        char[][] tickTackToe = initTickTackToe();
        print(tickTackToe);

        char symbol = 'X';
        while (!isWinX(tickTackToe) && !isWinZero(tickTackToe) && hasEmptyCell(tickTackToe)) {
            int[] coordinates = enterCoordinates(tickTackToe);

            symbol = fillTickTackToe(tickTackToe, coordinates, symbol);
            print(tickTackToe);
        }

        if (isWinX(tickTackToe))
            System.out.println("X wins");
        else if (isWinZero(tickTackToe))
            System.out.println("O wins");
        else
            System.out.println("Draw");
    }

    public static char[][] initTickTackToe() {
        char[][] tickTackToe = new char[3][3];

        for (char[] chars : tickTackToe) {
            Arrays.fill(chars, '_');
        }

        return tickTackToe;
    }

    public static void print(char[][] tickTackToe) {
        System.out.println("---------");
        for (char[] chars : tickTackToe) {
            System.out.print("| ");
            for (char ch : chars) {
                System.out.printf("%s ", ch);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static int[] enterCoordinates(char[][] tickTackToe) {
        Scanner scanner = new Scanner(System.in);

        int x = 0;
        int y = 0;

        boolean isValid = false;
        do {
            String input = scanner.nextLine();
            try {
                x = Integer.parseInt(input.split(" ")[0]) - 1;
                y = Integer.parseInt(input.split(" ")[1]) - 1;

                isValid = isValidCoordinates(x, y, tickTackToe);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);

        return new int[]{x, y};
    }

    public static boolean isValidCoordinates(int x, int y, char[][] tickTackToe) {
        if (!(x >= 0 && x <= 2) || !(y >= 0 && y <= 2))
            throw new IllegalArgumentException("Coordinates should be from 1 to 3!");
        else if (tickTackToe[x][y] != '_') {
            throw new IllegalArgumentException("This cell is occupied! Choose another one!");
        }

        return true;
    }

    public static char fillTickTackToe(char[][] tickTackToe, int[] coordinates, char symbol) {
        int x = coordinates[0];
        int y = coordinates[1];

        tickTackToe[x][y] = symbol;

        return symbol == 'X' ? 'O' : 'X';
    }

    public static boolean isWinX(char[][] tickTackToe) {
        boolean horizontal1 = tickTackToe[0][0] == 'X' && tickTackToe[0][1] == 'X' && tickTackToe[0][2] == 'X';
        boolean horizontal2 = tickTackToe[1][0] == 'X' && tickTackToe[1][1] == 'X' && tickTackToe[1][2] == 'X';
        boolean horizontal3 = tickTackToe[2][0] == 'X' && tickTackToe[2][1] == 'X' && tickTackToe[2][2] == 'X';

        boolean vertical1 = tickTackToe[0][0] == 'X' && tickTackToe[1][0] == 'X' && tickTackToe[2][0] == 'X';
        boolean vertical2 = tickTackToe[0][1] == 'X' && tickTackToe[1][1] == 'X' && tickTackToe[2][1] == 'X';
        boolean vertical3 = tickTackToe[0][2] == 'X' && tickTackToe[1][2] == 'X' && tickTackToe[2][2] == 'X';

        boolean diagonal1 = tickTackToe[2][0] == 'X' && tickTackToe[1][1] == 'X' && tickTackToe[0][2] == 'X';
        boolean diagonal2 = tickTackToe[0][0] == 'X' && tickTackToe[1][1] == 'X' && tickTackToe[2][2] == 'X';

        boolean isWinHorizontal = horizontal1 || horizontal2 || horizontal3;
        boolean isWinVertical = vertical1 || vertical2 || vertical3;
        boolean isWinDiagonal = diagonal1 || diagonal2;

        return isWinHorizontal || isWinVertical || isWinDiagonal;
    }

    public static boolean isWinZero(char[][] tickTackToe) {
        boolean horizontal1 = tickTackToe[0][0] == 'O' && tickTackToe[0][1] == 'O' && tickTackToe[0][2] == 'O';
        boolean horizontal2 = tickTackToe[1][0] == 'O' && tickTackToe[1][1] == 'O' && tickTackToe[1][2] == 'O';
        boolean horizontal3 = tickTackToe[2][0] == 'O' && tickTackToe[2][1] == 'O' && tickTackToe[2][2] == 'O';

        boolean vertical1 = tickTackToe[0][0] == 'O' && tickTackToe[1][0] == 'O' && tickTackToe[2][0] == 'O';
        boolean vertical2 = tickTackToe[0][1] == 'O' && tickTackToe[1][1] == 'O' && tickTackToe[2][1] == 'O';
        boolean vertical3 = tickTackToe[0][2] == 'O' && tickTackToe[1][2] == 'O' && tickTackToe[2][2] == 'O';

        boolean diagonal1 = tickTackToe[2][0] == 'O' && tickTackToe[1][1] == 'O' && tickTackToe[0][2] == 'O';
        boolean diagonal2 = tickTackToe[0][0] == 'O' && tickTackToe[1][1] == 'O' && tickTackToe[2][2] == 'O';

        boolean isWinHorizontal = horizontal1 || horizontal2 || horizontal3;
        boolean isWinVertical = vertical1 || vertical2 || vertical3;
        boolean isWinDiagonal = diagonal1 || diagonal2;

        return isWinHorizontal || isWinVertical || isWinDiagonal;
    }

    public static boolean hasEmptyCell(char[][] tickTackToe) {
        for (char[] chars : tickTackToe) {
            for (char ch : chars) {
                if (ch == '_') {
                    return true;
                }
            }
        }

        return false;
    }
}


