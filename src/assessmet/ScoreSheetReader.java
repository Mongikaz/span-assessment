package assessmet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreSheetReader {

    public static ArrayList<Team> readScoreFile(FileInputStream fileInputStream) throws IOException {
        ArrayList<Team> teams = new ArrayList<>();
        try {
            Scanner inStream = new Scanner(fileInputStream);
            String resultsLine;
            while (inStream.hasNextLine()) {
                resultsLine = inStream.nextLine();

                String gameResults[] = resultsLine.split(", ");

                String teamAName = gameResults[0].substring(0, gameResults[0].lastIndexOf(' '));
                Integer teamAScore = Integer.parseInt(gameResults[0].substring(gameResults[0].lastIndexOf(' ') + 1));

                String teamBName = gameResults[1].substring(0, gameResults[1].lastIndexOf(' '));
                Integer teamBScore = Integer.parseInt(gameResults[1].substring(gameResults[1].lastIndexOf(' ') + 1));


                Team teamOne = new Team(teamAName, 0);
                Team teamTwo = new Team(teamBName, 0);

                if (!teams.contains(teamOne)) {
                    teams.add(teamOne);
                }
                if (!teams.contains(teamTwo)) {
                    teams.add(teamTwo);
                }

                if (teamAScore > teamBScore) {
                    Team one = teams.get(teams.indexOf(teamOne));
                    one.addPoints(one.getPoints() + 3);
                } else if (teamBScore > teamAScore) {
                    Team two = teams.get(teams.indexOf(teamTwo));
                    two.addPoints(two.getPoints() + 3);
                } else {
                    Team one = teams.get(teams.indexOf(teamOne));
                    Team two = teams.get(teams.indexOf(teamTwo));
                    one.addPoints(one.getPoints() + 1);
                    two.addPoints(two.getPoints() + 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: File not found.");
            System.exit(0);
        } finally {
            fileInputStream.close();
        }
        return teams;
    }

    static void generateRatingTable(ArrayList<Team> teams) {
        Collections.sort(teams, new Team());
        int temp = 0, k = 1;
        for (int i = 0; i < teams.size() - 1; i++) {
            Team it = teams.get(i);
            Team next = teams.get(i + 1);
            if (it.getPoints() == next.getPoints()) {
                System.out.println(k + ". " + it.getName() + ", " + it.getPoints() + " Pts");
                temp++;
            } else {
                System.out.println(k + ". " + it.getName() + ", " + it.getPoints() + " Pts");
                k += temp + 1;
                temp = 0;
            }
        }
        Team it = teams.get(teams.size() - 1);
        System.out.println(k + ". " + it.getName() + ", " + it.getPoints() + " Pts");
    }
}

