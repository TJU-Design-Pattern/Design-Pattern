package crossfarm.timemachine;
import crossfarm.Farm;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.menu.AnimalMenu;
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
        System.out.println("update animal observer");
        Farm global_farm = getInstance();
        AnimalMenu animal_menu = global_farm.animalMenu;
        int animal_size = animal_menu.size();
        for(int i=0;i<animal_size;i++){
            BaseAnimal animal = animal_menu.getAnimal(i);
            animal.timeChange(this.time_counter.current_time);
            //if the animal is not hungury
            if(animal.state == FullState.getInstance()){
            }
            else{
                /*
                int food_remains = global_farm.foodCourt;
                if(animal.eat_quantity <= food_remains){
                    global_farm.foodCourt -= animal.eat_quantity;
                    animal.state = HungryState.getInstance();
                }
                else{
                    notify mediator;
                }
                */
            }
        }
    }
}
