package crossfarm.cultivation.animals;

import crossfarm.actions.sound.CatSound;
import crossfarm.decorators.animals.Dressed;
import crossfarm.farmland.Ranch;

public class Cat extends BaseAnimal {
    public Cat() {
        this.soundMaker = new CatSound();
        this.isSaled = false;
    }
    public double cost() {
        return 50;
    }

    public static void main(String[] args) {
        Cat c = new Cat();
        c.makeSound();
        c.isSaled = false;
        System.out.println(c.cost());
        System.out.println("Now we get a dress for out lovely cat");
       // BaseAnimal animal = new Dressed(c);
       // System.out.println(animal.cost());
    }

    public void doSell(){
        if(this.isSaled){
            System.out.println("This animal is already saled!");
        }
        else{
            this.isSaled = true;
            Ranch instance = Ranch.getInstance();
            instance.catMenu.removeAnimal(this);
            System.out.println("Sale finished!");
        }
    }

    public void tick(){

    }
}
