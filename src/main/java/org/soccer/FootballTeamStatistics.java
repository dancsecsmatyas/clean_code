package org.soccer;

import java.io.IOException;
import java.nio.file.Path;

public class FootballTeamStatistics {

    public static void main(String[] args) throws IOException {
        FootballTable footballTable = new FootballTable();
        footballTable.setPath(Path.of("src/main/resources/football.dat"));
        footballTable.readFile();
        System.out.println(footballTable.teamNameWithTheSmallestDifference());
    }

}
