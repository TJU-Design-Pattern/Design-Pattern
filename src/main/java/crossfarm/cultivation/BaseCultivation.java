/**
 * 基本的生物类
 * 描述生物的基本功能
 * 植物动物均继承自这个类
 */
package crossfarm.cultivation;

import crossfarm.state.Context;
import crossfarm.state.HungryState;
import crossfarm.state.State;

public abstract class BaseCultivation implements Context {
    /**
     * 这个玩意能卖多少钱
     * @return
     */
    public boolean isSaled;
    public int experience = 0;
    public double value = 0;
    public State state = HungryState.getInstance();
    public boolean isMature;

    public abstract double cost();
    public abstract void doSell();

    // 时间经过的反应(用 STATE MACHINE 描述时间经过动物会发生啥？
    public abstract void tick();
}
