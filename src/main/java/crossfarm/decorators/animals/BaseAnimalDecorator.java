/**
 * 基础的装饰器
 */
package crossfarm.decorators.animals;

import crossfarm.cultivation.animals.BaseAnimal;

public abstract class BaseAnimalDecorator extends BaseAnimal {
    protected BaseAnimal animal;

    protected BaseAnimalDecorator(BaseAnimal animal){
        this.animal = animal;
    }
}
