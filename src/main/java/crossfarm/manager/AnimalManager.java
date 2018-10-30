package crossfarm.manager;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import crossfarm.Farm;
import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.plants.BasePlant;
import crossfarm.menu.AnimalMenu;
import crossfarm.menu.BaseMenu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AnimalManager implements Mediator {

    private AnimalMenu _animal_menu;
    private Farm _farm;

    private Set<BaseAnimal> _starved_animals;

    public AnimalManager(Farm farm) {
        _starved_animals = new HashSet<BaseAnimal>();
        System.out.println("[Init] AnimalManager starts working!");
        createColleagues(farm);
    }

    public void createColleagues(Farm farm) {
        this._animal_menu = farm.animalMenu;
        this._farm = farm;
    }

    public Set<BaseAnimal> get_starved_animals(){
        return _starved_animals;
    }

    public void colleagueChanged() {
        Iterator<BaseCultivation> animal_it = _animal_menu.cultivations.iterator();
        while(animal_it.hasNext()){
            BaseAnimal animal = (BaseAnimal) animal_it.next();

            if(animal.isHungry()){
                _starved_animals.add(animal);
            }
        }

        if(_starved_animals.size() > 5){
            Iterator<Farmer> farmer_it = _farm.farmers.iterator();
            Iterator<BaseAnimal> starved_animal_it = _starved_animals.iterator();
            int total_appetite_quantity = 0;
            while (starved_animal_it.hasNext()){
                BaseAnimal starved_animal = starved_animal_it.next();
                total_appetite_quantity += starved_animal.getAppetite();
            }

            Farmer free_farmer = null;
            while(farmer_it.hasNext()){
                Farmer farmer = farmer_it.next();
                if (!farmer.getWorkStatus()){
                    free_farmer = farmer;
                    break;
                }
                //
                //      [1]检查缺乏食物数量
                //      [2]通知农民添加足量食物
                //
            }
            if(free_farmer != null){
                SolveStarvation farmer_solve = new FarmerSolveStarvation(this._farm, free_farmer);
                SolveStarvation owner_solve = new OwnerSolveStarvation(this._farm);

                Starvation starvation = new Starvation();
                starvation._deficiency_food_amount = total_appetite_quantity;
                farmer_solve.setNext(owner_solve);
                farmer_solve.solve(starvation);
            } else {
                System.out.println("No free farmer available to feed animals !");
            }


        }
    }

}
