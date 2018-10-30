package crossfarm.cultivation.plants;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.CultivationPrototype;
import crossfarm.manager.Mediator;
import crossfarm.manager.PlantManager;

import javax.print.attribute.standard.MediaPrintableArea;

public class Crop extends BasePlant implements CultivationPrototype {

    public Crop(PlantManager plant_manager){
        this.isMature = false;
        this._plant_manager = plant_manager;
        this.setMediator(plant_manager);
    }

    public void doSell(){

    }
    public void tick(){

    }

    public BaseCultivation clone() {
        return new Crop(this._plant_manager);
    }

    public String getName() {
        return "Crop";
    }

    public void timeChange(int currentTime) {
        state.gainExperience(this);
        if(this.experience >= 72){
            this.isMature = true;
            setColleagueUpdated();
        }
    }

    public double cost() {
        return 0.1;
    }

    public void setMediator(Mediator mediator){
        this._plant_manager = (PlantManager) mediator;
    }

    public void setColleagueUpdated(){
        _plant_manager.colleagueChanged();
    }
}
