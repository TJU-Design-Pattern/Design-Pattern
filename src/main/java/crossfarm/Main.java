package crossfarm;

import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.manager.Farmer;
import crossfarm.manager.Owner;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        System.out.println(Farm.getInstance().animalMenu.size());
        Owner.getInstance().purchase("cat",3);
        System.out.println(Farm.getInstance().animalMenu.size());
        Owner.getInstance().sell(Farm.getInstance().animalMenu.getAnimal(0));
        System.out.println(Farm.getInstance().animalMenu.size());
        Farm.getInstance().animalMenu.getAnimal(0).makeSound();
    }

}
