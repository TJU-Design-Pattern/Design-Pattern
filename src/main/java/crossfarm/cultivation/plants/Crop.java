package crossfarm.cultivation.plants;

public class Crop extends BasePlant{

    public Crop(){

    }

    public void doSell(){

    }

    public void timeChange(int currentTime) {
        state.gainExperience(this);
    }

    public double cost() {
        return 0.1;
    }

    public void tick() {}
}
