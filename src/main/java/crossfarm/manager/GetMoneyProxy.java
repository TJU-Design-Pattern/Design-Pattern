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
        return this.getter.getMoney();
    }
}
