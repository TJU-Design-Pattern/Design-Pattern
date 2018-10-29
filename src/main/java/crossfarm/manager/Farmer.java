/**
 * 系统的管理者，单例的用户
 * 表示正在使用的用户
 */
package crossfarm.manager;

public class Farmer {
    //private double money;
    private boolean has_axe;
    private boolean has_shovel;

    // init our only owner
    //private static Farmer instance = new Farmer();

    public Farmer() {
        //
        //this.money = 0;
        this.has_axe = false;
        this.has_shovel = false;
    }

    public void setHas_axe(boolean has_axe) {
        this.has_axe = has_axe;
    }

    public void setHas_shovel(boolean has_shovel){
        this.has_shovel = has_shovel;
    }
}
