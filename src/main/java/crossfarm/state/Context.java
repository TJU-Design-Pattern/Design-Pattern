package crossfarm.state;

public interface Context {
    // 时间流逝
    void timeChange(int currentTime);
    // 状态变化
    void changeState(State state);
    // 喂食
    void getFed(int currentTime);
}
