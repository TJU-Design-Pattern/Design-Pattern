/**
 * 动物穿了衣服卖的更多？
 */
package crossfarm.decorators.animals;

import crossfarm.cultivation.animals.BaseAnimal;

public class Dressed extends BaseAnimalDecorator {

    private BaseAnimal animal;

    public Dressed(BaseAnimal animal) {
        this.animal = animal;
    }
    public double cost() {
//      穿了衣服加50元
        return this.animal.cost() + 50;
    }
    public void tick() { return; }

    public void timeChange(int hour) {}
}
