package crossfarm;

import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.decorators.animals.Colored;
import crossfarm.decorators.animals.Dressed;
import crossfarm.factories.BaseFactory;
import crossfarm.factories.BaseWeaponFactory;
import crossfarm.factories.FactoryProducer;
import crossfarm.manager.*;
import crossfarm.menu.AnimalMenu;
import crossfarm.menu.Iterator;
import crossfarm.menu.PlantMenu;
import crossfarm.tools.ToolPackage;
import crossfarm.weapon.BaseWeapon;

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


        // Command test
        Owner owner = Owner.getInstance();
        System.out.println(owner.getMoney());
        System.out.println(Farm.getInstance().animalMenu.size());
        Owner.getInstance().purchase("cat",3);
        System.out.println(Owner.getInstance().getMoney());
        System.out.println(Farm.getInstance().animalMenu.size());
        Owner.getInstance().sell(Farm.getInstance().animalMenu.getAnimal(0));
        System.out.println(Farm.getInstance().animalMenu.size());
        Farm.getInstance().animalMenu.getAnimal(0).makeSound();

        System.out.println("");
        System.out.println("test for observer");

        System.out.println("end for observer");
        System.out.println("");

        // Decorator test
        BaseAnimal cat = new Cat(farm.getAnimal_manager());
        BaseAnimal dressed_cat = new Dressed(cat);
        BaseAnimal colored_cat = new Colored(cat);
        System.out.println(cat.cost());
        System.out.println(dressed_cat.cost());
        System.out.println(colored_cat.cost());

        // Static Proxy Test
        MoneyGetter moneyGetter = new GetMoneyProxy(owner);
        double money = moneyGetter.getMoney();
        System.out.println("Get " + money);
        
        // Iterator test
        Iterator iterator = Farm.getInstance().animalMenu.iterator();
        while (iterator.hasNext()){
            BaseAnimal animal = (BaseAnimal)iterator.next();
            System.out.println(animal.cost());
        }

        memento.updateState(farm);
    }

}
