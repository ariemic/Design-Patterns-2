package dessignPatterns.strategy.chef.egg.cooker;

public class SoftBoiledEggCooker implements EggCooker {
    @Override
    public void cookEgg() {
        System.out.println("I'm cooking soft boiled eggs");
    }
}
