package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Dashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

/*
 * This is the command that moves the elevator up and down
 */
public class MoveElevator extends Command {

    /* Variables set when calling the command */
    int target;
    double startingPosition;
    double targetDistance;
    boolean moveUp;

    /* Initialize Dashboard */
    Dashboard dashboard = new Dashboard();

    /*
     * Require the `position` parameter to know what position to move the elevator
     * 
     * 1 - Rocket Bottom and Cargo Ship Hatch Panel
     * 2 - Rocket Middle Hatch Panel
     * 3 - Rocket Top Hatch Panel
     * 4 - Rocket Bottom Cargo
     * 5 - Rocket Middle Cargo
     * 6 - Rocket Top Cargo
     * 7 - Cargo Ship Cargo
     * 
     */
    public MoveElevator(int position) {
        /* Require the elevator subsystem */
        requires(Robot.elevator);

        /* Set the `target` variable to the value which the command was called with */
        target = position;

        /*
         * Set the current (starting) position of the elevator to determine when to stop
         */
        startingPosition = Robot.elevator.getCurrentPosition();

        /* Set the position of the target */
        targetDistance = getTargetDistance(position);


        System.out.println("Start: "+startingPosition);
        System.out.println("Target: "+ targetDistance);
        /* Determines wether to move up or down */
        if (startingPosition > targetDistance) {
            moveUp = false;
        } else {
            moveUp = true;
        }

        /* Send elevator height to Dashbaord */
        if (target == 1) {
            dashboard.setElevatorHeight("HATCH BOTTOM");
        } else if (target == 2) {
            dashboard.setElevatorHeight("HATCH MIDDLE");
        } else if (target == 3) {
            dashboard.setElevatorHeight("HATCH TOP");
        } else if (target == 4) {
            dashboard.setElevatorHeight("CARGO BOTTOM");
        } else if (target == 5) {
            dashboard.setElevatorHeight("CARGO MIDDLE");
        } else if (target == 6) {
            dashboard.setElevatorHeight("CARGO TOP");
        } else if (target == 7) {
            dashboard.setElevatorHeight("CARGO SHIP");
        }
    }

    /*
     * Executes the command
     */
    protected void execute() {

        /*
         * Checks if the elevator should and can move up or down, and executes the right
         * command
         */
        if (moveUp) {
            if (Robot.elevator.getCurrentPosition() < Robot.elevator.maximum) {
                //Robot.elevator.moveUp(getSpeed(Robot.elevator.getCurrentPosition(), targetDistance));
            //Robot.elevator.moveUp(.9);
            }
        } else {
            if (Robot.elevator.getCurrentPosition() > Robot.elevator.minimum) {
                Robot.elevator.moveDown();
            }
        }
    }

    /*
     * Determines if the command is finished or not
     */
    @Override
    protected boolean isFinished() {
        if (moveUp) {
            if (Robot.elevator.getCurrentPosition() >= targetDistance) {
                System.out.println("end");
                return true;
            } else {
                return false;
            }
        } else {
            if (Robot.elevator.getCurrentPosition() <= targetDistance) {
                System.out.println("end");
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
        Robot.elevator.hold();
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
            return (Robot.elevator.bottomHatchLow + Robot.elevator.bottomHatchHigh) / 2;
        } else if (target == 2) {
            return (Robot.elevator.middleHatchLow + Robot.elevator.middleHatchHigh) / 2;
        } else if (target == 3) {
            return (Robot.elevator.topHatchLow + Robot.elevator.topHatchHigh) / 2;
        } else if (target == 4) {
            return (Robot.elevator.bottomCargoLow + Robot.elevator.bottomCargoHigh) / 2;
        } else if (target == 5) {
            return (Robot.elevator.middleCargoLow + Robot.elevator.middleCargoHigh) / 2;
        } else if (target == 6) {
            return (Robot.elevator.topCargoLow + Robot.elevator.topCargoHigh) / 2;
        } else if (target == 7) {
            return (Robot.elevator.shipCargoLow + Robot.elevator.shipCargoHigh) / 2;
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
        if (speed < .9) {
            speed = .9;
        }
        return speed;
    }
}