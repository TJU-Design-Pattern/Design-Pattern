package crossfarm.timemachine;

import crossfarm.Farm;
import crossfarm.cultivation.plants.BasePlant;
import crossfarm.menu.PlantMenu;

import static crossfarm.Farm.getInstance;

public class PlantObserver extends Observer{
    public PlantObserver(TimeCounter time_counter){
        this.time_counter = time_counter;
        this.time_counter.attach(this);
    }

    public void update(){
        System.out.println("Time at" + this.time_counter.current_time + " :check cultivation observer");
        Farm global_farm = getInstance();
        PlantMenu plant_menu = global_farm.plantMenu;
        int plant_size = plant_menu.size();
        for(int i=0;i<plant_size;i++){
            BasePlant plant = plant_menu.getPlant(i);
            plant.timeChange(this.time_counter.current_time);
        }
    }
}