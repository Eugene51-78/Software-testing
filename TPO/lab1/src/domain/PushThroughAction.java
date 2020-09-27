package domain;

public class PushThroughAction implements Action {
    String str;

    public PushThroughAction(boolean door_closed, boolean hand_enough) {
        if ((!door_closed) || ((door_closed)&&(hand_enough)))
            this.str = "ручки просовываются во все щели";
        if ((door_closed)&&(!hand_enough))
            this.str = "слишком мало ручек, чтобы разломать дверь";
        if ((!door_closed)&&(!hand_enough))
            this.str = "не хватает ручек на все щели";
    }

    @Override
    public String getDescription () {
        return str;
    }
}