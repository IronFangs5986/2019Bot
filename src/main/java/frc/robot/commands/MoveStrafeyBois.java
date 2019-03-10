package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/*
 * This is the command that moves the Strafey Bois up and down
 */
public class MoveStrafeyBois extends Command {

    /* Boolean that holds wether the Strafey Bois move up or down */
    boolean moveUp;

    /*
     * Require the `up` parameter to know wether to move the Strafey Bois up or down, and requires the Drive subsystem
     */
    public MoveStrafeyBois(boolean up) {
        moveUp = up;
		requires(Robot.driveTrain);
    }
    
    /*
     * Executes the command
     */
    protected void execute() {

        /*
         * Checks if the Strafey Bois should move up or down, and executes the right command
         */
        if (moveUp) {
            //Robot.driveTrain.riseStrafeyBois();
        } else {
            //Robot.driveTrain.lowerStrafeyBois();
        }
    }
    
    /*
     * Makes sure the command is only executed once
     */
    @Override
    protected boolean isFinished() {
        return true;
    }

}