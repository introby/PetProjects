package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship {
    private int deckOneX;
    private int deckOneY;
    private int deckTwoX;
    private int deckTwoY;
    private int deckThreeX;
    private int deckThreeY;
    private int deckFourX;
    private int deckFourY;
    private List<String> coordinates;

    public static List<String> listP1Ships = new ArrayList<>();

    public Ship(int deckOneX, int deckOneY, int deckTwoX, int deckTwoY, int deckThreeX, int deckThreeY, int deckFourX, int deckFourY) {
        this.deckOneX = deckOneX;
        this.deckOneY = deckOneY;
        this.deckTwoX = deckTwoX;
        this.deckTwoY = deckTwoY;
        this.deckThreeX = deckThreeX;
        this.deckThreeY = deckThreeY;
        this.deckFourX = deckFourX;
        this.deckFourY = deckFourY;
    }

    public Ship(int deckOneX, int deckOneY, int deckTwoX, int deckTwoY, int deckThreeX, int deckThreeY) {
        this.deckOneX = deckOneX;
        this.deckOneY = deckOneY;
        this.deckTwoX = deckTwoX;
        this.deckTwoY = deckTwoY;
        this.deckThreeX = deckThreeX;
        this.deckThreeY = deckThreeY;
    }

    public Ship(int deckOneX, int deckOneY, int deckTwoX, int deckTwoY) {
        this.deckOneX = deckOneX;
        this.deckOneY = deckOneY;
        this.deckTwoX = deckTwoX;
        this.deckTwoY = deckTwoY;
    }

    public Ship(int deckOneX, int deckOneY) {
        this.deckOneX = deckOneX;
        this.deckOneY = deckOneY;
    }

    public Ship() {

    }

    public int getDeckOneX() {
        return deckOneX;
    }

    public void setDeckOneX(int deckOneX) {
        this.deckOneX = deckOneX;
    }

    public int getDeckOneY() {
        return deckOneY;
    }

    public void setDeckOneY(int deckOneY) {
        this.deckOneY = deckOneY;
    }

    public int getDeckTwoX() {
        return deckTwoX;
    }

    public void setDeckTwoX(int deckTwoX) {
        this.deckTwoX = deckTwoX;
    }

    public int getDeckTwoY() {
        return deckTwoY;
    }

    public void setDeckTwoY(int deckTwoY) {
        this.deckTwoY = deckTwoY;
    }

    public int getDeckThreeX() {
        return deckThreeX;
    }

    public void setDeckThreeX(int deckThreeX) {
        this.deckThreeX = deckThreeX;
    }

    public int getDeckThreeY() {
        return deckThreeY;
    }

    public void setDeckThreeY(int deckThreeY) {
        this.deckThreeY = deckThreeY;
    }

    public int getDeckFourX() {
        return deckFourX;
    }

    public void setDeckFourX(int deckFourX) {
        this.deckFourX = deckFourX;
    }

    public int getDeckFourY() {
        return deckFourY;
    }

    public void setDeckFourY(int deckFourY) {
        this.deckFourY = deckFourY;
    }

    public List<String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<String> coordinates) {
        this.coordinates = coordinates;
    }

    public static boolean shipValidator(Ship ship, int numberDeck) {

        switch (numberDeck) {
            case 4: {
                int[] coordinatesX = new int[]{ship.deckOneX, ship.deckTwoX, ship.deckThreeX, ship.deckFourX};
                int[] coordinatesY = new int[]{ship.deckOneY, ship.deckTwoY, ship.deckThreeY, ship.deckFourY};

                Arrays.sort(coordinatesX);
                Arrays.sort(coordinatesY);

                if ((coordinatesX[0] == coordinatesX[1] && coordinatesX[0] == coordinatesX[2] && coordinatesX[0] == coordinatesX[3]
                                    && coordinatesY[0] + 1 == coordinatesY[1] && coordinatesY[0] + 2 == coordinatesY[2] && coordinatesY[0] + 3 == coordinatesY[3])
                        || (coordinatesY[0] == coordinatesY[1] && coordinatesY[0] == coordinatesY[2] && coordinatesY[0] == coordinatesY[3]
                        && coordinatesX[0] + 1 == coordinatesX[1] && coordinatesX[0] + 2 == coordinatesX[2] && coordinatesX[0] + 3 == coordinatesX[3])) {
                    return true;
                }
                return false;

            }
            case 3: {
                int[] coordinatesX = new int[]{ship.deckOneX, ship.deckTwoX, ship.deckThreeX};
                int[] coordinatesY = new int[]{ship.deckOneY, ship.deckTwoY, ship.deckThreeY};

                Arrays.sort(coordinatesX);
                Arrays.sort(coordinatesY);

                if ((coordinatesX[0] == coordinatesX[1] && coordinatesX[0] == coordinatesX[2] && coordinatesY[0] + 1 == coordinatesY[1] && coordinatesY[0] + 2 == coordinatesY[2])
                        || (coordinatesY[0] == coordinatesY[1] && coordinatesY[0] == coordinatesY[2] && coordinatesX[0] + 1 == coordinatesX[1] && coordinatesX[0] + 2 == coordinatesX[2])) {
                    return true;
                }
                return false;

            }
            case 2: {
                int[] coordinatesX = new int[]{ship.deckOneX, ship.deckTwoX};
                int[] coordinatesY = new int[]{ship.deckOneY, ship.deckTwoY};

                Arrays.sort(coordinatesX);
                Arrays.sort(coordinatesY);

                if ((coordinatesX[0] == coordinatesX[1] && coordinatesY[0] + 1 == coordinatesY[1]) || (coordinatesY[0] == coordinatesY[1] && coordinatesX[0] + 1 == coordinatesX[1])) {
                    return true;
                }
                return false;

            }
        }
        return false;

    }

    public static Ship createShip(int numberDeck) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String lineBrutto = reader.readLine();
            String[] lineArr1 = lineBrutto.split(";");
            String[] line = lineBrutto.split(",|;");

            if (lineArr1.length != numberDeck) {
                System.out.println("Неверное число палуб. Введи " + numberDeck + " пар(ы) координат.");

            } else {

                for (String str : lineArr1) {
                    String[] coordinates = str.split(",");
                    if (coordinates.length != 2) {
                        System.out.println("Неверное количество координат для палубы или ты забыл запятую. Введи две координаты.");
                        break;
                    } else {

                        if (Integer.parseInt(coordinates[0]) < 1 || Integer.parseInt(coordinates[0]) > 10 || Integer.parseInt(coordinates[1]) < 1 || Integer.parseInt(coordinates[1]) > 10) {
                            System.out.println("Неверные координаты. Вводи числа от 1 до 10 включительно.");
                            break;
                        }

                        switch (numberDeck) {
                            case 4: {
                                try {
                                    Ship fourDeckShip = new Ship(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]));
                                    return fourDeckShip;
                                } catch (NumberFormatException e) {
                                    System.out.println("Неверный разделитель. Используй запятую для разделения координат x и y.");
                                    ;
                                }
                            }
                            case 3: {
                                try {
                                    Ship threeDecksShip = new Ship(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]));
                                    return threeDecksShip;
                                } catch (NumberFormatException e) {
                                    System.out.println("Неверный разделитель. Используй запятую для разделения координат x и y.");
                                }
                            }
                            case 2: {
                                try {
                                    Ship twoDecksShip = new Ship(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
                                    return twoDecksShip;
                                } catch (NumberFormatException e) {
                                    System.out.println("Неверный разделитель. Используй запятую для разделения координат x и y.");
                                }
                            }
                            case 1: {
                                try {
                                    Ship oneDeckShip = new Ship(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
                                    return oneDeckShip;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    System.out.println("Неверный разделитель. Используй запятую для разделения координат x и y.");
                                }
                            }
                        }

                    }

                }
            }
        }

    }

    public static boolean placementValidator(Battleground bg, Ship ship, int numberDeck) {

        String[][] arrShips = bg.getBattleground();

        switch (numberDeck) {
            case 3: {
                if (arrShips[ship.deckOneY - 1][ship.deckOneX - 1].equals("\uD83D\uDFE6") && arrShips[ship.deckTwoY - 1][ship.deckTwoX - 1].equals("\uD83D\uDFE6") && arrShips[ship.deckThreeY - 1][ship.deckThreeX - 1].equals("\uD83D\uDFE6")) {
                    return true;
                }
            }
            case 2: {
                if (arrShips[ship.deckOneY - 1][ship.deckOneX - 1].equals("\uD83D\uDFE6") && arrShips[ship.deckTwoY - 1][ship.deckTwoX - 1].equals("\uD83D\uDFE6")) {
                    return true;
                }
            }
            case 1: {
                if (arrShips[ship.deckOneY - 1][ship.deckOneX - 1].equals("\uD83D\uDFE6")) {
                    return true;
                }
            }

        }

        return false;
    }

    public static String[][] placementOfShips(Ship ship, String[][] arrShips, int numberDeck) {

        switch (numberDeck) {
            case 4:

                int[] coordinatesX = new int[]{ship.deckOneX, ship.deckTwoX, ship.deckThreeX, ship.deckFourX};
                int[] coordinatesY = new int[]{ship.deckOneY, ship.deckTwoY, ship.deckThreeY, ship.deckFourY};

                Arrays.sort(coordinatesX);
                Arrays.sort(coordinatesY);

                int leftCornerHaloX = coordinatesX[0] - 2;
                int leftCornerHaloY = coordinatesY[0] - 2;

                if (coordinatesY[0] == coordinatesY[1]) {
                    for (int i = leftCornerHaloY; i < leftCornerHaloY + 3; i++) {
                        for (int j = leftCornerHaloX; j < leftCornerHaloX + 6; j++) {
                            if (i >= 0 && j >= 0 && i <= 9 && j <= 9)
                                arrShips[i][j] = "*️⃣";

                        }
//                        System.out.println();

                    }
                } else {
                    for (int i = leftCornerHaloY; i < leftCornerHaloY + 6; i++) {
                        for (int j = leftCornerHaloX; j < leftCornerHaloX + 3; j++) {
                            if (i >= 0 && j >= 0 && i <= 9 && j <= 9)
                                arrShips[i][j] = "*️⃣";

                        }
//                        System.out.println();

                    }
                }


                arrShips[ship.deckOneY - 1][ship.deckOneX - 1] = "\uD83D\uDFE5";
                arrShips[ship.deckTwoY - 1][ship.deckTwoX - 1] = "\uD83D\uDFE5";
                arrShips[ship.deckThreeY - 1][ship.deckThreeX - 1] = "\uD83D\uDFE5";
                arrShips[ship.deckFourY - 1][ship.deckFourX - 1] = "\uD83D\uDFE5";
                return arrShips;

            case 3:

                coordinatesX = new int[]{ship.deckOneX, ship.deckTwoX, ship.deckThreeX};
                coordinatesY = new int[]{ship.deckOneY, ship.deckTwoY, ship.deckThreeY};

                Arrays.sort(coordinatesX);
                Arrays.sort(coordinatesY);

                leftCornerHaloX = coordinatesX[0] - 2;
                leftCornerHaloY = coordinatesY[0] - 2;

                if (coordinatesY[0] == coordinatesY[1]) {
                    for (int i = leftCornerHaloY; i < leftCornerHaloY + 3; i++) {
                        for (int j = leftCornerHaloX; j < leftCornerHaloX + 5; j++) {
                            if (i >= 0 && j >= 0 && i <= 9 && j <= 9)
                                arrShips[i][j] = "*️⃣";

                        }
//                        System.out.println();

                    }
                } else {
                    for (int i = leftCornerHaloY; i < leftCornerHaloY + 5; i++) {
                        for (int j = leftCornerHaloX; j < leftCornerHaloX + 3; j++) {
                            if (i >= 0 && j >= 0 && i <= 9 && j <= 9)
                                arrShips[i][j] = "*️⃣";

                        }
//                        System.out.println();

                    }
                }

                arrShips[ship.deckOneY - 1][ship.deckOneX - 1] = "\uD83D\uDFE5";
                arrShips[ship.deckTwoY - 1][ship.deckTwoX - 1] = "\uD83D\uDFE5";
                arrShips[ship.deckThreeY - 1][ship.deckThreeX - 1] = "\uD83D\uDFE5";
                return arrShips;

            case 2:

                coordinatesX = new int[]{ship.deckOneX, ship.deckTwoX};
                coordinatesY = new int[]{ship.deckOneY, ship.deckTwoY};

                Arrays.sort(coordinatesX);
                Arrays.sort(coordinatesY);

                leftCornerHaloX = coordinatesX[0] - 2;
                leftCornerHaloY = coordinatesY[0] - 2;

                if (coordinatesY[0] == coordinatesY[1]) {
                    for (int i = leftCornerHaloY; i < leftCornerHaloY + 3; i++) {
                        for (int j = leftCornerHaloX; j < leftCornerHaloX + 4; j++) {
                            if (i >= 0 && j >= 0 && i <= 9 && j <= 9)
                                arrShips[i][j] = "*️⃣";

                        }
//                        System.out.println();

                    }
                } else {
                    for (int i = leftCornerHaloY; i < leftCornerHaloY + 4; i++) {
                        for (int j = leftCornerHaloX; j < leftCornerHaloX + 3; j++) {
                            if (i >= 0 && j >= 0 && i <= 9 && j <= 9)
                                arrShips[i][j] = "*️⃣";

                        }
//                        System.out.println();

                    }
                }

                arrShips[ship.deckOneY - 1][ship.deckOneX - 1] = "\uD83D\uDFE5";
                arrShips[ship.deckTwoY - 1][ship.deckTwoX - 1] = "\uD83D\uDFE5";
                return arrShips;

            case 1:

                leftCornerHaloX = ship.deckOneX - 2;
                leftCornerHaloY = ship.deckOneY - 2;

                for (int i = leftCornerHaloY; i < leftCornerHaloY + 3; i++) {
                    for (int j = leftCornerHaloX; j < leftCornerHaloX + 3; j++) {
                        if (i >= 0 && j >= 0 && i <= 9 && j <= 9)
                            arrShips[i][j] = "*️⃣";

                    }
//                    System.out.println();

                }

                arrShips[ship.deckOneY - 1][ship.deckOneX - 1] = "\uD83D\uDFE5";
                return arrShips;

        }
        return arrShips;
    }

    public static void shipToList(Player player) {

        List<String> fourDecksShipList = new ArrayList<>();
        List<String> threeDecksShip1List = new ArrayList<>();
        List<String> threeDecksShip2List = new ArrayList<>();
        List<String> twoDecksShip1List = new ArrayList<>();
        List<String> twoDecksShip2List = new ArrayList<>();
        List<String> twoDecksShip3List = new ArrayList<>();
        List<String> oneDeckShip1List = new ArrayList<>();
        List<String> oneDeckShip2List = new ArrayList<>();
        List<String> oneDeckShip3List = new ArrayList<>();
        List<String> oneDeckShip4List = new ArrayList<>();

        fourDecksShipList.add(player.fourDecksShip.deckOneX + "," + player.fourDecksShip.deckOneY);
        fourDecksShipList.add(player.fourDecksShip.deckTwoX + "," + player.fourDecksShip.deckTwoY);
        fourDecksShipList.add(player.fourDecksShip.deckThreeX + "," + player.fourDecksShip.deckThreeY);
        fourDecksShipList.add(player.fourDecksShip.deckFourX + "," + player.fourDecksShip.deckFourY);
        player.fourDecksShip.setCoordinates(fourDecksShipList);

        threeDecksShip1List.add(player.threeDecksShip1.deckOneX + "," + player.threeDecksShip1.deckOneY);
        threeDecksShip1List.add(player.threeDecksShip1.deckTwoX + "," + player.threeDecksShip1.deckTwoY);
        threeDecksShip1List.add(player.threeDecksShip1.deckThreeX + "," + player.threeDecksShip1.deckThreeY);
        player.threeDecksShip1.setCoordinates(threeDecksShip1List);

        threeDecksShip2List.add(player.threeDecksShip2.deckOneX + "," + player.threeDecksShip2.deckOneY);
        threeDecksShip2List.add(player.threeDecksShip2.deckTwoX + "," + player.threeDecksShip2.deckTwoY);
        threeDecksShip2List.add(player.threeDecksShip2.deckThreeX + "," + player.threeDecksShip2.deckThreeY);
        player.threeDecksShip2.setCoordinates(threeDecksShip2List);


        twoDecksShip1List.add(player.twoDecksShip1.deckOneX + "," + player.twoDecksShip1.deckOneY);
        twoDecksShip1List.add(player.twoDecksShip1.deckTwoX + "," + player.twoDecksShip1.deckTwoY);
        player.twoDecksShip1.setCoordinates(twoDecksShip1List);


        twoDecksShip2List.add(player.twoDecksShip2.deckOneX + "," + player.twoDecksShip2.deckOneY);
        twoDecksShip2List.add(player.twoDecksShip2.deckTwoX + "," + player.twoDecksShip2.deckTwoY);
        player.twoDecksShip2.setCoordinates(twoDecksShip2List);

        twoDecksShip3List.add(player.twoDecksShip3.deckOneX + "," + player.twoDecksShip3.deckOneY);
        twoDecksShip3List.add(player.twoDecksShip3.deckTwoX + "," + player.twoDecksShip3.deckTwoY);
        player.twoDecksShip3.setCoordinates(twoDecksShip3List);

        oneDeckShip1List.add(player.oneDeckShip1.deckOneX + "," + player.oneDeckShip1.deckOneY);
        player.oneDeckShip1.setCoordinates(oneDeckShip1List);

        oneDeckShip2List.add(player.oneDeckShip2.deckOneX + "," + player.oneDeckShip2.deckOneY);
        player.oneDeckShip2.setCoordinates(oneDeckShip2List);

        oneDeckShip3List.add(player.oneDeckShip3.deckOneX + "," + player.oneDeckShip3.deckOneY);
        player.oneDeckShip3.setCoordinates(oneDeckShip3List);

        oneDeckShip4List.add(player.oneDeckShip4.deckOneX + "," + player.oneDeckShip4.deckOneY);
        player.oneDeckShip4.setCoordinates(oneDeckShip4List);


    }





}
