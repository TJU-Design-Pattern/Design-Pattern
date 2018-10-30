package crossfarm.cultivation.animals;

import crossfarm.actions.DuckSound;
import crossfarm.actions.DuckEat;
import crossfarm.decorators.animals.Dressed;
import crossfarm.farmland.Ranch;
import crossfarm.manager.Mediator;
import crossfarm.state.FullState;


public class Duck extends BaseAnimal {
    public Duck(Mediator animal_manager) {
        this.isMature = false;
        this.appetite = 2;
        this.setMediator(animal_manager);
    }
    public double cost() {
        return 50;
    }
    public void tick() { return; }

    public void timeChange(int currentTime) {
        if(lastSupplyTime > currentTime) {
            if(currentTime + 24 -lastSupplyTime > 2) {
                // 鸭子饿了
                state.getHungry(this);
            }
            else {
                state.gainExperience(this);
            }
        }
        else {
            // 鸭子饿了
            if(currentTime - lastSupplyTime > 2) {
                state.getHungry(this);
            }
            else {
                state.gainExperience(this);
            }
        }
        if(this.experience >= 96){
            this.isMature = true;
        }
    }

    // 喂食重写-鸭子
    public void getFed(int currentTime) {
        this.state = FullState.getInstance();
        lastSupplyTime = currentTime;

        behave(new DuckEat());
    }

//    public static void main(String[] args) {
//        Duck c = new Duck();
//        System.out.println(c.cost());
//        System.out.println("Now we get a dress for our lovely cat");
//        BaseAnimal animal = new Dressed(c);
//        System.out.println(animal.cost());
//
//        behave(new DuckSound());
//        behave(new DuckEat());
//    }
}
