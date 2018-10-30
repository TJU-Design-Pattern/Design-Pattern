package crossfarm.weapon;

public class BigShovel extends Shovel {
    public BigShovel() {
        this.food = new AddMuchFood();
    }
    public void AddFood(int amount) {
        this.food.AddFood(amount);
    }

    public static void main(String args[]) {
        Shovel newShovel = new BigShovel();
        newShovel.AddFood(23);
    }
}
