package crossfarm;

import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.animals.Duck;
import crossfarm.cultivation.plants.Crop;
import crossfarm.manager.Farmer;
import crossfarm.manager.Owner;
import crossfarm.menu.AnimalMenu;
import crossfarm.menu.PlantMenu;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private static Farm instance = new Farm();

    public AnimalMenu animalMenu = new AnimalMenu();
    public PlantMenu plantMenu = new PlantMenu();
    public List<Farmer> farmers = new ArrayList<Farmer>();

    private Farm(){
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
}
