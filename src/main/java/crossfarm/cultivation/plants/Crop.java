package crossfarm.cultivation.plants;

public class Crop extends BasePlant{

    public Crop(){
        this.isMature = false;
    }

    public void doSell(){

    }
    public void tick(){

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
