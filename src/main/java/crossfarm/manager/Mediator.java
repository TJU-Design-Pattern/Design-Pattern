package crossfarm.manager;

import crossfarm.Farm;
import crossfarm.menu.BaseMenu;

public interface Mediator {
    public abstract void createColleagues(BaseMenu animal_menu, Farm farm);
    public abstract void colleagueChanged();
}