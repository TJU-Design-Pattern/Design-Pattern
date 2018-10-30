package crossfarm.state;

import crossfarm.cultivation.BaseCultivation;

public class HungryState implements State {
    private static HungryState singleton = new HungryState();
    private HungryState() {}
    public static State getInstance() { return singleton; }
    public void getFull(Context context) {
        context.changeState(FullState.getInstance());
    }
    public void getHungry(Context context) {}
    public void gainExperience(BaseCultivation animal) {}
}
