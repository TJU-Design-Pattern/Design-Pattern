package crossfarm.cultivation.animals;

import crossfarm.Farm;
import crossfarm.actions.CatSound;
import crossfarm.actions.CatEat;
import crossfarm.decorators.animals.Dressed;
import crossfarm.state.FullState;

public class Cat extends BaseAnimal {
    public Cat() {
        this.soundMaker = new CatSound();
        this.isSaled = false;
        this.isMature = false;
    }
    public double cost() {
        return 50;
    }

    public void timeChange(int currentTime) {
        if(lastSupplyTime > currentTime) {
            if(currentTime + 24 -lastSupplyTime > 5) {
                // 猫饿了
                state.getHungry(this);
            }
            else {
                state.gainExperience(this);
            }
        }
        else {
            if(currentTime - lastSupplyTime > 5) {
                // 猫饿了
                state.getHungry(this);
                System.out.println("猫饿了");
            }
            else {
                state.gainExperience(this);
            }
        }
        if(this.experience >= 144){
            this.isMature = true;
        }
    }

    // 喂食重写-猫
    public void getFed(int currentTime) {
        this.state = FullState.getInstance();
        lastSupplyTime = currentTime;

        behave(new CatEat());
    }

    public static void main(String[] args) {
        Cat c = new Cat();
        System.out.println(c.cost());
        System.out.println("Now we get a dress for out lovely cat");
        BaseAnimal animal = new Dressed(c);
        System.out.println(animal.cost());

        behave(new CatSound());
        c.getFed(10);
    }

    public void tick(){

    }
}
