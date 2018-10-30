package crossfarm.timemachine;

import java.util.ArrayList;
import java.util.List;

//import java.util.Observer;

public class TimeCounter {
    public List<Observer> observers = new ArrayList<Observer>();

    public int current_time;

    public TimeCounter(){
        this.current_time = 0;
    }

    public int updateTime(){
        this.current_time += 1;
        return this.current_time;
    }

    public int getCurrentTime(){
        return this.current_time;
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }


}
