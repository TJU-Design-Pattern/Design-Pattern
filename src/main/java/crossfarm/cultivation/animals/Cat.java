package crossfarm.cultivation.animals;

import crossfarm.actions.CatSound;
import crossfarm.actions.CatEat;
import crossfarm.decorators.animals.Dressed;

public class Cat extends BaseAnimal {
    public Cat() {}
    public double cost() {
        return 50;
    }
    public void tick() { return; }

    public void timeChange(int currentTime) {
        if(lastSupplyTime > currentTime) {
            if(currentTime + 24 -lastSupplyTime > 5) {
                // 猫饿了
                state.getHungry(this);
            }
        }
        else {
            if(currentTime - lastSupplyTime > 5) {
                // 猫饿了
                state.getHungry(this);
                System.out.println("猫饿了");
            }
        }
    }

    public static void main(String[] args) {
        Cat c = new Cat();
        System.out.println(c.cost());
        System.out.println("Now we get a dress for out lovely cat");
        BaseAnimal animal = new Dressed(c);
        System.out.println(animal.cost());

        behave(new CatSound());
        behave(new CatEat());

    }
}
