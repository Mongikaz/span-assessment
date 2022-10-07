package assessmet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamRankingTableGenarator {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.print("Read in file: ");

        ArrayList<Team> r = ScoreSheetReader.readScoreFile(new FileInputStream(input.next()));
        ScoreSheetReader.generateRatingTable(r);

    }
}
