package crossfarm;

import crossfarm.cultivation.CultivationModule;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.plants.BasePlant;
import crossfarm.decorators.animals.Colored;
import crossfarm.decorators.animals.Dressed;
import crossfarm.factories.BaseFactory;
import crossfarm.manager.*;
import crossfarm.menu.AnimalMenu;
import crossfarm.menu.Iterator;
import crossfarm.menu.PlantMenu;
import crossfarm.timemachine.AnimalObserver;
import crossfarm.timemachine.PlantObserver;
import crossfarm.timemachine.TimeCounter;
import crossfarm.tools.ToolPackage;
import crossfarm.weapon.BaseWeapon;

import static crossfarm.cultivation.CultivationModule.initializePrototype;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Farm farm = Farm.getInstance();
        Memento memento = farm.createMemento();
        initializePrototype();


        // Command test
        System.out.println("");
        System.out.println("======== test for command ========");
        Owner owner = Owner.getInstance();
        System.out.println("The owner's money: " + owner.getMoney());
        System.out.println("The number of animals before purchase: " + Farm.getInstance().animalMenu.size());
        Owner.getInstance().purchase("cat",3);
        Farm.getInstance().farmers.get(0).seedCrop(2);
        System.out.println("The owner's money after purchase cat&crop: " + owner.getMoney());
        System.out.println("The number of animals after purchase: " + Farm.getInstance().animalMenu.size());
        Owner.getInstance().sell(Farm.getInstance().animalMenu.getAnimal(0));
        System.out.println("The number of animals after sell: " + Farm.getInstance().animalMenu.size());
        System.out.println("========= end for command ========");
        System.out.println("");

        // Adapter test
        System.out.println("");
        System.out.println("======== test for adapter ========");
        Farm.getInstance().animalMenu.getAnimal(0).makeSound();
        System.out.println("========= end for adapter ========");
        System.out.println("");


        // Observer test
        System.out.println("");
        System.out.println("========= test for observer ========");
        AnimalMenu animal_menu = Farm.getInstance().animalMenu;
        PlantMenu plant_menu = Farm.getInstance().plantMenu;

        TimeCounter time_counter = new TimeCounter();
        AnimalObserver animal_observer = new AnimalObserver(time_counter);
        PlantObserver plant_observer = new PlantObserver(time_counter);

        for(int i=0;i<10;i++){
            time_counter.updateTime();
        }
        System.out.println("========== end for observer ========");
        System.out.println("");

        // Toolpackage test
        System.out.println("");
        System.out.println("========== test for toolPackage ========");
        ToolPackage tool_package = new ToolPackage();
        BaseFactory weapon_factory = Farm.getInstance().weapon_factory;
        BaseWeapon axe = weapon_factory.getWeapon("Axe");
        tool_package.addTool(axe);
        ToolPackage second_tool_package = new ToolPackage();
        tool_package.addPackage(second_tool_package);
        System.out.println("========= end for toolpackage ==========");
        System.out.println("");

        // Decorator test
        System.out.println("");
        System.out.println("========= test for decorator ========");
        BaseAnimal cat = new Cat(farm.getAnimal_manager());
        BaseAnimal dressed_cat = new Dressed(cat);
        BaseAnimal colored_cat = new Colored(cat);
        System.out.println("The cat cost: " + cat.cost());
        System.out.println("The dressed cat cost: " + dressed_cat.cost());
        System.out.println("The colored cat cost: " + colored_cat.cost());
        System.out.println("========= end for decorator ==========");
        System.out.println("");

        // Static Proxy Test
        System.out.println("");
        System.out.println("========= test for proxy  ==========");
        MoneyGetter moneyGetter = new GetMoneyProxy(owner);
        double money = moneyGetter.getMoney();
        System.out.println("Get " + money);
        System.out.println("========= end for proxy ===========");
        System.out.println("");
        
        // Iterator test
        System.out.println("");
        System.out.println("========= test for iterator  ==========");
        Iterator iterator = Farm.getInstance().animalMenu.iterator();
        int count = 1;
        while (iterator.hasNext()){
            BaseAnimal animal = (BaseAnimal)iterator.next();
            System.out.println("Animal" + count + "costs: "+ animal.cost());
        }
        System.out.println("========= end for iterator ===========");
        System.out.println("");

        memento.updateState(farm);
    }

}
