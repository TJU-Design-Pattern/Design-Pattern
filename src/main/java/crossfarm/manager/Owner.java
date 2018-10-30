package crossfarm.manager;

import crossfarm.Farm;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.menu.AnimalMenu;
import crossfarm.menu.PlantMenu;
import crossfarm.visitor.FarmVisitor;

public class Owner implements MoneyGetter {
    private double money;

    private static Owner instance = new Owner();

    private Owner(){
        this.money = 1000;
    }

    /**
     * Get the instance of the owner
     * @return The instance of the owner
     */
    public static Owner getInstance() {
        Owner temp = instance;
        if(temp == null){
            synchronized(Owner.class){
                temp = instance;
                if(temp == null){
                    instance = new Owner();
                    temp = instance;
                }
            }
        }
        return temp;
    }

    /**
     * Find a free farmer
     * @return A free farmer
     */
    public Farmer findFreeFarmer(){
        Farmer temp = null;
        for (Farmer i: Farm.getInstance().farmers) {
            if(i.getWorkStatus() == false){
                temp = i;
                break;
            }
        }
        if(temp == null){
            System.out.println("The farmers are all busy! Please wait for a moment.");
        }
        return temp;
    }

    /**
     * Find a free farmer and send a sell command to the farmer
     */
    public void sell(BaseAnimal animal){
        Farmer temp = findFreeFarmer();
        if(temp != null){
            temp.sell(animal);
        }
    }

    /**
     * Find a free farmer and send a purchase command to the farmer
     * @param kind The kind of animal you want to purchase
     * @param number The number of animal you want to purchase
     */
    public void purchase(String kind,int number){
        Farmer temp = findFreeFarmer();
        if(temp != null){
            temp.purchase(kind, number);
        }
    }

    /**
     * Get the money of the owner
     * @return The money of the owner
     */
    public double getMoney(){
        return this.money;
    }

    /**
     * Edit the money of the owner
     * @param money the number of money, support minus
     */
    public void editMoney(double money){
        this.money += money;
    }

    public void visitFarm(){
        Farm global_farm = Farm.getInstance();
        FarmVisitor visitor = new FarmVisitor();
        AnimalMenu animal_menu = global_farm.animalMenu;
        PlantMenu plant_menu = global_farm.plantMenu;
        animal_menu.accept(visitor);
        plant_menu.accept(visitor);
    }

    public boolean solveStarvation(OwnerSolveStarvation handler, Starvation starvation){
        int food_needed = starvation._deficiency_food_amount;

        if(this.getMoney() > starvation._deficiency_money_amount){
            handler._farm.foodCourt += handler._farm.warehouse;
            handler._farm.warehouse = 0;
            handler._farm.foodCourt += food_needed;
            this.money -= starvation._deficiency_money_amount;

            return true;
        } else {
            System.out.println("[Warning] : Bankrupt!");
            return false;
        }
    }
}
