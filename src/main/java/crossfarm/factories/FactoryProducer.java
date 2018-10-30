package crossfarm.factories;

public class FactoryProducer {
    public static BaseFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Cultivation")){
            return new BaseCultivationFactory();
        }
        else if(choice.equalsIgnoreCase("Weapon")){
            return new BaseWeaponFactory();
        }
        return null;
    }
}
