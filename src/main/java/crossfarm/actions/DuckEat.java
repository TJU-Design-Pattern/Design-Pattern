/**
 * Copyright (c) 2018.10.29 ZWZ
 * 鸭子进食行为的实现，模拟策略模式
 */
package crossfarm.actions;

public class DuckEat implements MakeEating {

    public void makeEating() {
        System.out.println("Duck eats");
    }

    public void doAction() { makeEating(); }
}
