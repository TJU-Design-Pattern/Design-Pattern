/**
 * 道具包
 * 由 Manager 管理，实际上使用flyweight模式表示各种道具？
 */
package crossfarm.tools;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.weapon.BaseWeapon;

import java.util.ArrayList;


///////////>>>>>>>>>>>>>????
public class ToolPackage {
    public ArrayList<BaseCultivation> my_tools;
    public ArrayList<BaseWeapon> my_weapons;
    public ArrayList<ToolPackage> my_bags;
}
///////////////////////////
