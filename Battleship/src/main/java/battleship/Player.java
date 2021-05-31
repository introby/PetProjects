package day19;

public class Player {
    String name;
    Battleground bg;
    Ship fourDecksShip;
    Ship threeDecksShip1;
    Ship threeDecksShip2;
    Ship twoDecksShip1;
    Ship twoDecksShip2;
    Ship twoDecksShip3;
    Ship oneDeckShip1;
    Ship oneDeckShip2;
    Ship oneDeckShip3;
    Ship oneDeckShip4;

    public Player(String name) {
        this.name = name;


    }

    public String getName() {
        return name;
    }

    public Ship getFourDecksShip() {
        return fourDecksShip;
    }

    public void setFourDecksShip(Ship fourDeckShip) {
        this.fourDecksShip = fourDeckShip;
    }

    public Ship getThreeDecksShip1() {
        return threeDecksShip1;
    }

    public void setThreeDecksShip1(Ship threeDecksShip1) {
        this.threeDecksShip1 = threeDecksShip1;
    }

    public Ship getThreeDecksShip2() {
        return threeDecksShip2;
    }

    public void setThreeDecksShip2(Ship threeDecksShip2) {
        this.threeDecksShip2 = threeDecksShip2;
    }

    public Ship getTwoDecksShip1() {
        return twoDecksShip1;
    }

    public void setTwoDecksShip1(Ship twoDecksShip1) {
        this.twoDecksShip1 = twoDecksShip1;
    }

    public Ship getTwoDecksShip2() {
        return twoDecksShip2;
    }

    public void setTwoDecksShip2(Ship twoDecksShip2) {
        this.twoDecksShip2 = twoDecksShip2;
    }

    public Ship getTwoDecksShip3() {
        return twoDecksShip3;
    }

    public void setTwoDecksShip3(Ship twoDecksShip3) {
        this.twoDecksShip3 = twoDecksShip3;
    }

    public Ship getOneDeckShip1() {
        return oneDeckShip1;
    }

    public void setOneDeckShip1(Ship oneDeckShip1) {
        this.oneDeckShip1 = oneDeckShip1;
    }

    public Ship getOneDeckShip2() {
        return oneDeckShip2;
    }

    public void setOneDeckShip2(Ship oneDeckShip2) {
        this.oneDeckShip2 = oneDeckShip2;
    }

    public Ship getOneDeckShip3() {
        return oneDeckShip3;
    }

    public void setOneDeckShip3(Ship oneDeckShip3) {
        this.oneDeckShip3 = oneDeckShip3;
    }

    public Ship getOneDeckShip4() {
        return oneDeckShip4;
    }

    public void setOneDeckShip4(Ship oneDeckShip4) {
        this.oneDeckShip4 = oneDeckShip4;
    }

    public Player(Battleground bg) {
        this.bg = bg;
    }

    public Battleground getBg() {
        return bg;
    }

    public void setBg(Battleground bg) {
        this.bg = bg;
    }


}
