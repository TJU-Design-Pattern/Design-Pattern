package crossfarm;

import com.sun.xml.internal.rngom.parse.host.Base;
import crossfarm.actions.DuckSound;
import crossfarm.cultivation.CultivationModule;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.animals.Duck;
import crossfarm.decorators.animals.Colored;
import crossfarm.decorators.animals.Dressed;
import crossfarm.factories.BaseFactory;
import crossfarm.farmland.BaseLand;
import crossfarm.manager.*;
import crossfarm.menu.AnimalMenu;
import crossfarm.menu.Iterator;
import crossfarm.menu.PlantMenu;
import crossfarm.timemachine.AnimalObserver;
import crossfarm.timemachine.PlantObserver;
import crossfarm.timemachine.TimeCounter;
import crossfarm.tools.ToolPackage;
import crossfarm.visitor.BaseVisitor;
import crossfarm.visitor.FarmVisitor;
import crossfarm.weapon.BaseWeapon;

import java.awt.peer.SystemTrayPeer;

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

        // Prototype test
        System.out.println("");
        System.out.println("======== test for prototype ========");
        initializePrototype();
        Duck duck = (Duck) CultivationModule.findAndClone("Duck");
        System.out.println("I am a " + duck.getName());
        System.out.println("========= end for prototype ========");
        System.out.println("");

        // Strategy test
        System.out.println("");
        System.out.println("======== test for strategy ========");
        duck.behave(new DuckSound());
        System.out.println("========= end for strategy ========");
        System.out.println("");

        // Command and Facade test
        System.out.println("");
        System.out.println("======== test for command ========");
        Owner owner = Owner.getInstance();
        System.out.println("The owner's money: " + owner.getMoney());
        System.out.println("The number of animals before purchase: " + Farm.getInstance().animalMenu.size());
        Owner.getInstance().purchase("cat",8);
        Farm.getInstance().farmers.get(0).seedCrop(15);
        System.out.println("The owner's money after purchase cat&crop: " + owner.getMoney());
        System.out.println("The number of animals after purchase: " + Farm.getInstance().animalMenu.size());
        Owner.getInstance().sell(Farm.getInstance().animalMenu.getAnimal(0));
        System.out.println("The number of animals after sell: " + Farm.getInstance().animalMenu.size());
        System.out.println("========= end for command ========");
        System.out.println("");

        // Adapter test
        System.out.println("");
        System.out.println("======== test for adapter ========");
        Farm.getInstance().animalMenu.getAnimal(0).changeAdapter("哇卡卡卡卡");
        Farm.getInstance().animalMenu.getAnimal(0).soundAdapter.makeSound();
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

        for(int i=0;i<150;i++){
            time_counter.updateTime();
        }
        System.out.println("========== end for observer ========");
        System.out.println("");

        // Visitor test
        System.out.println("");
        System.out.println("======== test for visitor ========");
        BaseVisitor farm_visitor = new FarmVisitor();
        animal_menu.accept(farm_visitor);
        plant_menu.accept(farm_visitor);
        System.out.println("======== end for visitor =========");
        System.out.println("");

        // Toolpackage & Builder test
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

        // Abstract Factory & FlyWeight test
        System.out.println("");
        System.out.println("========== test for factory ============");
        BaseFactory cultivation_factory = Farm.getInstance().cultivation_factory;
        System.out.println("Get land from factory");
        BaseLand ranch = cultivation_factory.getLand("Ranch");
        BaseLand field = cultivation_factory.getLand("Field");

        System.out.println("Get weapon from factory");
        BaseWeapon axe_1 = weapon_factory.getWeapon("Axe");
        BaseWeapon big_shovel = weapon_factory.getWeapon("BigShovel");
        BaseWeapon small_shovel = weapon_factory.getWeapon("SmallShovel");
        System.out.println("========== end for factory ===========");

        // Decorator test
        System.out.println("");
        System.out.println("========= test for decorator ========");
        BaseAnimal cat1 = Farm.getInstance().animalMenu.getAnimal(0);
        BaseAnimal cat2 = Farm.getInstance().animalMenu.getAnimal(1);
        BaseAnimal dressed_cat = new Dressed(cat1);
        BaseAnimal colored_cat = new Colored(cat2);
        System.out.println("The cat cost: " + cat1.cost());
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
