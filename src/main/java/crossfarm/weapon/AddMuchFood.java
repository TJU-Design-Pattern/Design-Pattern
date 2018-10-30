package crossfarm.weapon;

import crossfarm.Farm;

// 大铲子可以一次增加5个食物
public class AddMuchFood implements Food {
    public void AddFood(int amount) {
        Farm farm = Farm.getInstance();
        int quantityOfCrop = (int)Math.ceil((double)amount / 10);
        int amountConverted = 0;
        if (farm.warehouse >= quantityOfCrop) {
            farm.warehouse -= quantityOfCrop;
            amountConverted = quantityOfCrop * 10;
        }
        else {
            // 谷仓中作物数量不足，需要购买
            int quantityOfBought = quantityOfCrop - farm.warehouse;  // 需要购买的数量
        }

        while (amountConverted > 0) {
            farm.foodCourt += 5;
            amountConverted -= 5;
            System.out.println("添加食物：5，食槽中食物总量：" + farm.foodCourt);
        }
    }

    public static void main(String args[]) {
        AddMuchFood adf = new AddMuchFood();
        adf.AddFood(12);
    }
}
