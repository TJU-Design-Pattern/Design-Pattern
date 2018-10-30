package crossfarm.decorators.animals;
import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Duck;

public class Colored extends BaseAnimalDecorator{

    public Colored(BaseAnimal animal){
        super(animal);
    }

    public double cost(){
        // 涂了颜色加30元
        return this.animal.cost() + 30;
    }
    public void tick() {return;}

    public void timeChange(int hour) {

    }
    public BaseCultivation clone() {
        return null ;
    }
    public String getName() {
        return animal.getName();
    }
}