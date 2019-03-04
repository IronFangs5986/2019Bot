package frc.robot.autonomous.actions;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/*
 * This command moves the robot straight a certain distance
 */
public class StraightDriveReachTape extends Command {

    /* Initialize and declare variables */
    Double areaSize = 1000.0;

    /*
     * Declares public function that takes direction and distance in feet and inches
     */
    public StraightDriveReachTape() {

        /* Require the Drive subsystem */
        requires(Robot.driveTrain);

    }

    /*
     * Function running periodically as long as isFinished() returns false
     */
    protected void execute() {
        /* Set a tank drive movement forward with speed of 70% */
        Robot.driveTrain.tankDrive(0.7, 0.7);
            
        /* Adjusts robot's horizontal position by strafing */
        if (Robot.trackingCam.getTx() <= -0.2) {
            Robot.driveTrain.strafeyBoisDrive(1);
        } else if (Robot.trackingCam.getTx() >= 0.2) {
            Robot.driveTrain.strafeyBoisDrive(-1);
        } else {
            Robot.driveTrain.strafeyBoisDrive(0);
        }
    }

    /*
     * Determines when to end the command
     */
    @Override
    protected boolean isFinished() {
        /* Returns true if the area found by the camera is greater than or equal to the minumim target area */
        if (Robot.trackingCam.getTa() >= areaSize) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Stops drivetrain when command ends
     */
    protected void end() {
        Robot.driveTrain.stopTank();
        Robot.driveTrain.stopStrafeyBois();
    }

    /*
     * Ends the command of autonomous is stopped or interrupted
     */
    protected void interrupted() {
        end();
    }

}