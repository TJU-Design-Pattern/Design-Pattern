/**
 * 基本的植物工厂
 */
package crossfarm.factories;
import crossfarm.farmland.BaseLand;
import crossfarm.farmland.Field;
import crossfarm.farmland.Ranch;
import crossfarm.weapon.BaseWeapon;

public class BaseCultivationFactory extends BaseFactory{
    public Field field;
    public Ranch ranch;

    public BaseCultivationFactory(){
        this.field = null;
        this.ranch = null;
    }

    public BaseWeapon getWeapon(String weapon_type){
        return null;
    }

    public BaseLand getLand(String land_type){
        if(land_type == null){
            return null;
        }
        else if (land_type == "Field"){
            if(this.field == null){
                this.field = new Field();
                return this.field;
            }
            else{
                return this.field;
            }
        }
        else if (land_type == "Ranch"){
            if(this.ranch == null){
                this.ranch = new Ranch();
                return this.ranch;
            }
            else{
                return this.ranch;
            }
        }
        return null;
    }
}
