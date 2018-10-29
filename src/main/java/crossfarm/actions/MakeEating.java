/**
 * Copyright (c) 2018.10.29 ZWZ
 * 动物进食行为的接口，模拟策略模式
 */
package crossfarm.actions;

public interface MakeEating extends AnimalAction{
    /**
     * 吃东西
     */
    void makeEating();
}
