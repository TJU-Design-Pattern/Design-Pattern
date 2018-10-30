package crossfarm.factories;

import crossfarm.farmland.BaseLand;
import crossfarm.weapon.BaseWeapon;

import crossfarm.weapon.Axe;
import crossfarm.weapon.Shovel;

public class BaseWeaponFactory extends BaseFactory {
    public BaseWeapon axe;
    public BaseWeapon showel;

    public BaseWeaponFactory(){
        this.axe = null;
        this.showel = null;
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
        else if(weapon_type.equalsIgnoreCase("Shovel")){
            if(this.showel == null){
                this.showel = new Shovel();
                return this.showel;
            }
            else{
                return this.showel;
            }
        }
        return null;
    };
}