/**
 * 基本的植物类
 * 动物植物均继承自此
 */
package crossfarm.cultivation.plants;

import crossfarm.Farm;
import crossfarm.cultivation.BaseCultivation;
import crossfarm.state.State;

public abstract class BasePlant extends BaseCultivation {

    public void doSell(){
        if(this.isSaled){
            System.out.println("This plant is already saled!");
        }
        else{
            this.isSaled = true;
            Farm instance = Farm.getInstance();
            instance.plantMenu.removePlant(this);
            System.out.println("Sale finished!");
        }
    }
    public void changeState(State state) {}
    public void getFed(int currentTime) {}
}
