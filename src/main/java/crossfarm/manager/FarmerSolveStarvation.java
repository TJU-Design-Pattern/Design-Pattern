package crossfarm.manager;

import crossfarm.Farm;

public class FarmerSolveStarvation extends SolveStarvation{
    private Farmer _farmer;

    public FarmerSolveStarvation(Farm farm, Farmer farmer){
        super("[ Farmer ]", farm);
        this._farmer = farmer;
    }

    protected boolean resolve(Starvation starvation){
        Farmer farmer = this._farmer;
        return farmer.solveStarvation(this, starvation);
    }
}
