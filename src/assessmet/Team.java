package assessmet;

import java.util.Comparator;

public class Team implements Comparator<Team> {

    private String name;
    private int points;

    public Team() {
        name = null;
        points = 0;
    }

    public Team(String name, int points) {
        this.name = name;
        this.points = points;
    }

    String getName() {
        return name;
    }

    int getPoints() {
        return points;
    }

    void addPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object temp) {
        if (temp instanceof Team) {
            Team x = (Team) temp;
            if (this.name.equals(x.name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compare(Team teamOne, Team teamTwo) {
        int temp = teamTwo.getPoints() - teamOne.getPoints();
        if (temp == 0) {
            String one = teamOne.getName().replaceAll(" ", "");
            String two = teamTwo.getName().replaceAll(" ", "");
            return one.compareToIgnoreCase(two);
        }
        return temp;

    }


}
