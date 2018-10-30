/**
 * 道具包
 * 由 Manager 管理，实际上使用flyweight模式表示各种道具？
 */
package crossfarm.tools;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.weapon.Axe;
import crossfarm.weapon.BaseWeapon;

import java.util.ArrayList;

public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }
    public void constructor(BaseTool baseTool){
        builder.makeBaseTool(baseTool);
    }

}