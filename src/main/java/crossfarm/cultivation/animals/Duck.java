package crossfarm.cultivation.animals;

import crossfarm.actions.DuckSound;
import crossfarm.actions.DuckEat;
import crossfarm.decorators.animals.Dressed;

public class Duck extends BaseAnimal {
    public Duck() {  }
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
        }
        else {
            // 鸭子饿了
            if(currentTime - lastSupplyTime > 2) {
                state.getHungry(this);
            }
        }
    }

    public static void main(String[] args) {
        Duck c = new Duck();
        System.out.println(c.cost());
        System.out.println("Now we get a dress for out lovely cat");
        BaseAnimal animal = new Dressed(c);
        System.out.println(animal.cost());

        behave(new DuckSound());
        behave(new DuckEat());
    }
}
