package crossfarm.actions;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.animals.Duck;
import crossfarm.actions.MakeSound;
/**
 * Created by nickel on 2018/10/29.
 */
public class ChangeSoundAdapter extends MakeSound{
    private String sound;
    public ChangeSoundAdapter(BaseAnimal animal){
        if(animal instanceof Cat){
            sound = "喵喵喵\n";
        } else if (animal instanceof Duck){
            sound = "鸭鸭鸭\n";
        }
    }
    public void makeSound(){
        System.out.println(sound);
    }

}
