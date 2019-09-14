package at.htl.football;

public class Team implements Comparable<Team> {

    private String name;
    private int points;
    private int wins;
    private int draws;
    private int defeats;
    private int goalsShot;
    private int goalsRecived;

    public Team(String name) {
        this.name = name;
    }

    public void addMatch(Match match) {
        if (match.getGuestName().equals(this.getName())) {
            goalsShot = getGoalsShot() + match.getGuestGoals();
            goalsRecived = getGoalsRecived() + match.getHomeGoals();
            if (match.getHomeGoals() > match.getGuestGoals()) {
                defeats = getDefeats() + 1;
            } else if (match.getHomeGoals() < match.getGuestGoals()) {
                points = getPoints() + 3;
                wins = getWins() + 1;
            } else {
                points = getPoints() + 1;
                draws = getDraws() + 1;
            }

        } else if (match.getHomeName().equals(this.getName())) {
                goalsShot = getGoalsShot() + match.getHomeGoals();
                goalsRecived = getGoalsRecived() + match.getGuestGoals();
                if (match.getHomeGoals() < match.getGuestGoals()) {
                    defeats = getDefeats() + 1;
                } else if (match.getHomeGoals() > match.getGuestGoals() ) {
                    points = getPoints() + 3;
                    wins = getWins() + 1;
                } else {
                    points = getPoints() + 1;
                    draws = getDraws() + 1;
                }
            }

        getGoalDifference();

    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsRecived() {
        return goalsRecived;
    }

    public int getGoalDifference() {
        if (this.getGoalsShot() >= this.getGoalsRecived()){
            return this.getGoalsShot() - this.getGoalsRecived();
        }else {
            return this.getGoalsRecived() - this.getGoalsShot();
        }

    }

@Override
    public int compareTo(Team team) {

        if (getPoints() < team.getPoints()){
            return 1;
        }else if (getPoints() > team.getPoints()){
            return -1;
        }

        return 0;

    }

}
