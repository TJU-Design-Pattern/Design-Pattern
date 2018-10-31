/**
 * 道具包
 * 由 Manager 管理，实际上使用flyweight模式表示各种道具？
 */
package crossfarm.tools;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.weapon.Axe;
import crossfarm.weapon.BaseWeapon;

import java.util.ArrayList;

public class PackageBuilder extends Builder {
    public void makeBaseTool(BaseTool baseTool){
        System.out.println("");
        System.out.println("======== test for Builder ========");
        baseTool = null;
        System.out.println("Succeed in building baseTool");
        System.out.println("======== end for Builder ========");
        System.out.println("");
    }
}