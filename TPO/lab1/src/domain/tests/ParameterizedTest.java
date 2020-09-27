package domain.tests;

import domain.Hands;
import domain.Scene;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {
    private int hands, alien_age, arthur_age;

    public ParameterizedTest(int hands, int alien_age, int arthur_age) {
        this.hands = hands;
        this.alien_age = alien_age;
        this.arthur_age = arthur_age;
    }

    @Parameterized.Parameters
    public static Collection getParameters() {
        return Arrays.asList(new Object[][]{
                {10, 5, 5},
                {10, 12, 12},
                {10, 15, 20},
                {10, 30, 30},
                {10, 33, 31}});
    }

    @Test
    public void changeHairinessWithDifferentAgesTest() {
        Scene scene = new Scene(hands, alien_age, arthur_age);

        if (arthur_age <= 12)
            assertEquals(Hands.Flora.HAIRLESS, scene.getArthur().getHands().getFlora());
        else if (arthur_age > 30)
            assertEquals(Hands.Flora.HAIRY, scene.getArthur().getHands().getFlora());
        else
            assertEquals(Hands.Flora.NORMAL, scene.getArthur().getHands().getFlora());

        if (alien_age <= 12)
            assertEquals(Hands.Flora.HAIRY, scene.getAlien().getHands().getFlora());
        else if (alien_age > 30)
            assertEquals(Hands.Flora.SHAGGY_JUNGLE, scene.getAlien().getHands().getFlora());
        else
            assertEquals(Hands.Flora.SHAGGY, scene.getAlien().getHands().getFlora());
    }
}