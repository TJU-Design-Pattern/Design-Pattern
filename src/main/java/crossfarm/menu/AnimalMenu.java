package crossfarm.menu;

import com.sun.xml.internal.rngom.parse.host.Base;
import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.animals.Duck;
import crossfarm.visitor.BaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class AnimalMenu extends BaseMenu {
    public List<BaseAnimal> animals;

    public AnimalMenu(){
        cultivations = new ArrayList<BaseCultivation>();
    }

    /**
     * Adds an animal into the group
     * @param animal The animal to be added
     */
    public void addAnimal(BaseAnimal animal){
        cultivations.add(animal);
    }

    /**
     * Return the animal in the animal list by index
     * @param index The index of the animal
     * @return The animal in the list
     */
    public BaseAnimal getAnimal(int index){
        return (BaseAnimal) cultivations.get(index);
    }

    /**
     * Remove the animal in the animal list by index
     * @param index The index of the animal
     */
    public void removeAnimal(int index){
        cultivations.remove(index);
    }

    /**
     * Remove the animal in the animal list
     * @param animal The animal you want to remove
     */
    public void removeAnimal(BaseAnimal animal){cultivations.remove(animal);
    }

    /**
     * Get the size of the group
     * @return The size of the group
     */
    public int size(){
        return cultivations.size();
    }

    /**
     * Get a iterator of animal list
     * @return A iterator
     */
    public Iterator iterator(){
        return new CultivationIterator(this.cultivations);
    }

    public void accept(BaseVisitor visitor){
        visitor.visit(this);
    }

}