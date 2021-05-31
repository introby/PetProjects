package cinema;

import java.util.Scanner;

public class Cinema {

    private static int ticketsSold = 0;
    private static int roomCapacity = 0;
    private static int currentIncome = 0;
    private static int totalIncome = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rowsNumber = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsNumber = scanner.nextInt();
        roomCapacity = rowsNumber * seatsNumber;

        if (roomCapacity <= 60) {
            totalIncome = roomCapacity * 10;
        } else {
            totalIncome = rowsNumber / 2 * seatsNumber * 10 + (rowsNumber - rowsNumber / 2) * seatsNumber * 8;
        }

        System.out.println();

        String[][] room = new String[rowsNumber + 1][seatsNumber + 1];
        boolean exit = false;
        int menuNum;

        drawRoom(room, false);

        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            menuNum = scanner.nextInt();

            switch (menuNum) {
                case 1:
                    drawRoom(room, true);
                    break;
                case 2:
                    booking(room, scanner, rowsNumber, seatsNumber);
                    break;
                case 3:
                    showStatistic();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println();
                    break;
            }
            if (exit) {
                break;
            }
        }

    }

    private static void showStatistic() {
        System.out.println();
        System.out.printf("Number of purchased tickets: %d%n", ticketsSold);
        double percentage = (double) ticketsSold / roomCapacity * 100;
        System.out.printf("Percentage: %.2f%%", percentage);
        System.out.println();
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d", totalIncome);
        System.out.println();
        System.out.println();

    }

    private static void booking(String[][] room, Scanner scanner, int rowsNumber, int seatsNumber) {
        System.out.println();
        int placeRow;
        int placeSeat;
        while (true) {
            System.out.println("Enter a row number:");
            placeRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            placeSeat = scanner.nextInt();

            if (placeRow > 0 && placeRow <= rowsNumber && placeSeat > 0 && placeSeat <= seatsNumber) {
                if (!room[placeRow][placeSeat].equals("B ")) {
                    break;
                } else {
                    System.out.println();
                    System.out.println("That ticket has already been purchased!");
                    System.out.println();
                }
            } else {
                System.out.println("Wrong input!");
            }

        }

        int ticketPrice = 0;
        if (roomCapacity <= 60) {
            ticketPrice = 10;
        } else if (placeRow < (room.length + 1) / 2) {
            ticketPrice = 10;
        } else {
            ticketPrice = 8;
        }

        System.out.println();
        System.out.println("Ticket price: $" + ticketPrice);
        ticketsSold++;
        currentIncome += ticketPrice;
        System.out.println();

        room[placeRow][placeSeat] = "B ";

    }

    public static void drawRoom(String[][] room, boolean draw) {

        room[0][0] = "  ";
        for (int i = 1; i < room[0].length; i++) {
            room[0][i] = i + " ";
        }

        int firstColumn = 0;
        for (int i = 1; i < room.length; i++) {
            room[i][firstColumn] = i + " ";
            for (int j = 1; j < room[i].length; j++) {
                if (room[i][j] == null) {
                    room[i][j] = "S ";
                } else if (!room[i][j].equals("B ")) {
                    room[i][j] = "S ";
                }

            }
        }

        if (draw) {
            System.out.println();
            System.out.println("Cinema:");
            for (int i = 0; i < room.length; i++) {
                for (int j = 0; j < room[i].length; j++) {
                    System.out.print(room[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }


}