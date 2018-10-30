package crossfarm.menu;

import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.animals.Duck;

import java.util.ArrayList;
import java.util.List;

public class AnimalMenu<T extends BaseAnimal> extends BaseMenu {
    private List<T> animals;

    public AnimalMenu(){
        animals = new ArrayList<T>();
    }

    /**
     * Adds an animal into the group
     * @param animal The animal to be added
     */
    public void addAnimal(T animal){
        animals.add(animal);
    }

    /**
     * Return the animal in the animal list by index
     * @param index The index of the animal
     * @return The animal in the list
     */
    public T getAnimal(int index){
        return animals.get(index);
    }

    /**
     * Remove the animal in the animal list by index
     * @param index The index of the animal
     */
    public void removeAnimal(int index){
        animals.remove(index);
    }

    /**
     * Remove the animal in the animal list
     * @param animal The animal you want to remove
     */
    public void removeAnimal(T animal){
        animals.remove(animal);
    }

    /**
     * Get the size of the group
     * @return The size of the group
     */
    public int size(){
        return animals.size();
    }

}