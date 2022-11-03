package org.soccer;

public class FootballTeamRow {

    private String name;
    private int scoredGoals;
    private int againstGoals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getAgainstGoals() {
        return againstGoals;
    }

    public void setAgainstGoals(int againstGoals) {
        this.againstGoals = againstGoals;
    }

    public int getGoalsDifference() {
        if(scoredGoals> againstGoals) {
            return scoredGoals - againstGoals;
        } else {
            return againstGoals - scoredGoals;
        }
    }
}
