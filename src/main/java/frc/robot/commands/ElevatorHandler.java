package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

/*
 * This is the command that handles POV controls to move elevator
 */
public class ElevatorHandler extends Command {

    /* Set stop reset to false */
    Boolean stopReset = false;

    public ElevatorHandler() {
    }

    /*
     * Executes the command
     */
    protected void execute() {
        /* Enables the ability to be reset once it leaves the bottom  zone */
        if (Robot.elevator.getCurrentPosition() > Robot.elevator.minimum && stopReset) {
            stopReset = false;
        }

        /* Resets elevator lift encoder */
        if (RobotMap.liftResetSensor.get() && stopReset == false) {
            Robot.elevator.reset();
            stopReset = true;
        }
    }

    /*
     * Makes command run forever
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

}