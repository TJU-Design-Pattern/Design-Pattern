package crossfarm.menu;

import crossfarm.cultivation.plants.BasePlant;
import crossfarm.visitor.BaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class PlantMenu extends BaseMenu {
    public List<BasePlant> Plants;

    public PlantMenu(){
        Plants = new ArrayList<BasePlant>();
    }

    /**
     * Adds an Plant into the group
     * @param Plant The Plant to be added
     */
    public void addPlant(BasePlant Plant){
        Plants.add(Plant);
    }

    /**
     * Return the Plant in the Plant list by index
     * @param index The index of the Plant
     * @return The Plant in the list
     */
    public BasePlant getPlant(int index){
//        if(index > Plants.size() - 1){
//            return Plants.get(Plants.size() - 1);
//        }
        return Plants.get(index);
    }

    /**
     * Remove the Plant in the Plant list by index
     * @param index The index of the Plant
     */
    public void removePlant(int index){
        Plants.remove(index);
    }

    /**
     * Remove the Plant in the Plant list
     * @param Plant The Plant you want to remove
     */
    public void removePlant(BasePlant Plant){
        Plants.remove(Plant);
    }

    /**
     * Get the size of the group
     * @return The size of the group
     */
    public int size(){
        return Plants.size();
    }

    /**
     * Get a iterator of plant list
     * @return A iterator
     */
    public Iterator iterator(){
        return new CultivationIterator(this.cultivations);
    }

    public void accept(BaseVisitor visitor){
        visitor.visit(this);
    }

}