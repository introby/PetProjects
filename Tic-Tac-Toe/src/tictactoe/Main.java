package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] arr = {{"---------"}, {"| ", "  ", "  ", "  ", "|"}, {"| ", "  ", "  ", "  ", "|"}, {"| ", "  ", "  ", "  ", "|"}, {"---------"}};

        drawField(arr);

        int xCount = 0;
        int oCount = 0;
        String result = null;
        String coordinateOneString;
        String coordinateTwoString;
        int coordinateOne;
        int coordinateTwo;

        for (int i = 1; i < 10; i++) {

            while (true) {
                System.out.print("Enter the coordinates: ");

                coordinateOneString = scanner.next();

                if (coordinateOneString.matches("[-+]?\\d+")) {
                    coordinateTwoString = scanner.next();
                    if (coordinateTwoString.matches("[-+]?\\d+")) {
                        coordinateOne = Integer.parseInt(coordinateOneString);
                        coordinateTwo = Integer.parseInt(coordinateTwoString);
                        if (coordinateOne < 1 || coordinateOne > 3 || coordinateTwo < 1 || coordinateTwo > 3) {
                            System.out.println("Coordinates should be from 1 to 3!");
                        } else {
                            if (arr[coordinateOne][coordinateTwo].equals("  ")) {
                                if (i % 2 !=0) {
                                    arr[coordinateOne][coordinateTwo] = "X ";
                                    xCount++;
                                    break;
                                } else {
                                    arr[coordinateOne][coordinateTwo] = "O ";
                                    oCount++;
                                    break;
                                }

                            } else {
                                System.out.println("This cell is occupied! Choose another one!");
                            }
                        }
                    } else {
                        System.out.println("You should enter numbers!");
                    }

                } else {
                    System.out.println("You should enter numbers!");
                    scanner.nextLine();
                }

            }

            if (Math.abs(xCount - oCount) > 1) {
                System.out.println("Impossible");
            } else {
                result = check(arr, i);
                if (!result.equals("winner")) {
                    break;
                }
            }

            drawField(arr);

        }

        drawField(arr);
        System.out.println(result);

    }

    private static void drawField(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);

            }
            System.out.println();
        }
    }

    public static String check(String[][] arr, int i) {
        String result = "winner";
        if ((arr[2][2].equals("X ") && arr[1][1].equals("X ") && arr[3][3].equals("X "))
                || (arr[3][1].equals("X ") && arr[2][2].equals("X ") && arr[1][3].equals("X "))
                || (arr[1][2].equals("X ") && arr[2][2].equals("X ") && arr[3][2].equals("X "))
                || (arr[2][1].equals("X ") && arr[2][2].equals("X ") && arr[2][3].equals("X "))
                || (arr[1][1].equals("X ") && arr[1][2].equals("X ") && arr[1][3].equals("X "))
                || (arr[1][1].equals("X ") && arr[2][1].equals("X ") && arr[3][1].equals("X "))
                || (arr[3][1].equals("X ") && arr[3][2].equals("X ") && arr[3][3].equals("X "))
                || (arr[1][3].equals("X ") && arr[2][3].equals("X ") && arr[3][3].equals("X "))) {
            result = "X wins";
        }
        if ((arr[2][2].equals("O ") && arr[1][1].equals("O ") && arr[3][3].equals("O "))
                || (arr[3][1].equals("O ") && arr[2][2].equals("O ") && arr[1][3].equals("O "))
                || (arr[1][2].equals("O ") && arr[2][2].equals("O ") && arr[3][2].equals("O "))
                || (arr[2][1].equals("O ") && arr[2][2].equals("O ") && arr[2][3].equals("O "))
                || (arr[1][1].equals("O ") && arr[1][2].equals("O ") && arr[1][3].equals("O "))
                || (arr[1][1].equals("O ") && arr[2][1].equals("O ") && arr[3][1].equals("O "))
                || (arr[3][1].equals("O ") && arr[3][2].equals("O ") && arr[3][3].equals("O "))
                || (arr[1][3].equals("O ") && arr[2][3].equals("O ") && arr[3][3].equals("O "))) {
            if (result.equals("X wins")) {
                result = "Impossible";
            } else {
                result = "O wins";
            }

        }

        if (result.equals("winner") && i == 9) {
            result = "Draw";
        }
        return result;
    }


}
