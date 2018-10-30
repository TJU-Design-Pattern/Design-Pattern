package crossfarm.menu;

import crossfarm.cultivation.plants.BasePlant;

import java.util.ArrayList;
import java.util.List;

public class PlantMenu<T extends BasePlant> extends BaseMenu {
    private List<T> plants;

    public PlantMenu(){
        plants = new ArrayList<T>();
    }

    /**
     * Adds an plant into the group
     * @param plant The plant to be added
     */
    public void addPlant(T plant){
        plants.add(plant);
    }

    /**
     * Return the plant in the plant list by index
     * @param index The index of the plant
     * @return The plant in the list
     */
    public T getplant(int index){
        return plants.get(index);
    }

    /**
     * Remove the plant in the plant list by index
     * @param index The index of the plant
     */
    public void removeplant(int index){
        plants.remove(index);
    }

    /**
     * Remove the plant in the plant list
     * @param plant The plant you want to remove
     */
    public void removeplant(T plant){
        plants.remove(plant);
    }

    /**
     * Get the size of the group
     * @return The size of the group
     */
    public int size(){
        return plants.size();
    }

}