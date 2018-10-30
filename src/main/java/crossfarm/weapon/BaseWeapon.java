package crossfarm.weapon;

import crossfarm.decorators.farmers.Axed;
import crossfarm.decorators.farmers.BaseFarmerDecorator;
import crossfarm.decorators.farmers.Shoveled;
import crossfarm.manager.Farmer;
import crossfarm.tools.BaseTool;

import java.io.Serializable;

public class BaseWeapon extends BaseTool implements Serializable {
    public BaseFarmerDecorator use(Farmer farmer, BaseWeapon weapon){
        if(weapon instanceof Axe){
            return new Axed(farmer);
        }
        else{
            return new Shoveled(farmer);
        }
    }
}
