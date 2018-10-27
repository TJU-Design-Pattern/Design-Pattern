/**
 * 时间控制机器，管理系统的时间
 * 跟时间有关的对象必须在其对象列表中订阅时间事件
 */
package crossfarm.manager;

import crossfarm.cultivation.BaseCultivation;

import java.util.ArrayList;

public class Timer {
    private ArrayList<BaseCultivation> cultivations;

    public void addCultivation() {
        throw new RuntimeException("Not Implemented");
    }

    public void deleteCultivation() {
        throw new RuntimeException("Not Implemented");
    }

    // 时间经过
    public void tick() {

    }

    private Timer() {
        throw new RuntimeException("Not implemented.");
    }
}
