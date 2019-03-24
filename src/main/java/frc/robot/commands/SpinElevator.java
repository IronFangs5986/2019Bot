package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

/*
 * This is the command that handles POV controls to spin elevator
 */
public class SpinElevator extends Command {

    /* Variables set when calling the command */
    int target;
    double startingPosition;
    double targetDistance;
    boolean moveRight;

    /*
     * Require the `position` parameter to know what position to spin the elevator
     * 
     * 1 - Front
     * 2 - Right
     * 3 - Left
     * 
     */
    public SpinElevator(int position) {
        requires(Robot.elevatorTurn);

        /* Set the `target` variable to the value which the command was called with */
        target = position;

        /*
         * Set the current (starting) position of the elevator to determine when to stop
         */
        startingPosition = Robot.elevatorTurn.getCurrentPosition();
        
        /* Set the position of the target */
        targetDistance = getTargetDistance(position);

         /* Determines wether to move right or left */
         if (startingPosition > targetDistance) {
            moveRight = false;
        } else {
            moveRight = true;
        }
    }

    /*
     * Executes the command
     */
    protected void execute() {
            if (moveRight) {
                Robot.elevatorTurn.spin(0.35);
                //System.out.println("Moving right: "+);
            } else {
                Robot.elevatorTurn.spin(-0.35);
            }

    }

    /*
     * Determines if the command is finished or not
     */
    @Override
    protected boolean isFinished() {
        if (moveRight) {
            if (Robot.elevatorTurn.getCurrentPosition() >= targetDistance) {
                return true;
            } else {
                return false;
            }
        } else {
            if (Robot.elevatorTurn.getCurrentPosition() <= targetDistance) {
                return true;
            } else {
                return false;
            }
        }
    }

    /*
     * Sets the elevator to hold once the command is finished
     */
    protected void end() {
        Robot.elevatorTurn.spin(0.0);
    }

    /*
     * Ends the command of autonomous is stopped or interrupted
     */
    protected void interrupted() {
        end();
    }

     /*
     * Returns the position of the target defined in Elevator.java
     */
    protected double getTargetDistance(int target) {
        if (target == 1) {
            return Robot.elevatorTurn.elevatorFront;
        } else if (target == 2) {
            return Robot.elevatorTurn.elevatorRight;
        } else if (target == 3) {
            return Robot.elevatorTurn.elevatorLeft;
        } else {
            return 0.0;
        }
    }

    /*
     * Calculates speed based on distance to target. Demo of this function can be
     * found here: https://www.desmos.com/calculator/mjxmn8nmug
     */
    private double getSpeed(double current, double total) {
        double speed = (-1 / ((-1 - ((total - 1) / 2)) * (-1 - ((total - 1) / 2))));
        speed = speed * (current - ((total - 1) / 2)) * (current - ((total - 1) / 2));
        speed = speed + 1;
        if (speed < RobotMap.minDriveSpeed) {
            speed = RobotMap.minDriveSpeed;
        }
        return speed;
    }

}