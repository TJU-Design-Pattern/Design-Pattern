package crossfarm.cultivation;

import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.animals.Duck;
import crossfarm.cultivation.plants.Crop;

import java.util.ArrayList;
import java.util.List;

public interface CultivationPrototype {
    BaseCultivation clone();
    String getName();
}

class CultivationModule {
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
        CultivationModule.addPrototype(new Cat());
        CultivationModule.addPrototype(new Duck());
        CultivationModule.addPrototype(new Crop());
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
