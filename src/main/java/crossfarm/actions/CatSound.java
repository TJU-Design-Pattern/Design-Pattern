/**
 * Copyright (c) 2018.10.29 ZWZ
 * 猫发出声音行为的实现，模拟策略模式
 */
package crossfarm.actions;

public class CatSound  implements MakeSound{

    public void makeSound() {
        System.out.println("喵喵喵");
    }

    public void doAction() { makeSound(); }
}
