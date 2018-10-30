/**
 * 基本的植物类
 * 动物植物均继承自此
 */
package crossfarm.cultivation.plants;

import crossfarm.cultivation.BaseCultivation;
import crossfarm.state.State;

public abstract class BasePlant extends BaseCultivation {

    public void changeState(State state) {}
    public void getFed(int currentTime) {}
}
