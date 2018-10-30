package crossfarm.commands;

import crossfarm.Farm;
import crossfarm.cultivation.CultivationModule;
import crossfarm.cultivation.plants.BasePlant;
import crossfarm.cultivation.plants.Crop;
import crossfarm.manager.Owner;

public class SeedCommand implements Command{
    int number;

    public SeedCommand(int number){
        this.number = number;
    }
    public void execute(){
        Farm instance = Farm.getInstance();
        for (int i = 0; i < number; i++) {
            instance.plantMenu.addPlant((BasePlant) CultivationModule.findAndClone("Crop"));
        }
        Owner.getInstance().editMoney(-0.1*number);
    }
}
