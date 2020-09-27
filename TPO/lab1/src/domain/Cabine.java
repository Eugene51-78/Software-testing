package domain;

public class Cabine {
    private Door door;
    private boolean door_closed;
    public Cabine(Door door) {
        this.setDoor(door);
        if ((door.getHeight() <= 1930) && (door.getHeight() >= 1870) && (door.getWidth() <= 630) && (door.getWidth() >= 570)) {
            this.setDoor_closed(true); // closes tightly
        } else
            this.setDoor_closed(false); // the door doesn't close tightly
    }

    public boolean isDoor_closed() {
        return door_closed;
    }

    public void setDoor_closed(boolean door_state) {
        this.door_closed = door_state;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}
