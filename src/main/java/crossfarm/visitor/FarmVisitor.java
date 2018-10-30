package crossfarm.visitor;

import crossfarm.Farm;
import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.menu.AnimalMenu;
import crossfarm.menu.PlantMenu;

public class FarmVisitor implements BaseVisitor {
    public void visit(PlantMenu plant_menu) {
        int plant_size = plant_menu.size();
        for(int i=0; i<plant_size; i++){
            BaseCultivation plant = plant_menu.getPlant(i);
            System.out.println("the experience of plant is"+plant.experience);
        }
    }

    public void visit(AnimalMenu animal_menu) {
        int animal_size = animal_menu.size();
        for(int i=0; i<animal_size; i++){
            BaseAnimal animal = animal_menu.getAnimal(i);
            System.out.println("the cost of animal is "+animal.experience);
        }
    }
}
