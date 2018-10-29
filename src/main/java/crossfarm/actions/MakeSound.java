/**
 * Copyright (c) 2018.10.29 ZWZ
 * 动物发出声音行为的接口，模拟策略模式
 */
package crossfarm.actions;

public interface MakeSound extends AnimalAction{
    /**
     * 发出声音
     */
    void makeSound();
}
