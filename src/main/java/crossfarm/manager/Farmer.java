/**
 * 系统的管理者，单例的用户
 * 表示正在使用的用户
 */
package crossfarm.manager;

import com.apple.eawt.AppEvent;
import crossfarm.Farm;
import crossfarm.commands.Command;
import crossfarm.commands.PurchaseCommand;
import crossfarm.commands.SeedCommand;
import crossfarm.commands.SellCommand;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.plants.BasePlant;
import crossfarm.farmland.Ranch;

import java.util.Set;

import java.io.Serializable;

public class Farmer implements Serializable {
    //private double money;
    private boolean has_axe;
    public boolean has_big_shovel;
    public boolean has_small_shovel;
    private boolean has_sickle;
    private boolean isWorking;


    // init our only owner
    //private static Farmer instance = new Farmer();

    public Farmer() {
        //
        //this.money = 0;
        this.has_axe = false;
        this.has_big_shovel = false;
        this.has_small_shovel = true;
        this.isWorking = false;
    }

    public void setHas_axe(boolean has_axe) {
        this.has_axe = has_axe;
    }

    public void setHas_big_shovel(boolean has_shovel) {
        this.has_big_shovel = has_shovel;
        this.has_small_shovel = false;
    }

    public void setHas_sickle(boolean has_sickle) {
        this.has_sickle = has_sickle;
    }

    public boolean freeToReap(){
        return has_sickle && !isWorking;
    }

    /**
     * Return the work status of the farmer
     * @return The work status of the farmer
     */
    public boolean getWorkStatus(){
        return this.isWorking;
    }

    /**
     * Sell the animal
     * @param animal
     */
    public void sell(BaseAnimal animal){
        this.isWorking = true;
        Command cmd = new SellCommand(animal);
        cmd.execute();
        this.isWorking = false;
    }

    /**
     * Purchase animals
     * @param kind The kind of animal you want to purchase
     * @param number The number of animal you want to purchase
     */
    public void purchase(String kind,int number){
        this.isWorking = true;
        Command cmd = new PurchaseCommand(kind, number);
        cmd.execute();
        this.isWorking = false;
    }

    /**
     * Seed crops
     * @param number The number of crop you want to seed
     */
    public void seedCrop(int number){
        this.isWorking = true;
        Command cmd = new SeedCommand(number);
        cmd.execute();
        this.isWorking = false;
    }

    public boolean solveStarvation(FarmerSolveStarvation handler, Starvation starvation){
        int food_needed = starvation._deficiency_food_amount;
        if(handler._farm.warehouse > food_needed){
            if(this.has_small_shovel){
                handler._farm.add_little_food.AddFood(food_needed);
            } else {
                handler._farm.add_much_food.AddFood(food_needed);
            }
            return true;
        } else {
            starvation._deficiency_money_amount = (food_needed - handler._farm.warehouse) / 10 * 0.1;
            return false;
        }
    }

    public void reapCrops(Set<BasePlant> crops, Farm farm){
        farm.foodCourt += crops.size() * 10;
        farm.plantMenu.Plants.removeAll(crops);
        System.out.println("Farmer[ " + this + " ] reaps " + crops.size() + " crops");
        crops.clear();
    }
}
