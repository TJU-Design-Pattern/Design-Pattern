package crossfarm.weapon;

import crossfarm.Farm;

import java.io.Serializable;

// 小铲子一次增加2食物
public class AddLittleFood implements Food, Serializable {
    public void AddFood(int amount) {
        Farm farm = Farm.getInstance();
        while (amount > 0) {
            int per = amount >= 2 ? 2 : amount;
            farm.foodCourt += per;
            amount -= per;
            farm.warehouse -= per;
            System.out.println("添加食物：2，食槽中食物总量：" + farm.foodCourt);
        }
    }

    public static void main(String args[]) {
        AddLittleFood adf = new AddLittleFood();
        adf.AddFood(12);
    }
}
