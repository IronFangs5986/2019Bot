package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

/*
 * This command moves the robot sideways until centered with reflective tape
 */
public class MoveUntilCentered extends Command {

    /*
     * Declares public function
     */
    public MoveUntilCentered() {

        /* Require the Drive subsystem */
        requires(Robot.driveTrain);
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
            if (Robot.trackingCam.getTx() > 0) {
                Robot.driveTrain.tankDrive(0.7, 0.7);
            } else {
                Robot.driveTrain.tankDrive(-0.7, -0.7);
            }
        } else {
            Robot.driveTrain.tankDrive(0, 0);
        }
    }

    @Override
    protected boolean isFinished() {
        if (Robot.trackingCam.getTv()) {
            if (Robot.trackingCam.getTx() >= -0.2 && Robot.trackingCam.getTx() <= 0.2) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    /*
     * Stops drivetrain when command ends
     */
    protected void end() {
        Robot.driveTrain.stopTank();
    }

    /*
     * Ends the command of autonomous is stopped or interrupted
     */
    protected void interrupted() {
        end();
    }
}