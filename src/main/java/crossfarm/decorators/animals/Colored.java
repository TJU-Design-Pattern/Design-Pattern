package crossfarm.decorators.animals;
import crossfarm.cultivation.animals.BaseAnimal;

public class Colored {
    private BaseAnimal animal;

    public  Colored(BaseAnimal animal){
        this.animal = animal;
    }

    public double cost(){
//      涂了颜色加30元
        return this.animal.cost() + 30;
    }
    public void tick() {return;}
}