package frc.robot.autonomous.actions;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

/*
 * This command moves the robot sideways until centered with reflective tape
 */
public class SideDriveWithCamera extends Command {

    /* Initialize variables */
    boolean rightMovement;
    double startDegrees;

    /*
     * Declares public function that takes direction and distance in feet and inches
     */
    public SideDriveWithCamera(boolean right) {

        /* Require the Drive subsystem */
        requires(Robot.driveTrain);

        /* Sets wether the movement is right or left */
        rightMovement = right;

        /* Sets the initial angle of the gyroscope */
        startDegrees = RobotMap.gyro.getAngleY();
    }
    
    /*
     * Function running periodically as long as isFinished() returns false
     */
    protected void execute() {

        /*
         * Checks if camera found target and follows the target
         */
        if (Robot.trackingCam.getTv()) {
            /* Target found */
            if (rightMovement) {
                Robot.driveTrain.strafeyBoisDrive(0.7);
            } else {
                Robot.driveTrain.strafeyBoisDrive(-0.7);
            }
        } else {
            /* No target found */
            if (rightMovement) {
                Robot.driveTrain.strafeyBoisDrive(1.0);
            } else {
                Robot.driveTrain.strafeyBoisDrive(-1.0);
            }
        }

        /*
         * Adjusts the robot if it turns too much while strafing
         */
        if (RobotMap.gyro.getAngleY() >= startDegrees + 5) {
            Robot.driveTrain.tankDrive(-0.2, 0.2);
        } else if (RobotMap.gyro.getAngleY() <= startDegrees - 5) {
            Robot.driveTrain.tankDrive(0.2, -0.2);
        } else {
            Robot.driveTrain.tankDrive(0.0, 0.0);
        }
    }

    @Override
    protected boolean isFinished() {
        if (Robot.trackingCam.getTv() && Robot.trackingCam.getTx() >= -0.2 && Robot.trackingCam.getTx() <= 0.2) {
            return true;
        } else {
            return false;
        }
    }
}