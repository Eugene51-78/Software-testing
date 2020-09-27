package domain.tests;

import domain.*;
import org.junit.Before;
import org.junit.Test;
import domain.Scene;

import static org.junit.Assert.*;

public class SceneTest {
    Scene scene;
    Action[] arthurActions, alienActions;

    public void createScene(int alien_hands, int alien_age, int arthur_age){
        scene = new Scene(alien_hands, alien_age, arthur_age);

    }
    public void setContextActions() {
        arthurActions[0] = new FinalAction(scene.getCab().isDoor_closed(), scene.isHands_enough());
        alienActions[1] = new PushThroughAction(scene.getCab().isDoor_closed(), scene.isHands_enough());
    }

    @Before
    public void setUp() {
        arthurActions = new Action[Scene.ACTIONS_NUM];
        alienActions = new Action[Scene.ACTIONS_NUM];
        //
        arthurActions[1] = new CloseAction();
        arthurActions[2] = new PropAction();
        //
        alienActions[0] = new ShoutAction();
        alienActions[2] = new ShoutAction();
    }

    @Test
    public void initialTest() {
        createScene(10, 12, 20);

        assertEquals(scene.getArthur().getName(), PersonName.ARTHUR);
        assertEquals(scene.getAlien().getName(), PersonName.ALIEN);

        assertEquals(scene.getArthur().getActions().size(), Scene.ACTIONS_NUM);
        assertEquals(scene.getAlien().getActions().size(), Scene.ACTIONS_NUM);

        assert(scene.getCab().getDoor().getHeight() > 0);    //the door must have size
        assert(scene.getCab().getDoor().getWidth() > 0);

        assert(scene.getAlienHands().getNumber() >= 3);
        assert(scene.getArthur().getHands().getNumber() >= 0);
    }

