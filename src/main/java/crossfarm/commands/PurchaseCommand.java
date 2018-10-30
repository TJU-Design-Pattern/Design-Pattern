package crossfarm.commands;

import crossfarm.cultivation.animals.Cat;
import crossfarm.farmland.Ranch;

public class PurchaseCommand implements Command{
    String kind;
    int number;

    public PurchaseCommand(String kind, int number){
        this.kind = kind.toLowerCase();
        this.number = number;
    }
    public void execute(){
        Ranch instance = Ranch.getInstance();
        if(kind == "cat") {
            for (int i = 0; i < number; i++) {
                instance.catMenu.addAnimal(new Cat());
            }
        }
    }
}
