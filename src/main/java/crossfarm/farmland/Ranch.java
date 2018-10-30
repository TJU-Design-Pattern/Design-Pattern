/**
 * 存储动物的牧场
 */
package crossfarm.farmland;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.animals.Duck;
import crossfarm.cultivation.plants.Crop;
import crossfarm.menu.AnimalMenu;
import crossfarm.menu.PlantMenu;

public class Ranch extends BaseLand {
    private static Ranch instance = new Ranch();

    public AnimalMenu<Cat> catMenu;
    public AnimalMenu<Duck> duckMenu;
    public PlantMenu<Crop> cropMenu;

    public BaseLand clone() {
        return null;
    }

    public Ranch(){
        catMenu = new AnimalMenu<Cat>();
        duckMenu = new AnimalMenu<Duck>();
        cropMenu = new PlantMenu<Crop>();
    }

    /**
     * Return a single instance of Ranch
     * @return A single instance of Ranch
     */
    public static Ranch getInstance(){
        Ranch temp = instance;
        if(temp == null){
            synchronized(Ranch.class){
                temp = instance;
                if(temp == null){
                    instance = new Ranch();
                    temp = instance;
                }
            }
        }
        return temp;

    }
}