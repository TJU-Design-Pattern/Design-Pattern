package crossfarm.manager;

public abstract class SolveStarvation {
    private SolveStarvation next;
    private String name;

    public SolveStarvation(String name){
        this.name = name;
    }

    public SolveStarvation setNext(SolveStarvation next){
        this.next = next;
        return next;
    }

    public final void solve(Starvation starvation){
        if(resolve(starvation)){
            done(starvation);
        } else if (next != null){
            next.solve(starvation);
        } else {
            fail(starvation);
        }
    }

    protected abstract boolean resolve(Starvation starvation);

    protected void done(Starvation starvation){
        System.out.println(starvation + "is solved by " + this);
    }

    protected void fail(Starvation starvation){
        System.out.println(starvation + "cannot be solved!");
    }

}
