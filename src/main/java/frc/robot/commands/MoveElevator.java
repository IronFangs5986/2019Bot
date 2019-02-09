package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

/*
 * This is the command that moves the elevator up and down
 */
public class MoveElevator extends Command {

    /* Boolean that holds wether the elevator moves up or down */
    boolean moveUp;

    /*
     * Require the `up` parameter to know wether to move the elevator up or down, and requires the Elevator subsystem
     */
    public MoveElevator(boolean up) {
        moveUp = up;
		requires(Robot.elevator);
    }

    /*
     * Executes the command
     */
    protected void execute() {

        /*
         * Checks if the elevator should and can move up or down, and executes the right command
         */
        if (moveUp) {
            if (!RobotMap.topSensor.get()) {
                
            }
        } else {
            if (!RobotMap.bottomSensor.get()) {

            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}