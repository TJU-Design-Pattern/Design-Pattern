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

    public static void main(String[] args) {
        Duck c = new Duck();
        System.out.println(c.cost());
        System.out.println("Now we get a dress for out lovely cat");
        BaseAnimal animal = new Dressed(c);
        System.out.println(animal.cost());

//        behave(new DuckSound());
        if( c instanceof  Duck){
            System.out.println("test");
        }
        behave(new DuckEat());
    }
}
