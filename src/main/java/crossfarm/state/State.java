package crossfarm.state;

import crossfarm.cultivation.BaseCultivation;

import java.io.Serializable;

public interface State extends Serializable {
    void getFull(Context context);  // 吃饱了
    void getHungry(Context context);  // 饿了
    void gainExperience(BaseCultivation bc);  //获取经验值
}
