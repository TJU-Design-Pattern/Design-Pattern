package crossfarm.cultivation.plants;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.CultivationPrototype;

public class Crop extends BasePlant implements CultivationPrototype {

    public Crop(){

    }

    public void doSell(){

    }
    public void tick(){

    }

    public BaseCultivation clone() {
        return new Crop();
    }
    public String getName() {
        return "Crop";
    }
    public void timeChange(int currentTime) {
        state.gainExperience(this);
    }

    public double cost() {
        return 0.1;
    }
}
