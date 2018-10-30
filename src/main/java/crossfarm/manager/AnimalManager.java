package crossfarm.manager;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.plants.BasePlant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class AnimalManager implements Mediator {
    private ArrayList<BaseAnimal> _animals;
    private ArrayList<Farmer> _farmers;

    private Set<BaseAnimal> _starved_animals;

    public AnimalManager() {
        System.out.println("[Init] AnimalManager starts work!");
    }

    public void createColleagues() {

    }

    public void colleagueChanged() {
        Iterator<BaseAnimal> animal_it = _animals.iterator();
        while(animal_it.hasNext()){
            BaseAnimal animal = animal_it.next();
            //
            //          检查动物状态
            //
        }

        if(_starved_animals.size() > 5){
            Iterator<Farmer> farmer_it = _farmers.iterator();
            while(farmer_it.hasNext()){
                Farmer farmer = farmer_it.next();
                //
                //      [1]检查缺乏食物数量
                //      [2]通知农民添加足量食物
                //
            }
        }
    }

    public void addAnimal(BaseAnimal animal){
        this._animals.add(animal);
    }

    public void addFarmer(Farmer farmer){
        this._farmers.add(farmer);
    }


}
