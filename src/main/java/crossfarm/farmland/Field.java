/**
 *
 */
package crossfarm.farmland;

import crossfarm.cultivation.BaseCultivation;

public class Field extends BaseLand{
    public void addCultivation(BaseCultivation cultivation) {
        throw new RuntimeException("Not implemented");
    }

    public BaseLand clone() {
        return null;
    }
}
