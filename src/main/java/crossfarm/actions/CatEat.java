/**
 * Copyright (c) 2018.10.29 ZWZ
 * 猫进食行为的实现，模拟策略模式
 */
package crossfarm.actions;

public class CatEat implements MakeEating{

    public void makeEating() {
        System.out.println("猫吃了");
    }

    public void doAction() { makeEating(); }
}
