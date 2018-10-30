package crossfarm.commands;

import crossfarm.cultivation.animals.BaseAnimal;

public class SellCommand implements Command{
    protected BaseAnimal animal;

    // Constructor
    public SellCommand(BaseAnimal animal){
        this.animal = animal;
    }

    public void execute(){
        animal.doSell();
    }
}
