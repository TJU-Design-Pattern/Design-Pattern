package crossfarm.timemachine;
import com.sun.xml.internal.rngom.parse.host.Base;
import crossfarm.Farm;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.menu.AnimalMenu;
import crossfarm.menu.Iterator;
import crossfarm.state.FullState;
import crossfarm.state.HungryState;

import static crossfarm.Farm.*;

public class AnimalObserver extends Observer{
    public AnimalObserver(TimeCounter time_counter){
        this.time_counter = time_counter;
        this.time_counter.attach(this);
    }
    @Override
    public void update() {
        System.out.println("Time at" + this.time_counter.current_time + " :check animal observer");
        Farm global_farm = getInstance();
        AnimalMenu animal_menu = global_farm.animalMenu;
        AnimalMenu sec_animal_menu = animal_menu;

        Iterator iter = sec_animal_menu.iterator();
        //iter.setIndex(0);
        while(iter.hasNext()){
            System.out.println(sec_animal_menu.size());
            BaseAnimal iter_animal = (BaseAnimal)iter.next();
            iter_animal.timeChange(this.time_counter.current_time);
            if(!iter_animal.isHungry()){
            }
            else{
                int food_remains = global_farm.foodCourt;
                if(iter_animal.appetite <= food_remains){
                    global_farm.foodCourt -= iter_animal.appetite;
                    iter_animal.getFed(this.time_counter.current_time);
                }
            }
            //iter_animal = nextAnimal;
        }
    }
}