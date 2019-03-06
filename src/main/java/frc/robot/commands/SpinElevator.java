package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

/*
 * This is the command that handles POV controls to spin elevator
 */
public class SpinElevator extends Command {

    public SpinElevator() {
        requires(Robot.elevator);
    }

    /*
     * Executes the command
     */
    protected void execute() {
            if (OI.driver.getPOV() == 90) {
                /* POV is right, and turns elevator right */
                Robot.elevator.spin(-.7);
            } else if (OI.driver.getPOV() == 270) {
                /* POV is left, and turns elevator left */
                Robot.elevator.spin(.7);
            } else {
                /* POV is neither right or left, and stops the elevator spinning */
                Robot.elevator.spin(0.0);
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