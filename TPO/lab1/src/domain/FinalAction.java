package domain;

public class FinalAction implements Action {
    String str;
    public FinalAction(boolean doorState, boolean hand_flag) {
        if (doorState && !hand_flag) this.str = "Еее, я спасен";
        else if (doorState) this.str = "О нет, меня сейчас съедят, разломав дверь!";
            else this.str = "О, нет, дверь не закрылась - меня сейчас съедят!";
    }

    @Override
    public String getDescription() {
        return str;
    }
}
