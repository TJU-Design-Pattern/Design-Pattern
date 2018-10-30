package crossfarm.cultivation.animals;

import crossfarm.actions.DuckSound;
import crossfarm.actions.DuckEat;
import crossfarm.decorators.animals.Dressed;
import crossfarm.actions.sound.DuckSound;
import crossfarm.farmland.Ranch;

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

        behave(new DuckSound());
        behave(new DuckEat());
    }
    
    public void doSell(){
        if(this.isSaled){
            System.out.println("This animal is already saled!");
        }
        else{
            this.isSaled = true;
            Ranch instance = Ranch.getInstance();
            instance.duckMenu.removeAnimal(this);
            System.out.println("Sale finished!");
        }
    }
}
