/**
 * Copyright (c) 2018.10.29 ZWZ
 * 鸭子发出声音行为的实现，模拟策略模式
 */
package crossfarm.actions;

public class DuckSound {
    private String string;

    public DuckSound (String string) {
        this.string = string;
    }

    public void makeDuckSound() {

    }

    public void makeSound() {
        System.out.println("摸了");
    }

    public void doAction() { makeSound(); }
}
