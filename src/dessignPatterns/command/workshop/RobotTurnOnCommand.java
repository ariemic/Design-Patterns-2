package dessignPatterns.command.workshop;

public class RobotTurnOnCommand implements Command {
    private Robot robot;

    public RobotTurnOnCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.turnOn();
    }

}
