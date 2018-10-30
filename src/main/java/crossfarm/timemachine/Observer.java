package crossfarm.timemachine;

public abstract class Observer {
    protected TimeCounter time_counter;
    public abstract void update();
}
