package crossfarm.state;

import crossfarm.cultivation.animals.BaseAnimal;

public class FullState implements State {
    private static FullState singleton = new FullState();
    private FullState() {}
    public static State getInstance() { return singleton; }
    public void getFull(Context context) {}
    public void getHungry(Context context) {
        context.changeState(HungryState.getInstance());
    }
    public void gainExperience(BaseAnimal animal) {
        animal.experience++;  // 增长经验
    }
}
