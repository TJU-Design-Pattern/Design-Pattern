package crossfarm.decorators.farmers;
import crossfarm.manager.Farmer;
import crossfarm.weapon.BaseWeapon;

import java.awt.*;

public class Axed extends BaseFarmerDecorator{
    private Farmer farmer;

    public Axed(Farmer farmer){
        //this.farmer = Farmer.getInstance();
        this.farmer = farmer;
        this.farmer.setHas_axe(true);
    }
}