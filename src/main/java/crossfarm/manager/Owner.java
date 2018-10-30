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
     * @return
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
     * @param kind
     * @param number
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
}
