package crossfarm.factories;

public class FactoryProducer {
    public BaseFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Cultivation")){
            return new BaseCultivationFactory();
        }
        else if(choice.equalsIgnoreCase("Weapon")){
            return new BaseWeaponFactory();
        }
        return null;
    }
}
