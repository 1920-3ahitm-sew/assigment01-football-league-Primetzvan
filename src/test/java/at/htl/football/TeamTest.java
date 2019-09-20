package at.htl.football;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class TeamTest {

    @Test
    void addMatch() {
        Team team = new Team("Bayern Munich");
        Match match1 = new Match("Bayern Munich", "Leverkusen", 5, 3);
        Match match2 = new Match("Wolfburg", "Bayern Munich", 5, 5);
        Match match3 = new Match("Freiburg", "Bayern Munich", 5, 2);
        Match match4 = new Match("Bayern Munich", "Stuttgart", 8, 9);

        team.addMatch(match1);
        team.addMatch(match2);
        team.addMatch(match3);
        team.addMatch(match4);

        assertThat(team.getName(), is("Bayern Munich"));
        assertThat(team.getPoints(), is(4));
        assertThat(team.getGoalDifference(), is(-2));
        assertThat(team.getGoalsShot(), is(20));
        assertThat(team.getDefeats(), is(2));
        assertThat(team.getDraws(), is(1));
        assertThat(team.getWins(), is(1));
    }


    @Test
    void compareTo(){

        Team team = new Team("Bayern Munich");
        Team team1 = new Team("Leverkusen");
        Match match1 = new Match("Bayern Munich", "Leverkusen", 5, 3);

        team.addMatch(match1);

        assertThat(team.compareTo(team1), is(-1));

    }



}
