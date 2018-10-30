/**
 * 目录，可用于实现迭代器、组合模式
 */
package crossfarm.menu;

import crossfarm.cultivation.BaseCultivation;

import java.util.List;

public abstract class BaseMenu {
    protected List<BaseCultivation> cultivations;
}
