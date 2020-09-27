package domain;

import java.util.Stack;

public class Scene {
    public static final int ACTIONS_NUM = 3;
    private final Person arthur;
    private final Person alien;
    Door door = new Door(rnd (1850, 1950), rnd(550, 650));
    //Door door = new Door(1900, 600);
    private final Cabine cab = new Cabine(door);
    Stack<Action> arthurActions = new Stack<Action>();
    Stack<Action> alienActions = new Stack<Action>();
    int hand_size;
    private double ability;
    //PersonHands alienHands = new PersonHands((int) (Math.random() * ability * 4), Flora.SHAGGY);
    private Hands alienHands;
    private final Hands arthurHands;
    private boolean hand_flag = false;

    public Scene(int hands, int alien_age, int arthur_age) {

        if (hands < 0) throw new IllegalArgumentException();
        try{
            this.alienHands = new Hands(hands, alien_age, true);
        }
        catch (Hands.TooFewHandsForAlienException e){
            System.out.println(e.getString());
            alienHands = new Hands(3, alien_age);
        }
        this.arthurHands = new Hands(2, arthur_age);

        arthurHands.setFingersCondition(Hands.FingersCondition.CLEAN);
        alienHands.setFingersCondition(Hands.FingersCondition.SMEARED);
        setBreakDoorAbility();
        pushActions();

        arthur = new Person(PersonName.ARTHUR, arthurHands, arthurActions);
        alien = new Person(PersonName.ALIEN, alienHands, alienActions);
    }

    public void setBreakDoorAbility() {
        switch (this.alienHands.getHandSize()) {
            case SMALL:
                hand_size = 110;
                break;
            case USUALL:
                hand_size = 120;
            case BIG:
                hand_size = 130;
        }
        ability = (door.getHeight() + door.getWidth()) / hand_size;
        if (getAlienHands().getNumber() >= getAbility())
            hand_flag = true;
    }

    public void pushActions() {
        arthurActions.push(new PropAction());
        arthurActions.push(new CloseAction());
        arthurActions.push(new FinalAction(getCab().isDoor_closed(), isHands_enough()));
        //
        alienActions.push(new ShoutAction());
        alienActions.push(new PushThroughAction(getCab().isDoor_closed(), isHands_enough()));
        alienActions.push(new ShoutAction());
    }

    public boolean nextState(){
        boolean arthurNext = getArthur().doAction();
        boolean alienNext = getAlien().doAction();
        if (!arthurNext)
            causeDamage();
        return arthurNext || alienNext;
    }

    public void causeDamage() {
        if (!arthur.getState().getDescription().equals("Еее, я спасен")) {
            arthur.getHands().setNumber(rnd(0, 1));
            if (alienHands.getFingersCondition() == Hands.FingersCondition.SMEARED) {
                getArthur().getHands().setFingersCondition(Hands.FingersCondition.SMEARED);
            }
        }
    }

    public boolean checkState() {
        return this.getAlienHands().getNumber() >= this.getAbility();
    }

    public Cabine getCab() {
        return cab;
    }

    public Person getArthur() {
        return arthur;
    }

    public Person getAlien() {
        return alien;
    }

    public boolean isHands_enough() {
        return hand_flag;
    }

    public Hands getAlienHands() {
        return alienHands;
    }

    public double getAbility() {
        return ability;
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}