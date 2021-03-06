/**
 * 动物穿了衣服卖的更多？
 */
package crossfarm.decorators.animals;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;

public class Dressed extends BaseAnimalDecorator {

    public Dressed(BaseAnimal animal){
        super(animal);
    }

    public double cost() {
//      穿了衣服加50元
        return this.animal.cost() + 50;
    }

    public String getName() {
        return animal.getName();
    }
    public BaseCultivation clone() {
        return null;
    }

    public void tick(){

    }

    public void timeChange(int hour) {

    }
}
