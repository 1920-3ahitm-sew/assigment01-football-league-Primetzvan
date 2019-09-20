package at.htl.football;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class MatchTest {


    @Test
    void getHomePoints_3(){

        Match matchA = new Match("Bayern Munich", "Dortmund", 10, 5 );

        assertThat(matchA.getHomePoints(),is(3));

    }

    @Test
    void getGuestPoints_1(){

        Match matchA = new Match("Bayern Munich", "Dortmund", 3, 3 );

        assertThat(matchA.getHomePoints(),is(1));

    }


}