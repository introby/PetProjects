package day19;

public class Battleground {
    private String[][] battleground;

    public Battleground(String[][] battleground) {
        this.battleground = battleground;
    }

    public Battleground() {

    }

    public String[][] getBattleground() {
        return battleground;
    }

    public void setBattleground(String[][] battleground) {
        this.battleground = battleground;
    }

    public void print() {

        for (int i = 0; i < battleground.length; i++) {
            for (int j = 0; j < battleground.length; j++) {

                System.out.print(battleground[i][j]);

            }
            System.out.println();

        }

    }

    public void setShips() {

    }
}
