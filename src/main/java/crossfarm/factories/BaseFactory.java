package crossfarm.factories;

import crossfarm.farmland.BaseLand;
import crossfarm.weapon.BaseWeapon;

import java.io.Serializable;

public abstract class BaseFactory implements Serializable {
    public abstract BaseLand getLand(String land_type);
    public abstract BaseWeapon getWeapon(String weapon_type);

}
