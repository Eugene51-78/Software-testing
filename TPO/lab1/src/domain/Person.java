package domain;

import java.util.Stack;

public class Person {
    public Person(PersonName name,Hands hands, Stack<Action> actions) {
        if (hands.getNumber() < 0) throw new IllegalArgumentException();
        this.name = name;
        this.hands = hands;
        this.actions = actions;
    }

    public Stack<Action> getActions() {
        return actions;
    }

    private final Stack<Action> actions;

    public Action getState() {
        return state;
    }

    private Action state;

    public PersonName getName() {
        return name;
    }

    private final PersonName name;

    private final Hands hands;

    public boolean doAction(){
        if( actions.size() > 0 ) {
            state = actions.pop();
            return true;
        }
        return false;
    }

    public Hands getHands() {
        return hands;
    }

}