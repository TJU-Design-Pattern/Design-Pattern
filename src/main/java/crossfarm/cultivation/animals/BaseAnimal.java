package crossfarm.cultivation.animals;

import crossfarm.actions.sound.MakeSound;
import crossfarm.cultivation.BaseCultivation;

public abstract class BaseAnimal extends BaseCultivation {
    MakeSound soundMaker;

    public void makeSound() {
        soundMaker.makeSound();
    }
}
