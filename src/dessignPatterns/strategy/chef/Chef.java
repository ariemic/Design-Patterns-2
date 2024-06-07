package dessignPatterns.strategy.chef;

import dessignPatterns.strategy.chef.egg.cooker.EggCooker;

public class Chef {
    private String name;
    private EggCooker eggCooker;

    public Chef(String name) {
        this.name = name;
    }

    public void cook(){
        this.eggCooker.cookEgg();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEggCooker(EggCooker eggCooker) {
        this.eggCooker = eggCooker;
    }
}
