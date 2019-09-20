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
        //Guest Points
        if (match.getGuestName().equals(this.getName())) {
            this.goalsShot += match.getGuestGoals();
            this.goalsRecived += match.getHomeGoals();
            this.points += match.getGuestPoints();

            calculatePoints(match.getGuestPoints());

            /*if (match.getHomeGoals() > match.getGuestGoals()) {
                this.defeats = getDefeats() + 1;
            } else if (match.getHomeGoals() < match.getGuestGoals()) {
                this.points = getPoints() + 3;
                this.wins = getWins() + 1;
            } else {
                this.points = getPoints() + 1;
                this.draws = getDraws() + 1;
            }*/
            //Home Points
        } else if (match.getHomeName().equals(this.getName())) {
            this.goalsShot += match.getHomeGoals();
            this.goalsRecived += match.getGuestGoals();
            this.points += match.getHomePoints();

            calculatePoints(match.getHomePoints());

//                if (match.getHomeGoals() < match.getGuestGoals()) {
//                    this.defeats = getDefeats() + 1;
//                } else if (match.getHomeGoals() > match.getGuestGoals() ) {
//                    this.points = getPoints() + 3;
//                    this.wins = getWins() + 1;
//                } else {
//                    this.points = getPoints() + 1;
//                    this.draws = getDraws() + 1;
//                }
        }

        getGoalDifference();

    }

    private void calculatePoints(int goals) {
        switch (goals) {
            case 3:
                this.wins++;
                break;
            case 0:
                this.defeats++;
                break;
            case 1:
                this.draws++;
                break;
        }
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
        return this.getGoalsShot() - this.getGoalsRecived();
    }

    public int compareTo(Team team) {

        if (getPoints() < team.getPoints()) {
            return 1;
        } else if (getPoints() > team.getPoints()) {
            return -1;
        } else {
            return team.getGoalDifference() - getGoalDifference();
        }

    }

}
