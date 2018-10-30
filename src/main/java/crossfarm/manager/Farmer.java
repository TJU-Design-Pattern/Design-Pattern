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
    private double money;

    public Farmer() {
        //
        this.money = 0;
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
