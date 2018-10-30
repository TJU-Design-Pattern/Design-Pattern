package crossfarm.decorators.farmers;
import crossfarm.manager.Farmer;
import crossfarm.weapon.BaseWeapon;

public class Shoveled extends BaseFarmerDecorator{
    private Farmer farmer;

    public Shoveled(Farmer farmer){
        this.farmer = farmer;
        this.farmer.setHas_shovel(true);
    }
}