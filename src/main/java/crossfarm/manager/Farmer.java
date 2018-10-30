/**
 * 系统的管理者，单例的用户
 * 表示正在使用的用户
 */
package crossfarm.manager;

import crossfarm.commands.Command;
import crossfarm.commands.PurchaseCommand;
import crossfarm.commands.SellCommand;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.farmland.Ranch;

public class Farmer {
    //private double money;
    private boolean has_axe;
    private boolean has_shovel;

    // init our only owner
    //private static Farmer instance = new Farmer();

    public Farmer() {
        //
        //this.money = 0;
        this.has_axe = false;
        this.has_shovel = false;
    }

    public void setHas_axe(boolean has_axe) {
        this.has_axe = has_axe;
    }

    public void setHas_shovel(boolean has_shovel) {
        this.has_shovel = has_shovel;
    }
    /**
     * Sell the animal
     * @param animal
     */
    public void sell(BaseAnimal animal){
        Command cmd = new SellCommand(animal);
        cmd.execute();
    }

    /**
     * Purchase animals
     * @param kind The kind of animal you want to purchase
     * @param number The number of animal you want to purchase
     */
    public void purchase(String kind,int number){
        Command cmd = new PurchaseCommand(kind, number);
        cmd.execute();
    }
}
