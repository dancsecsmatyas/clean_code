package org.soccer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FootballTable {

    private Path path;

    private List<FootballTeamRow> footballTeamRowList;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public List<FootballTeamRow> getFootballTeamRowList() {
        return footballTeamRowList;
    }

    public void setFootballTeamRowList(List<FootballTeamRow> footballTeamRowList) {
        this.footballTeamRowList = footballTeamRowList;
    }

    public void readFile() throws IOException {
        List<FootballTeamRow> footballTeamRows = new ArrayList<>();
        Files.lines(getPath()).forEach(line -> {
            if (isValidLine(line)) {
                addFootballTeamRow(footballTeamRows, line);
            }
        });
        setFootballTeamRowList(footballTeamRows);
    }

    public String teamNameWithTheSmallestDifference() {
        int smallestDifference = Integer.MAX_VALUE;
        String teamName = "";
        for (FootballTeamRow footballTeamRow : getFootballTeamRowList()) {
            if (footballTeamRow.getGoalsDifference() < smallestDifference) {
                smallestDifference = footballTeamRow.getGoalsDifference();
                teamName = footballTeamRow.getName();
            }
        }
        return teamName;
    }

    private boolean isValidLine(String line) {
        return line.trim().length() > 0 && line.trim().substring(0, 1).matches("[+-]?\\d+");
    }

    private void addFootballTeamRow(List<FootballTeamRow> footballTeamRows, String line) {
        FootballTeamRow footballTeamRow = new FootballTeamRow();
        setFootballTeamRowDetails(line, footballTeamRow);
        footballTeamRows.add(footballTeamRow);
    }

    private void setFootballTeamRowDetails(String line, FootballTeamRow footballTeamRow) {
        footballTeamRow.setName(line.substring(7, 22).trim());
        footballTeamRow.setScoredGoals(Integer.parseInt(line.substring(43, 45)));
        footballTeamRow.setAgainstGoals(Integer.parseInt(line.substring(50, 52)));
    }
}
