/**
 * 基本的生物类
 * 描述生物的基本功能
 * 植物动物均继承自这个类
 */
package crossfarm.cultivation;

public abstract class BaseCultivation {
    /**
     * 这个玩意能卖多少钱
     * @return
     */
    public abstract double cost();

    // 时间经过的反应(用 STATE MACHINE 描述时间经过动物会发生啥？
    public abstract void tick();
}
