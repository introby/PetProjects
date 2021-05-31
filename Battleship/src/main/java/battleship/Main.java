package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        Player player1 = new Player("Боцман");
        Player player2 = new Player("Шкипер");

        Battleground bg1 = new Battleground();
        Battleground bg2 = new Battleground();

        System.out.println("Начинаем расстановку кораблей. Сначала игрок 1 - " + player1.getName() + ". Соперник, не подсматривай!");

        for (int i = 1; i < 3; i++) {

            String[][] arrShips = new String[][]{{"\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6"},
                    {"\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6"},
                    {"\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6"},
                    {"\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6"},
                    {"\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6"},
                    {"\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6"},
                    {"\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6"},
                    {"\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6"},
                    {"\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6"},
                    {"\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6", "\uD83D\uDFE6"}};

            Battleground bg = new Battleground(arrShips);

            bg.print();

            System.out.println("Введи координаты четырехпалубного корабля (формат x,y;x,y;x,y;x,y):");
            while (true) {
                Ship fourDecksShip = Ship.createShip(4);
                if (Ship.shipValidator(fourDecksShip, 4)) {
                    Ship.placementOfShips(fourDecksShip, arrShips, 4);
                    if (i == 1) {
                        player1.setFourDecksShip(fourDecksShip);
                    } else player2.setFourDecksShip(fourDecksShip);
                    break;
                }
                System.out.println("Невалидный корабль. Палубы должны идти подряд в одну линию. Давай еще раз:");
            }

            System.out.println("Введи координаты первого трехпалубного корабля (формат x,y;x,y;x,y):");
            while (true) {
                Ship threeDecksShip1 = Ship.createShip(3);
                if (Ship.shipValidator(threeDecksShip1, 3)) {
                    if (Ship.placementValidator(bg, threeDecksShip1, 3)) {
                        Ship.placementOfShips(threeDecksShip1, arrShips, 3);
                        if (i == 1) {
                            player1.setThreeDecksShip1(threeDecksShip1);
                        } else player2.setThreeDecksShip1(threeDecksShip1);
                        break;
                    } else System.out.println("Нельзя размещать корабли вплотную к другим кораблям. Давай еще раз:");

                } else System.out.println("Невалидный корабль. Палубы должны идти подряд в одну линию. Давай еще раз:");
            }

            System.out.println("Введи координаты второго трехпалубного корабля (формат x,y;x,y;x,y):");
            while (true) {
                Ship threeDecksShip2 = Ship.createShip(3);
                if (Ship.shipValidator(threeDecksShip2, 3)) {
                    if (Ship.placementValidator(bg, threeDecksShip2, 3)) {
                        Ship.placementOfShips(threeDecksShip2, arrShips, 3);
                        if (i == 1) {
                            player1.setThreeDecksShip2(threeDecksShip2);
                        } else player2.setThreeDecksShip2(threeDecksShip2);
                        break;
                    } else System.out.println("Нельзя размещать корабли вплотную к другим кораблям. Давай еще раз:");

                } else System.out.println("Невалидный корабль. Палубы должны идти подряд в одну линию. Давай еще раз:");
            }

            System.out.println("Введи координаты первого двухпалубного корабля (формат x,y;x,y):");
            while (true) {
                Ship twoDecksShip1 = Ship.createShip(2);
                if (Ship.shipValidator(twoDecksShip1, 2)) {
                    if (Ship.placementValidator(bg, twoDecksShip1, 2)) {
                        Ship.placementOfShips(twoDecksShip1, arrShips, 2);
                        if (i == 1) {
                            player1.setTwoDecksShip1(twoDecksShip1);
                        } else player2.setTwoDecksShip1(twoDecksShip1);
                        break;
                    } else System.out.println("Нельзя размещать корабли вплотную к другим кораблям. Давай еще раз:");

                } else System.out.println("Невалидный корабль. Палубы должны идти подряд в одну линию. Давай еще раз:");
            }

            System.out.println("Введи координаты второго двухпалубного корабля (формат x,y;x,y):");
            while (true) {
                Ship twoDecksShip2 = Ship.createShip(2);
                if (Ship.shipValidator(twoDecksShip2, 2)) {
                    if (Ship.placementValidator(bg, twoDecksShip2, 2)) {
                        Ship.placementOfShips(twoDecksShip2, arrShips, 2);
                        if (i == 1) {
                            player1.setTwoDecksShip2(twoDecksShip2);
                        } else player2.setTwoDecksShip2(twoDecksShip2);
                        break;
                    } else System.out.println("Нельзя размещать корабли вплотную к другим кораблям. Давай еще раз:");

                } else System.out.println("Невалидный корабль. Палубы должны идти подряд в одну линию. Давай еще раз:");
            }

            System.out.println("Введи координаты третьего двухпалубного корабля (формат x,y;x,y):");
            while (true) {
                Ship twoDecksShip3 = Ship.createShip(2);
                if (Ship.shipValidator(twoDecksShip3, 2)) {
                    if (Ship.placementValidator(bg, twoDecksShip3, 2)) {
                        Ship.placementOfShips(twoDecksShip3, arrShips, 2);
                        if (i == 1) {
                            player1.setTwoDecksShip3(twoDecksShip3);
                        } else player2.setTwoDecksShip3(twoDecksShip3);
                        break;
                    } else System.out.println("Нельзя размещать корабли вплотную к другим кораблям. Давай еще раз:");

                } else System.out.println("Невалидный корабль. Палубы должны идти подряд в одну линию. Давай еще раз:");
            }

            System.out.println("Введи координаты первого однопалубного корабля (формат x,y):");
            while (true) {
                Ship oneDecksShip1 = Ship.createShip(1);
                if (Ship.placementValidator(bg, oneDecksShip1, 1)) {
                    Ship.placementOfShips(oneDecksShip1, arrShips, 1);
                    if (i == 1) {
                        player1.setOneDeckShip1(oneDecksShip1);
                    } else player2.setOneDeckShip1(oneDecksShip1);
                    break;
                } else System.out.println("Нельзя размещать корабли вплотную к другим кораблям. Давай еще раз:");
            }

            System.out.println("Введи координаты второго однопалубного корабля (формат x,y):");
            while (true) {
                Ship oneDecksShip2 = Ship.createShip(1);
                if (Ship.placementValidator(bg, oneDecksShip2, 1)) {
                    Ship.placementOfShips(oneDecksShip2, arrShips, 1);
                    if (i == 1) {
                        player1.setOneDeckShip2(oneDecksShip2);
                    } else player2.setOneDeckShip2(oneDecksShip2);
                    break;
                } else System.out.println("Нельзя размещать корабли вплотную к другим кораблям. Давай еще раз:");
            }

            System.out.println("Введи координаты третьего однопалубного корабля (формат x,y):");
            while (true) {
                Ship oneDecksShip3 = Ship.createShip(1);
                if (Ship.placementValidator(bg, oneDecksShip3, 1)) {
                    Ship.placementOfShips(oneDecksShip3, arrShips, 1);
                    if (i == 1) {
                        player1.setOneDeckShip3(oneDecksShip3);
                    } else player2.setOneDeckShip3(oneDecksShip3);
                    break;
                } else System.out.println("Нельзя размещать корабли вплотную к другим кораблям. Давай еще раз:");
            }

            System.out.println("Введи координаты четвертого однопалубного корабля (формат x,y):");
            while (true) {
                Ship oneDecksShip4 = Ship.createShip(1);
                if (Ship.placementValidator(bg, oneDecksShip4, 1)) {
                    Ship.placementOfShips(oneDecksShip4, arrShips, 1);
                    if (i == 1) {
                        player1.setOneDeckShip4(oneDecksShip4);
                    } else player2.setOneDeckShip4(oneDecksShip4);
                    break;
                } else System.out.println("Нельзя размещать корабли вплотную к другим кораблям. Давай еще раз:");
            }

            if (i == 1) {
                bg1.setBattleground(arrShips);
                System.out.println("Теперь очередь Игрока 2 - " + player2.getName() + " расставлять корабли.");
            } else bg2.setBattleground(arrShips);
//

        }


        player1.setBg(bg1);
        player2.setBg(bg2);

        Ship.shipToList(player1);
        Ship.shipToList(player2);

        game(player1, player2);


    }

    public static void game(Player player1, Player player2) throws IOException {
        Player shootingPlayer;
        Player targetPlayer;
        String shot;

        String[][] arrShipsPlayer1 = player1.getBg().getBattleground();
        String[][] arrShipsPlayer2 = player2.getBg().getBattleground();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int startPlayer = (int) (Math.random() * 2) + 1;

        if (startPlayer == 1) {
            shootingPlayer = player1;
            targetPlayer = player2;
        } else {
            shootingPlayer = player2;
            targetPlayer = player1;
        }

        while (true) {

            if (targetPlayer.getFourDecksShip().getCoordinates().size() != 0 || targetPlayer.getThreeDecksShip1().getCoordinates().size() != 0 || targetPlayer.getThreeDecksShip2().getCoordinates().size() != 0 ||
                    targetPlayer.getTwoDecksShip1().getCoordinates().size() != 0 || targetPlayer.getTwoDecksShip2().getCoordinates().size() != 0 || targetPlayer.getTwoDecksShip3().getCoordinates().size() != 0 ||
                    targetPlayer.getOneDeckShip1().getCoordinates().size() != 0 || targetPlayer.getOneDeckShip2().getCoordinates().size() != 0 || targetPlayer.getOneDeckShip3().getCoordinates().size() != 0 ||
                    targetPlayer.getOneDeckShip4().getCoordinates().size() != 0) {

                System.out.println(shootingPlayer.getName() + " стреляет по координатам:");
                shot = reader.readLine();
                String[] shotCoordinates = shot.split(",");
                int x = Integer.parseInt(shotCoordinates[0]) - 1;
                int y = Integer.parseInt(shotCoordinates[1]) - 1;

                if (targetPlayer.getFourDecksShip().getCoordinates().contains(shot)) {
                    switch (targetPlayer.getFourDecksShip().getCoordinates().size()) {
                        case 4:
                        case 3:
                        case 2:
                            System.out.println("Ранил");
                            targetPlayer.getFourDecksShip().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                        case 1:
                            System.out.println("Потопил");
                            targetPlayer.getFourDecksShip().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                    }
                } else if (targetPlayer.getThreeDecksShip1().getCoordinates().contains(shot)) {
                    switch (targetPlayer.getThreeDecksShip1().getCoordinates().size()) {
                        case 3:
                        case 2:
                            System.out.println("Ранил");
                            targetPlayer.getThreeDecksShip1().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                        case 1:
                            System.out.println("Потопил");
                            targetPlayer.getThreeDecksShip1().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                    }
                } else if (targetPlayer.getThreeDecksShip2().getCoordinates().contains(shot)) {
                    switch (targetPlayer.getThreeDecksShip2().getCoordinates().size()) {
                        case 3:
                        case 2:
                            System.out.println("Ранил");
                            targetPlayer.getThreeDecksShip2().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                        case 1:
                            System.out.println("Потопил");
                            targetPlayer.getThreeDecksShip2().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                    }
                } else if (targetPlayer.getTwoDecksShip1().getCoordinates().contains(shot)) {
                    switch (targetPlayer.getTwoDecksShip1().getCoordinates().size()) {
                        case 2:
                            System.out.println("Ранил");
                            targetPlayer.getTwoDecksShip1().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                        case 1:
                            System.out.println("Потопил");
                            targetPlayer.getTwoDecksShip1().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                    }
                } else if (targetPlayer.getTwoDecksShip2().getCoordinates().contains(shot)) {
                    switch (targetPlayer.getTwoDecksShip2().getCoordinates().size()) {
                        case 2:
                            System.out.println("Ранил");
                            targetPlayer.getTwoDecksShip2().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                        case 1:
                            System.out.println("Потопил");
                            targetPlayer.getTwoDecksShip2().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                    }
                } else if (targetPlayer.getTwoDecksShip3().getCoordinates().contains(shot)) {
                    switch (targetPlayer.getTwoDecksShip3().getCoordinates().size()) {
                        case 2:
                            System.out.println("Ранил");
                            targetPlayer.getTwoDecksShip3().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                        case 1:
                            System.out.println("Потопил");
                            targetPlayer.getTwoDecksShip3().getCoordinates().remove(shot);
                            targetPlayer.getBg().getBattleground()[y][x] = "☠️";
                            break;
                    }
                } else if (targetPlayer.getOneDeckShip1().getCoordinates().contains(shot)) {
                    System.out.println("Потопил");
                    targetPlayer.getOneDeckShip1().getCoordinates().remove(shot);
                    targetPlayer.getBg().getBattleground()[y][x] = "☠️";

                } else if (targetPlayer.getOneDeckShip2().getCoordinates().contains(shot)) {
                    System.out.println("Потопил");
                    targetPlayer.getOneDeckShip2().getCoordinates().remove(shot);
                    targetPlayer.getBg().getBattleground()[y][x] = "☠️";

                } else if (targetPlayer.getOneDeckShip3().getCoordinates().contains(shot)) {
                    System.out.println("Потопил");
                    targetPlayer.getOneDeckShip3().getCoordinates().remove(shot);
                    targetPlayer.getBg().getBattleground()[y][x] = "☠️";

                } else if (targetPlayer.getOneDeckShip4().getCoordinates().contains(shot)) {
                    System.out.println("Потопил");
                    targetPlayer.getOneDeckShip4().getCoordinates().remove(shot);
                    targetPlayer.getBg().getBattleground()[y][x] = "☠️";

                } else {
                    System.out.println("Мимо");
                    if (shootingPlayer.equals(player1)) {
                        shootingPlayer = player2;
                        targetPlayer = player1;
                    } else {
                        shootingPlayer = player1;
                        targetPlayer = player2;
                    }

                }
            } else {
                System.out.println("Игра закончена. Победил " + shootingPlayer.getName());
                shootingPlayer.getBg().print();
                System.out.println();
                targetPlayer.getBg().print();
                break;
            }


        }





    }




}
