package crossfarm.manager;

import java.text.DecimalFormat;

public class Starvation {
    public int _deficiency_food_amount = 0;
    public double _deficiency_money_amount = 0;

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0 ");
        if(_deficiency_money_amount == 0){
            return "Lack of food amount " + _deficiency_food_amount + " ";
        } else {
            return "Need $ " + df.format(_deficiency_money_amount) + " to buy food, and the total consumption is :" + _deficiency_food_amount + " ";
        }

    }
}
