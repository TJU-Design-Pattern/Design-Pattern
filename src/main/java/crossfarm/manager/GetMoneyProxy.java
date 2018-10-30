package crossfarm.manager;

public class GetMoneyProxy implements MoneyGetter {
    private MoneyGetter getter;

    public GetMoneyProxy() {
        getter = Owner.getInstance();
    }

    public GetMoneyProxy(MoneyGetter getter) {
        this.getter = getter;
    }

    public double getMoney() {
        preGetMoney();
        double to_return = this.getter.getMoney();
        postGetMoney();
        return to_return;
    }

    protected void preGetMoney() {
        System.out.println("Pre of get money static proxy");
    }
    protected void postGetMoney() {
        System.out.println("Post of get money static proxy");
    }
}
