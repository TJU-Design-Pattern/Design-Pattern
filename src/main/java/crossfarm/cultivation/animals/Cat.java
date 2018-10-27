package crossfarm.cultivation.animals;

import crossfarm.actions.sound.CatSound;
import crossfarm.decorators.animals.Dressed;

public class Cat extends BaseAnimal {
    public Cat() {
        this.soundMaker = new CatSound();
    }
    public double cost() {
        return 50;
    }

    public static void main(String[] args) {
        Cat c = new Cat();
        c.makeSound();
        System.out.println(c.cost());
        System.out.println("Now we get a dress for out lovely cat");
        BaseAnimal animal = new Dressed(c);
        System.out.println(animal.cost());
    }
}
