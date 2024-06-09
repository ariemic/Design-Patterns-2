package dessignPatterns.command;

import dessignPatterns.command.workshop.*;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        WorkShopApp workShopApp = new WorkShopApp();
        workShopApp.addToQueue(new RobotTurnOnCommand(robot));
        workShopApp.addToQueue(new RobotCutCommand(robot));
        workShopApp.addToQueue(new RobotDrillCommand(robot));
        workShopApp.addToQueue(new RobotTurnOffCommand(robot));

        workShopApp.run();

        CoffeeMaker coffeeMaker = new CoffeeMaker();
        workShopApp.addToQueue(new CoffeeMakerTurnOnCommand(coffeeMaker));
        workShopApp.addToQueue( new CoffeeMakerTurnOffCommand(coffeeMaker));

        workShopApp.run();

    }


}
