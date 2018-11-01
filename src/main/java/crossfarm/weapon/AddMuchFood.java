package crossfarm.weapon;

import crossfarm.Farm;

import java.io.Serializable;

// 大铲子可以一次增加5个食物
public class AddMuchFood implements Food, Serializable {
    public void AddFood(int amount) {
        Farm farm = Farm.getInstance();

        while (amount > 0) {
            int per = amount >= 5 ? 5 : amount;
            farm.foodCourt += per;
            amount -= per;
            farm.warehouse -= per;
            System.out.println("添加食物：5，食槽中食物总量：" + farm.foodCourt);
        }
    }

    public static void main(String args[]) {
        AddMuchFood adf = new AddMuchFood();
        adf.AddFood(12);
    }
}
