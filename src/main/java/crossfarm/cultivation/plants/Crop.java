package crossfarm.cultivation.plants;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.CultivationPrototype;

public class Crop extends BasePlant implements CultivationPrototype {

    public Crop(){
        this.isMature = false;
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
        if(this.experience >= 72){
            this.isMature = true;
        }
    }

    public double cost() {
        return 0.1;
    }
}
