/**
 * 存储动物的牧场
 */
package crossfarm.farmland;

import crossfarm.cultivation.BaseCultivation;

public class Ranch extends BaseLand {


    public void addCultivation(BaseCultivation cultivation) {
        throw new RuntimeException("Not implemented");
    }

    public BaseLand clone() {
        return null;
    }
}
