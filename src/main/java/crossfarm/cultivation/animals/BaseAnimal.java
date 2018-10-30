package crossfarm.cultivation.animals;

import crossfarm.Farm;
import crossfarm.actions.AnimalAction;
import crossfarm.actions.MakeSound;
import crossfarm.cultivation.BaseCultivation;
import crossfarm.farmland.Ranch;
import crossfarm.manager.Owner;
import crossfarm.menu.AnimalMenu;
import crossfarm.state.Context;
import crossfarm.state.FullState;
import crossfarm.state.HungryState;
import crossfarm.state.State;

public abstract class BaseAnimal extends BaseCultivation{
    MakeSound soundMaker;
    public int lastSupplyTime = 0;

    public void makeSound() {
        soundMaker.makeSound();
    }

    public static void behave(AnimalAction action) { action.doAction(); }

    // 改变状态
    public void changeState(State state) {
        this.state = state;
    }
    // 喂食
    public void getFed(int currentTime) {
        this.state = FullState.getInstance();
        lastSupplyTime = currentTime;
    }

    public boolean isHungry(){
        return this.state == HungryState.getInstance();
    }

    public void doSell(){
        if(this.isSaled){
            System.out.println("This animal is already saled!");
        }
        else{
            this.isSaled = true;

            // Judge the case of the animal
            String name = this.getName();
            if(name == "Cat"){
                Owner.getInstance().editMoney(3000);
            }
            else if(name == "Duck"){
                Owner.getInstance().editMoney(5000);
            }

            // Remove the animal from menu
            Farm instance = Farm.getInstance();
            instance.animalMenu.removeAnimal(this);
            System.out.println("Sale finished!");
        }
    }

}
