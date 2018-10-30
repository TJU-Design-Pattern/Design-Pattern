package crossfarm.state;

import crossfarm.cultivation.animals.BaseAnimal;

public interface State {
    void getFull(Context context);  // 吃饱了
    void getHungry(Context context);  // 饿了
    void gainExperience(BaseAnimal animal);  //获取经验值
}
