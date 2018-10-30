/**
 * 目录，可用于实现迭代器、组合模式
 */
package crossfarm.menu;

import crossfarm.cultivation.BaseCultivation;

import java.io.Serializable;
import java.util.List;

public abstract class BaseMenu implements Serializable {
    public List<BaseCultivation> cultivations;
}
