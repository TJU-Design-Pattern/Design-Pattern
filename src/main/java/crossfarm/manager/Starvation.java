package crossfarm.manager;

public class Starvation {
    public int _deficiency_food_amount = 0;
    public double _deficiency_money_amount = 0;

    public String toString() {
        if(_deficiency_money_amount == 0){
            return "Lack of food amount " + _deficiency_food_amount + " ";
        } else {
            return "Need $ " + _deficiency_money_amount + " to buy food : " + _deficiency_food_amount + " ";
        }

    }
}
