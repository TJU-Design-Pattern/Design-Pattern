package crossfarm;

import crossfarm.farmland.Ranch;
import crossfarm.manager.Farmer;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Farmer farmer = new Farmer();

        System.out.println(Ranch.getInstance().catMenu.size());
        farmer.purchase("cat",3);
        System.out.println(Ranch.getInstance().catMenu.size());
        farmer.sell(Ranch.getInstance().catMenu.getAnimal(0));
        System.out.println(Ranch.getInstance().catMenu.size());
        Ranch.getInstance().catMenu.getAnimal(0).makeSound();
    }
}
