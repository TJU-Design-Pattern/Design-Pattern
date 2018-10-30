package crossfarm.weapon;

public class SmallShovel extends Shovel {
    public SmallShovel() {
        this.food = new AddLittleFood();
    }
    public void AddFood(int amount) {
        this.food.AddFood(amount);
    }
}
