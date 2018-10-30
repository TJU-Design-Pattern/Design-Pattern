package crossfarm.commands;

import crossfarm.Farm;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.animals.Duck;
import crossfarm.manager.Owner;

public class PurchaseCommand implements Command{
    String kind;
    int number;

    public PurchaseCommand(String kind, int number){
        this.kind = kind.toLowerCase();
        this.number = number;
    }
    public void execute(){
        Farm instance = Farm.getInstance();
        if(kind == "cat") {
            for (int i = 0; i < number; i++) {
                instance.animalMenu.addAnimal(new Cat(instance.getAnimal_manager()));
            }
            Owner.getInstance().editMoney(-1*number);
        }
        else if(kind == "duck"){
            for (int i = 0; i < number; i++) {
                instance.animalMenu.addAnimal(new Duck(instance.getPlant_manager()));
            }
            Owner.getInstance().editMoney(-1*number);
        }
    }
}
