package crossfarm.manager;

public class Owner {
    private double money;

    private static Owner instance = new Owner();

    private Owner(){
        this.money = 0;
    }

    public static Owner getInstance(){
        return instance;
    }

    /**
     * Get the instance of the owner
     * @return
     */
    public static Owner getInstance() {

    }
}
