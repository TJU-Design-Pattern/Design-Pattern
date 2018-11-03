/**
 * Copyright (c) 2018.10.29 STY
 * Adapter
 */
package crossfarm.actions;

import java.io.Serializable;

public class ChangeSoundAdapter extends DuckSound implements MakeSound, Serializable {
    private String sound;
    public ChangeSoundAdapter(String sound){
        this.sound = sound;
    }
    public void makeSound(){
        System.out.println(sound);
    }

}
