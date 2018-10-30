package crossfarm.tools;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.decorators.animals.Dressed;

public class Cloth extends BaseTool {

    public BaseAnimal use(BaseCultivation cultivation) {
        // if it's an animal
        if (!(cultivation instanceof BaseAnimal)) {
            throw new RuntimeException("Type Error");
        }

        BaseAnimal animal = (BaseAnimal)cultivation;
        return new Dressed(animal);
    }
}
