package at.htl.football;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class MatchTest {

    @Test
    void t010_empty_constructor() {
        League league = new League();
        assertThat(league, isA(League.class));
    }

    @Test
    void t020_constructor_with_parameters() {
        League league = new League();
        assertThat(league, isA(League.class));
        Match match = new Match("Bayern Munich", "Dortmund", 3, 1);
        assertThat(match.getHomeName(), is("Bayern Munich"));
        assertThat(match.getGuestName(), is("Dortmund"));
        assertThat(match.getHomeGoals(), is(3));
        assertThat(match.getGuestGoals(), is(1));
    }

    @Test
    void t020_addMatchMethode() {
        League league = new League();
        assertThat(league, isA(League.class));
        Match match = new Match("Bayern Munich", "Dortmund", 3, 1);
        league.addMatchResult(match);
    }


}