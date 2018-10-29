package crossfarm.cultivation.animals;

import crossfarm.actions.AnimalAction;
import crossfarm.actions.MakeSound;
import crossfarm.cultivation.BaseCultivation;

public abstract class BaseAnimal extends BaseCultivation {
    MakeSound soundMaker;

    public void makeSound() {
        soundMaker.makeSound();
    }

    public static void behave(AnimalAction action) { action.doAction(); }
}
