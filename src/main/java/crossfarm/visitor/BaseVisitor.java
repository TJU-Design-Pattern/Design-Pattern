package crossfarm.visitor;

import crossfarm.menu.AnimalMenu;
import crossfarm.menu.PlantMenu;

public interface BaseVisitor {
    public void visit(AnimalMenu animal_menu);
    public void visit(PlantMenu plant_menu);
}
