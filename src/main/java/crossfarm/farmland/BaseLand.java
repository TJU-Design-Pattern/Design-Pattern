/**
 * 表示农场所有的养动物、种植的空间
 * 空间需要靠 clone 来复制，实现原型模式？
 */
package crossfarm.farmland;

import crossfarm.cultivation.BaseCultivation;

public abstract class BaseLand {
    // 为领地增加生物
    protected abstract void addCultivation(BaseCultivation cultivation);
    // 通过 clone 来复制对象
    protected abstract BaseLand clone();
}
