package crossfarm.manager;

import crossfarm.cultivation.plants.BasePlant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class PlantManager implements Mediator{
    private ArrayList<BasePlant> _plants;
    private ArrayList<Farmer> _farmers;

    private Set<BasePlant> _mature_plant;

    public PlantManager() {
        System.out.println("[Init] PlantManager starts work!");
    }

    public void createColleagues() {

    }

    public void colleagueChanged() {
        Iterator<BasePlant> plant_it = _plants.iterator();
        while (plant_it.hasNext()){
            BasePlant plant = plant_it.next();
            //
            //      检查作物状态
            //
        }
        if(_mature_plant.size() > 5){
            Iterator<Farmer> farmer_it = _farmers.iterator();
            while (farmer_it.hasNext()){
                Farmer farmer = farmer_it.next();
                //
                //      通知农民收割作物并放入谷仓
                //
            }
        }
    }

    public void addPlant(BasePlant plant){
        this._plants.add(plant);
    }

    public void addFarmer(Farmer farmer){
        this._farmers.add(farmer);
    }
}
