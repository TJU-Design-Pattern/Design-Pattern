/**
 * 表示农场所有的养动物、种植的空间
 * 空间需要靠 clone 来复制，实现原型模式？
 */
package crossfarm.farmland;

public abstract class BaseLand {
    // 通过 clone 来复制对象
    protected abstract BaseLand clone();
}
