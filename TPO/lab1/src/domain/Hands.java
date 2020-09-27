package domain;

public class Hands {
    private int number;
    private Flora flora;
    private HandSize handSize;
    private FingersCondition fingersCondition;
    private boolean alien;

    public Hands(int hands_number, int age){
        this.setNumber(hands_number);
        setHandSizeAndFlora(age);
    }

    public Hands(int hands_number, int age, boolean alien) throws TooFewHandsForAlienException {
        this.setNumber(hands_number);
        setHandSizeAndFlora(age);
        setAlien(alien);

        if (hands_number <= 2)
            throw new TooFewHandsForAlienException("Alien's number of hands must be >= 2\n");
    }
    private void setHandSizeAndFlora(int age) {
        if (number <= 2) {
            if (age <= 12) {
                this.handSize = HandSize.SMALL;
                this.flora = Flora.HAIRLESS;
            }
            else if (age > 30) {
                this.handSize = HandSize.BIG;
                this.flora = Flora.HAIRY;
            }
            else {
                this.handSize = HandSize.USUALL;
                this.flora = Flora.NORMAL;
            }
        }
        else {
            if (age <= 12) {
                this.handSize = HandSize.SMALL;
                this.flora = Flora.HAIRY;
            }
            else if (age > 30) {
                this.handSize = HandSize.BIG;
                this.flora = Flora.SHAGGY_JUNGLE;
            }
            else {
                this.handSize = HandSize.USUALL;
                this.flora = Flora.SHAGGY;
            }
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Flora getFlora() {
        return flora;
    }

    public HandSize getHandSize() {
        return handSize;
    }

    public FingersCondition getFingersCondition() {
        return fingersCondition;
    }

    public void setFingersCondition(FingersCondition fingersCondition) {
        this.fingersCondition = fingersCondition;
    }

    public boolean isAlien() {
        return alien;
    }

    public void setAlien(boolean alien) {
        this.alien = alien;
    }

    public enum Flora {
        HAIRLESS,
        HAIRY,
        NORMAL,
        SHAGGY,
        SHAGGY_JUNGLE,
    }

    public enum HandSize {
        SMALL,
        USUALL,
        BIG,
    }

    public enum FingersCondition {
        SMEARED,
        CLEAN,
    }

    public static class TooFewHandsForAlienException extends Exception{
            String s;
            public TooFewHandsForAlienException(String s) {
                super(s);
                this.s = s;
            }
            public String getString(){return s;}
    }
}
