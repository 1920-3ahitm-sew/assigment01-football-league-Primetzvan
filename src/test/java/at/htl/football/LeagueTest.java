package at.htl.football;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LeagueTest {

    @Test
    void addMatchResult() {

        League league = new League();
        Match match1 = new Match("Bayern Munich", "Leverkusen", 5, 3);
        Match match2 = new Match("Wolfburg", "Bayern Munich", 5, 5);

        league.addMatchResult(match1);
        league.addMatchResult(match2);

        List<Team> teams = league.getTable();

        assertThat(teams.get(0).getName(), is("Bayern Munich"));
        assertThat(teams.get(1).getName(), is("Wolfburg"));
        assertThat(teams.size(), is(3));
    }

    @Test
    void getTable() {
        League league = new League();
        Match match1 = new Match("Bayern Munich", "Leverkusen", 5, 3);
        Match match2 = new Match("Salzburg", "Wolfsburg", 5, 5);
        Match match3 = new Match("Bayern Munich","Salzburg", 1,3);

        league.addMatchResult(match1);
        league.addMatchResult(match2);
        league.addMatchResult(match3);

        assertThat(league.getTable().get(0).getName(),is("Salzburg"));
        assertThat(league.getTable().get(1).getName(),is("Bayern Munich"));
        assertThat(league.getTable().get(2).getName(),is("Wolfsburg"));
        assertThat(league.getTable().get(3).getName(),is("Leverkusen"));



    }


}
