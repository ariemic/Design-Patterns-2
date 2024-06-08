package dessignPatterns.strategy;

import dessignPatterns.strategy.chef.Chef;
import dessignPatterns.strategy.chef.egg.cooker.HardBoiledEggCooker;
import dessignPatterns.strategy.chef.egg.cooker.SoftBoiledEggCooker;

public class Main {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsey");

        chef.setEggCooker(new HardBoiledEggCooker());
        chef.cook();

        chef.setEggCooker(new SoftBoiledEggCooker());
        chef.cook();

    }
}
