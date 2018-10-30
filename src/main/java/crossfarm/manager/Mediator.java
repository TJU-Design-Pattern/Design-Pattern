package crossfarm.manager;

import crossfarm.Farm;
import crossfarm.menu.BaseMenu;

public interface Mediator {
    public abstract void createColleagues(Farm farm);
    public abstract void colleagueChanged();
}