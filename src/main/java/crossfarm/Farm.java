package crossfarm;

import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.animals.Duck;
import crossfarm.cultivation.plants.Crop;
import crossfarm.manager.AnimalManager;
import crossfarm.manager.Farmer;
import crossfarm.manager.Owner;
import crossfarm.manager.PlantManager;
import crossfarm.menu.AnimalMenu;
import crossfarm.menu.PlantMenu;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Farm implements Serializable {
    private static Farm instance = new Farm();

    public AnimalMenu animalMenu = new AnimalMenu();
    public PlantMenu plantMenu = new PlantMenu();
    public List<Farmer> farmers = new ArrayList<Farmer>();

    private AnimalManager animal_manager;
    private PlantManager plant_manager;

    public int warehouse = 10;  // 初始玩家有10个谷物=100食物
    public int foodCourt = 100;  // 初始食槽有100食物

    public Farm(){
        for(int i = 0; i < 4; i++ )
            farmers.add(new Farmer());
    }

    /**
     * Return a single instance of Ranch
     * @return A single instance of Ranch
     */
    public static Farm getInstance(){
        Farm temp = instance;
        if(temp == null){
            synchronized(Farm.class){
                temp = instance;
                if(temp == null){
                    instance = new Farm();
                    temp = instance;
                }
            }
        }
        return temp;
    }

    public AnimalManager getAnimal_manager() {
        if(this.animal_manager == null){
            this.animal_manager = new AnimalManager(instance);
        }
        return this.animal_manager;
    }

    public PlantManager getPlant_manager() {
        if(this.plant_manager == null){
            this.plant_manager = new PlantManager(instance);
        }
        return this.plant_manager;
    }

    public Memento createMemento() {
        try {
            return new Memento(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
