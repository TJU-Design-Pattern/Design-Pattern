package crossfarm.cultivation;

import crossfarm.Farm;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.animals.Duck;
import crossfarm.cultivation.plants.Crop;

import java.util.ArrayList;
import java.util.List;

public class CultivationModule {
    // 目前有猫，鸭子，作物
    private static CultivationPrototype[] prototypes = new CultivationPrototype[3];
    private static int total = 0;

    public static void addPrototype(CultivationPrototype pro) {
        prototypes[total++] = pro;
    }

    public static BaseCultivation findAndClone(String name) {
        for (int i=0; i<total; i++) {
            if (prototypes[i].getName().equals(name)) {
                return prototypes[i].clone();
            }
        }
        System.out.println(name + " not found");
        return null;
    }

    public static void initializePrototype() {
        System.out.println("x");

        Farm farm = Farm.getInstance();

        CultivationModule.addPrototype(new Cat(farm.getAnimal_manager()));
        CultivationModule.addPrototype(new Duck(farm.getAnimal_manager()));
        CultivationModule.addPrototype(new Crop(farm.getPlant_manager()));
    }

    public static void main(String args[]) {

        initializePrototype();
        BaseCultivation[] container = new BaseCultivation[5];
        int total = 0;
        List<String> checkList = new ArrayList<String>();
        checkList.add("Cat");
        checkList.add("Duck");
        checkList.add("Cat");
        checkList.add("Crop");
        checkList.add("CCC");

        for (int i=0; i<5; i++) {
            container[total] = CultivationModule.findAndClone(checkList.get(i));
            if (container[total] != null) {
                total++;
            }
        }

        for(int i=0; i<total; i++) {
            System.out.println(container[i].getName());
        }
    }
}
