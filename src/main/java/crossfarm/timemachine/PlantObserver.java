package crossfarm.timemachine;

import crossfarm.Farm;
import crossfarm.cultivation.plants.BasePlant;
import crossfarm.menu.PlantMenu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        List sec_plant_menu_plants = plant_menu.Plants;
        List<BasePlant> copy_plants = new ArrayList<BasePlant>();
        copy_plants.addAll(sec_plant_menu_plants);
        Iterator iter = copy_plants.listIterator();

        while(iter.hasNext()){
            //System.out.println("abc");
            BasePlant plant = (BasePlant)iter.next();
            plant.timeChange(this.time_counter.current_time);
        }
    }
}