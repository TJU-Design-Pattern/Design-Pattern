package crossfarm.manager;

public class Owner {
    private double money;

    private static Owner instance = new Owner();

    private Owner(){
        this.money = 0;
    }

    /**
     * Get the instance of the owner
     * @return
     */
    public static Owner getInstance() {
        Owner temp = instance;
        if(temp == null){
            synchronized(Owner.class){
                temp = instance;
                if(temp == null){
                    instance = new Owner();
                    temp = instance;
                }
            }
        }
        return temp;
    }
}
