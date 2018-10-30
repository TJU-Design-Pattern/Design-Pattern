package crossfarm.manager;

import crossfarm.Farm;
import crossfarm.cultivation.plants.BasePlant;
import crossfarm.menu.BaseMenu;
import crossfarm.menu.PlantMenu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class PlantManager implements Mediator{
    private PlantMenu _plant_menu;
    private Farm _farm;

    private Set<BasePlant> _mature_plant;

    public PlantManager(Farm farm) {
        System.out.println("[Init] PlantManager starts working!");
        createColleagues(farm);
    }

    public void createColleagues(Farm farm) {
        this._plant_menu = farm.plantMenu;
        this._farm = farm;
    }

    public void colleagueChanged() {
        Iterator<BasePlant> plant_it = _plant_menu.Plants.iterator();
        while (plant_it.hasNext()){
            BasePlant plant = plant_it.next();
            if (plant.isMature){
                _mature_plant.add(plant);
            }
        }
        if(_mature_plant.size() > 5){
            Iterator<Farmer> farmer_it = _farm.farmers.iterator();
            while (farmer_it.hasNext()){
                Farmer farmer = farmer_it.next();
                if(farmer.freeToReap()){
                    farmer.reapCrops(_mature_plant, this._farm);
                }
            }
        }
    }

}
