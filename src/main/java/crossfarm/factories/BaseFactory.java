package crossfarm.factories;

import crossfarm.farmland.BaseLand;
import crossfarm.weapon.BaseWeapon;

public abstract class BaseFactory {
    public abstract BaseLand getLand(String land_type);
    public abstract BaseWeapon getWeapon(String weapon_type);

}
