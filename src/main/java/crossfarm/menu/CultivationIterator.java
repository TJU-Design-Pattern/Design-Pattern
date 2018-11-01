package crossfarm.menu;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.animals.BaseAnimal;

import java.util.List;

public class CultivationIterator implements Iterator{
    private List<BaseCultivation> cultivation_list;
    private int index;

    public CultivationIterator(List<BaseCultivation> cultivation_list){
        this.cultivation_list = cultivation_list;
        this.index = 0;
    }

    /**
     * Return whether the list has next element
     * @return A boolean value reflect whether the list has next element
     */
    public boolean hasNext(){
        if(index < cultivation_list.size()){
            return true;
        }
        else
            return false;
    }

    /**
     * Return the next cultivation in the list
     * @return The next cultivation in the list
     */
    public Object next(){
        BaseCultivation next = cultivation_list.get(index);
        index++;
        return next;
    }

    public void setIndex(int index){
        this.index = index;
    }
}
