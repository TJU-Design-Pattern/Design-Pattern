/**
 * 基础的装饰器
 */
package crossfarm.decorators.animals;

import crossfarm.cultivation.animals.BaseAnimal;

public abstract class BaseAnimalDecorator extends BaseAnimal {
    // 动物售卖的价格
    public abstract double cost();
}
