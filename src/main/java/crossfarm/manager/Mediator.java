package crossfarm.manager;

import crossfarm.Farm;
import crossfarm.menu.BaseMenu;

import java.io.Serializable;

public interface Mediator extends Serializable {
    public abstract void createColleagues(Farm farm);
    public abstract void colleagueChanged();
}