package crossfarm.factories;

import crossfarm.farmland.BaseLand;
import crossfarm.weapon.*;

import java.io.Serializable;

public class BaseWeaponFactory extends BaseFactory implements Serializable {
    public BaseWeapon axe;
    public BaseWeapon shovel;

    public BaseWeaponFactory(){
        this.axe = null;
        this.shovel = null;
    }

    public BaseLand getLand(String land_type){
        return null;
    }

    public BaseWeapon getWeapon(String weapon_type){
        if(weapon_type == null){
            return null;
        }
        else if(weapon_type.equalsIgnoreCase("Axe")){
            if(this.axe == null){
                this.axe = new Axe();
                return this.axe;
            }
            else{
                return this.axe;
            }
        }
        else if(weapon_type.equalsIgnoreCase("BigShovel")){
            if(this.shovel == null){
                this.shovel = new BigShovel();
                return this.shovel;
            }
            else{
                return this.shovel;
            }
        }
        else if(weapon_type.equalsIgnoreCase("SmallShovel")){
            if(this.shovel == null){
                this.shovel = new SmallShovel();
                return this.shovel;
            }
            else{
                return this.shovel;
            }
        }
        return null;
    }
}