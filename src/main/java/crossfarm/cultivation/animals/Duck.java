package crossfarm.cultivation.animals;

import crossfarm.actions.sound.DuckSound;
import crossfarm.farmland.Ranch;

public class Duck extends BaseAnimal{

    public Duck() {
        this.soundMaker = new DuckSound();
        this.isSaled = false;
    }
    public double cost() {
        return 50;
    }

    public static void main(String[] args) {

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

    public void tick(){

    }
}
