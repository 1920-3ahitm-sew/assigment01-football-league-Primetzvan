package at.htl.football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {

    private List<Team> teams = new ArrayList<>();

    public League() {
    }

    public void addMatchResult(Match match) {

        findOrCreateTeam(match.getHomeName()).addMatch(match);
        findOrCreateTeam(match.getGuestName()).addMatch(match);

    }

    private Team findOrCreateTeam(String teamName) {
        Team team;
        for (int i = 0; i < getTable().size(); i++) {

            if (getTable().get(i).getName().equals(teamName)) {
                return getTable().get(i);
            }
        }
        team = new Team(teamName);
        getTable().add(team);
        return team;
    }

    public List<Team> getTable() {

        Collections.sort(teams);
        return teams;
    }

}
