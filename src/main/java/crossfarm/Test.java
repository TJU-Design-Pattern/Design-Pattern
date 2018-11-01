package crossfarm;

import crossfarm.actions.CatSound;
import crossfarm.actions.DuckSound;
import crossfarm.cultivation.BaseCultivation;
import crossfarm.cultivation.CultivationModule;
import crossfarm.cultivation.animals.BaseAnimal;
import crossfarm.cultivation.animals.Cat;
import crossfarm.cultivation.plants.BasePlant;
import crossfarm.factories.BaseFactory;
import crossfarm.farmland.BaseLand;
import crossfarm.menu.AnimalMenu;
import crossfarm.menu.PlantMenu;
import crossfarm.timemachine.AnimalObserver;
import crossfarm.timemachine.PlantObserver;
import crossfarm.timemachine.TimeCounter;
import crossfarm.tools.ToolPackage;
import crossfarm.visitor.BaseVisitor;
import crossfarm.visitor.FarmVisitor;
import crossfarm.weapon.BaseWeapon;

import static crossfarm.cultivation.CultivationModule.initializePrototype;

public class Test {

    public static void main(String[] args) {

        // 初始化
        Farm farm = Farm.getInstance();
        Memento memento = farm.createMemento();

        // 测试原型模式
        System.out.println("");
        System.out.println("现在开始测试原型模式：");
        initializePrototype();  // 初始化原型系统
        Cat cat = (Cat) CultivationModule.findAndClone("Cat");  // 利用原型克隆一只猫
        System.out.println("我是一只" + cat.getName());  // 测试是否正确克隆猫
        BaseAnimal animal = (BaseAnimal) CultivationModule.findAndClone("Dog");  // 利用原型克隆一只狗（应提示错误信息）
        BasePlant plant = (BasePlant) CultivationModule.findAndClone("Crop");  // 利用原型克隆一个作物（使用父类类型）
        System.out.println("我是一个" + plant.getName());
        BaseCultivation culti = CultivationModule.findAndClone("Duck");  // 利用原型克隆一只鸭子（使用父类类型）
        System.out.println("我是一只" + culti.getName());

        // 测试策略模式
        System.out.println("");
        System.out.println("现在开始测试策略模式:");
        System.out.println("我是一只" + cat.getName());
        cat.behave(new CatSound());  // 测试猫叫
        cat.behave(new DuckSound());  // 测试猫学鸭子叫
        ((BaseAnimal) culti).behave(new DuckSound());

        // 测试适配器模式
        System.out.println("");
        System.out.println("现在开始测试适配器模式:");
        System.out.println("我是一只"+ cat.getName());
        System.out.println("我原来发出的声音是:");
        cat.behave(new CatSound());  // 测试猫叫
        System.out.println("我经过适配后发出的声音是:");
        cat.changeAdapter("哇卡卡卡卡");
        cat.soundAdapter.makeSound();

        // 测试观察者模式
        System.out.println("");
        System.out.println("现在开始测试观察者模式");

        PlantMenu plant_menu = Farm.getInstance().plantMenu;
        AnimalMenu animal_menu = Farm.getInstance().animalMenu;

        TimeCounter time_counter = new TimeCounter();
        AnimalObserver animal_observer = new AnimalObserver(time_counter);
        PlantObserver plant_observer = new PlantObserver(time_counter);

        int time_remain = 150;

        while(time_remain>=0){
            time_counter.updateTime();
            time_remain -= 1;
        }
        System.out.println("");

        // 测试访问者模式
        System.out.println("");
        System.out.println("现在开始测试访问者模式");

        BaseVisitor farm_visitor = new FarmVisitor();

        animal_menu.accept(farm_visitor);
        plant_menu.accept(farm_visitor);

        System.out.println("");

        // 测试组合模式和建造者模式
        System.out.println("");
        System.out.println("现在开始测试组合模式和建造者模式");
        ToolPackage tool_package = new ToolPackage();

        BaseFactory weapon_factory = Farm.getInstance().weapon_factory;
        BaseWeapon big_shovel = weapon_factory.getWeapon("BigShovel");
        tool_package.addTool(big_shovel);

        ToolPackage second_tool_package = new ToolPackage();
        tool_package.addPackage(second_tool_package);
        System.out.println("");

        // 测试抽象工厂模式和享元模式
        System.out.println("");
        System.out.println("现在开始测试抽象工厂模式和享元模式");
        BaseFactory cultivation_factory = Farm.getInstance().cultivation_factory;
        BaseLand ranch = cultivation_factory.getLand("Ranch");
        BaseLand field = cultivation_factory.getLand("Field");

        BaseWeapon axe = weapon_factory.getWeapon("Axe");
        BaseWeapon big_shovel_1 = weapon_factory.getWeapon("BigShovel");
        BaseWeapon small_shovel = weapon_factory.getWeapon("SmallShovel");

    }
}
