package crossfarm.tools;

import crossfarm.decorators.farmers.BaseFarmerDecorator;
import crossfarm.weapon.BaseWeapon;
import crossfarm.manager.Farmer;
import crossfarm.decorators.farmers.Shoveled;
import crossfarm.decorators.farmers.Axed;
import crossfarm.weapon.Axe;
import crossfarm.weapon.Shovel;

public class Weapon{
    public BaseFarmerDecorator use(Farmer farmer, BaseWeapon weapon){
        if(weapon instanceof Axe){
            return new Axed(farmer);
        }
        else{
            return new Shoveled(farmer);
        }
    }
}