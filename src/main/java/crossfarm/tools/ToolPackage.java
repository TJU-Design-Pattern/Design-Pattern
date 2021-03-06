/**
 * 道具包
 * 由 Manager 管理，实际上使用flyweight模式表示各种道具？
 */
package crossfarm.tools;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.weapon.Axe;
import crossfarm.weapon.BaseWeapon;

import java.util.ArrayList;

public class ToolPackage {
    public static BaseTool base_tool;
    public ArrayList<ToolPackage> my_bags;

    public ToolPackage(){
        PackageBuilder packageBuilder = new PackageBuilder();
        Director director = new Director(packageBuilder);
        director.constructor(this.base_tool);
        my_bags = new ArrayList<ToolPackage>();
    }

    public void addTool(BaseTool base_tool){
        this.base_tool = base_tool;
    }

    public void addPackage(ToolPackage tool_package){
        System.out.println("Succeed in putting toolpackage into current toolpackage");
        this.my_bags.add(tool_package);
    }
}