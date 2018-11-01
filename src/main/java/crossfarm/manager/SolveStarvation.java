package crossfarm.manager;

import crossfarm.Farm;

public abstract class SolveStarvation {
    private SolveStarvation _next;
    private String _name;
    protected Farm _farm;

    public SolveStarvation(String name, Farm farm){
        this._name = name;
        this._farm = farm;
    }

    public SolveStarvation setNext(SolveStarvation next){
        this._next = next;
        return next;
    }

    public final void solve(Starvation starvation){
        if(resolve(starvation)){
            done(starvation);
        } else if (_next != null){
            _next.solve(starvation);
        } else {
            fail(starvation);
        }
    }

    protected abstract boolean resolve(Starvation starvation);

    public String toString() {
        return this._name;
    }

    protected void done(Starvation starvation){
        System.out.println(starvation + "is solved by " + this);
        _farm.getAnimal_manager().get_starved_animals().clear();
    }

    protected void fail(Starvation starvation){
        System.out.println(starvation + "cannot be solved!");
    }

}
