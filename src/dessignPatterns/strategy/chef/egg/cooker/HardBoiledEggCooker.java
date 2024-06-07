package dessignPatterns.strategy.chef.egg.cooker;

public class HardBoiledEggCooker implements EggCooker{
    @Override
    public void cookEgg() {
        System.out.println("I'm cooking hard boiled eggs");
    }
}
