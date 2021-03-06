package crossfarm.cultivation.animals;

import crossfarm.Farm;
import crossfarm.actions.AnimalAction;
import crossfarm.actions.ChangeSoundAdapter;
import crossfarm.actions.MakeSound;
import crossfarm.cultivation.BaseCultivation;
import crossfarm.farmland.Ranch;
import crossfarm.manager.AnimalManager;
import crossfarm.manager.Colleague;
import crossfarm.manager.Mediator;
import crossfarm.manager.Owner;
import crossfarm.menu.AnimalMenu;
import crossfarm.state.Context;
import crossfarm.state.FullState;
import crossfarm.state.HungryState;
import crossfarm.state.State;

public abstract class BaseAnimal extends BaseCultivation implements Colleague{
    MakeSound soundMaker;
    public ChangeSoundAdapter soundAdapter;
    protected AnimalManager _animal_manager;
    public int lastSupplyTime = 0;
    public int appetite = 0;

    public void makeSound() {
        soundMaker.makeSound();
    }

    public void behave(AnimalAction action) { action.doAction(); }

    // 改变状态
    public void changeState(State state) {
        this.state = state;
        if(isHungry()){
            setColleagueUpdated();
        }
    }

    public void changeAdapter(String sound){
        this.soundAdapter = new ChangeSoundAdapter(sound);
    }

    // 喂食
    public void getFed(int currentTime) {
        this.state = FullState.getInstance();
        lastSupplyTime = currentTime;
    }

    public boolean isHungry(){
        return this.state == HungryState.getInstance();
    }

    public int getAppetite(){
        return this.appetite;
    };

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

    public void setMediator(Mediator mediator){
        this._animal_manager = (AnimalManager) mediator;
    }

    public void setColleagueUpdated(){
        _animal_manager.colleagueChanged();
    }

}
