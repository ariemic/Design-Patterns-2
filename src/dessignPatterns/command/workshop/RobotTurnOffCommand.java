package dessignPatterns.command.workshop;

public class RobotTurnOffCommand implements Command{
    private Robot robot;

    public RobotTurnOffCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.turnOff();
    }
}