    @Test
    public void checkScenesWithDifferentNumberOfAlienHands() {
        for (int i = 18; i <= 25; i++) {
            createScene(i,12, 18);
            setContextActions();

            if (arthurActions[0].getDescription() == "Еее, я спасен") {
                assertTrue(scene.getCab().isDoor_closed());
                assert (scene.getAlienHands().getNumber() < scene.getAbility());
                assertNotEquals("ручки просовываются во все щели", alienActions[1].getDescription());
            } else if (arthurActions[0].getDescription() == "О, нет, меня сейчас съедят, разломав дверь!") {
                assertTrue(scene.getCab().isDoor_closed());
                assert (scene.getAlienHands().getNumber() >= scene.getAbility());
                assertEquals("ручки просовываются во все щели", alienActions[1].getDescription());
            } else if (arthurActions[0].getDescription() == "О, нет, дверь не закрылась - меня сейчас съедят!") {
                assertFalse(scene.getCab().isDoor_closed());
                assertNotEquals("слишком мало ручек, чтобы разломать дверь", alienActions[1].getDescription());
            }

            String door_state = "OPEN...";
            if (scene.getCab().isDoor_closed() && (scene.isHands_enough()))
                door_state = "CLOSED (DESTROYING...)";
            else if (scene.getCab().isDoor_closed() && (!scene.isHands_enough()))
                door_state = "CLOSED :)";

            System.out.println("Final Arthur's state: \"" + arthurActions[0].getDescription() +
                                "\"\nAlien's hands: " + scene.getAlienHands().getNumber() +
                                " | Hands enough: " + scene.getAbility() +
                                " | The door status: " + door_state + "\n");
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void exceptionWithNegativeHandsTest() {
        createScene(-1000,12,15);
    }

    @Test
    public void checkActionsTest() {
        createScene(25,12, 19);
        setContextActions();
        int j = 0;
        while (scene.nextState()) {
            assertEquals(scene.getArthur().getState().getDescription(), arthurActions[j].getDescription());
            assertEquals(scene.getAlien().getState().getDescription(), alienActions[j].getDescription());
            j++;
        }

        assertEquals(arthurActions[1].getDescription(), "старается запереть дверь");
        assertEquals(arthurActions[2].getDescription(), "уперся плечом в дверь кабины");
        assertEquals(alienActions[0].getDescription(), "безумно верещит тоненьким голосом");
        assertEquals(alienActions[2].getDescription(), "безумно верещит тоненьким голосом");
    }

    @Test
    public void testAbilityOfAlienHandsToGetIntoAllCracks() {
        for (int i = 18; i <= 23; i++) {
            createScene(i,12, 12);
            setContextActions();

            if (scene.getCab().isDoor_closed() && !scene.isHands_enough())
                assertEquals("слишком мало ручек, чтобы разломать дверь", alienActions[1].getDescription());
            if (scene.getCab().isDoor_closed() && scene.isHands_enough())
                assertEquals("ручки просовываются во все щели", alienActions[1].getDescription());
            if ((!scene.getCab().isDoor_closed()) && (!scene.isHands_enough()))
                assertEquals("не хватает ручек на все щели", alienActions[1].getDescription());
            if (!scene.getCab().isDoor_closed() && scene.isHands_enough())
                assertEquals("ручки просовываются во все щели", alienActions[1].getDescription());
            // (1900+600)/110 = 22,72
        }
    }

    @Test
    public void changeHairinessWithDifferentAgesTest() {
        for (int i = 10; i < 30; i++) {
            for (int age = 5; age <= 12; age++) {
                createScene(i, age, age);
                setContextActions();
                assertEquals(Hands.Flora.HAIRLESS, scene.getArthur().getHands().getFlora());
                assertEquals(Hands.Flora.HAIRY, scene.getAlien().getHands().getFlora());
            }

            for (int age = 13; age <= 30; age++) {
                createScene(i, age, age);
                setContextActions();
                assertEquals(Hands.Flora.NORMAL, scene.getArthur().getHands().getFlora());
                assertEquals(Hands.Flora.SHAGGY, scene.getAlien().getHands().getFlora());
            }
            for (int age = 31; age <= 35; age++) {
                createScene(i, age, age);
                setContextActions();
                assertEquals(Hands.Flora.HAIRY, scene.getArthur().getHands().getFlora());
                assertEquals(Hands.Flora.SHAGGY_JUNGLE, scene.getAlien().getHands().getFlora());
            }
        }
    }

    @Test
    public void handsEnoughTest() {
        for (int i = 18; i <= 25; i++) {
            createScene(i,12, 55);
            setContextActions();

            if (scene.checkState()) {
                assert(scene.getAlienHands().getNumber() >= scene.getAbility());
                System.out.println("OK - A sufficient number of alien's hands. Got: " +
                                    scene.getAlienHands().getNumber() +
                                    " hands | Expected >= "+ scene.getAbility() );
            } else {
                assert(scene.getAlienHands().getNumber() < scene.getAbility());
                System.out.println("OK - Not enough alien's hands. Got: " +
                                    scene.getAlienHands().getNumber()+" | Expected >= " +
                                    scene.getAbility());
            }
        }
    }

    @Test(expected = Hands.TooFewHandsForAlienException.class)
    public void tooFewHandsExceptionTest() throws Hands.TooFewHandsForAlienException {
        Hands alienHands = new Hands(1,99,true);
    }

    @Test
    public void fewerAndDirtyArthursHandsAfterAttackTest() {
        for (int i = 18; i <= 25; i++) {
            createScene(i,12, 94);
            setContextActions();

            while (scene.nextState())
                ;

            if (!scene.getArthur().getState().getDescription().equals("Еее, я спасен")) {
                assert (scene.getArthur().getHands().getNumber() < 2);
                assertEquals(Hands.FingersCondition.SMEARED, scene.getArthur().getHands().getFingersCondition());
            }
            else {
                assertEquals(Hands.FingersCondition.CLEAN, scene.getArthur().getHands().getFingersCondition());
            }
        }
    }
}