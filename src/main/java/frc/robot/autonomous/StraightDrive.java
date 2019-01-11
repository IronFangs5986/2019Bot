package frc.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
/*
 * TO DO:
 * - NEEDS TO BE COMMENTED
 * - Get getSpeed function correct
 */
public class StraightDrive extends Command {

    boolean forwardMovement;
    double driveDistance;
    double startDistanceL;
    double startDistanceR;
    double endDistanceL;
    double endDistanceR;

    public StraightDrive(boolean forward, double userFeet, double userInches) {
		requires(Robot.driveTrain);
		forwardMovement = forward;
		driveDistance = (userFeet + (userInches / 12));
    }

    protected void initialize() {
        if (forwardMovement) {
            endDistanceL = Robot.driveTrain.getLeftDistance() + driveDistance;
            endDistanceR = Robot.driveTrain.getRightDistance() + driveDistance;
		} else {
            endDistanceL = Robot.driveTrain.getLeftDistance() - driveDistance;
			endDistanceR = Robot.driveTrain.getRightDistance() - driveDistance;
        }
        startDistanceR = Robot.driveTrain.getRightDistance();
        startDistanceL = Robot.driveTrain.getLeftDistance();
		System.out.println("Drive Distance: " + driveDistance);
		System.out.println("Starting Distance: " + Robot.driveTrain.getRightDistance());
        System.out.println("Left End Distance: " + endDistanceL);
        System.out.println("Right End Distance: " + endDistanceR);
    }
    
    protected void execute() {
        double currentL = Robot.driveTrain.getLeftDistance() - startDistanceL;
        double currentR = Robot.driveTrain.getRightDistance() - startDistanceR;
        double averageDistance = (currentL+currentR)/2;
		System.out.println("Distance: " + Robot.driveTrain.getRightDistance());
		Robot.driveTrain.tankDrive(getSpeed(averageDistance, driveDistance), getSpeed(averageDistance, driveDistance), 0);
    }
    
    @Override
    protected boolean isFinished() {
        if (forwardMovement) {
			return (Robot.driveTrain.getRightDistance() >= endDistanceR || Robot.driveTrain.getLeftDistance() >= endDistanceL);
		} else {
			return (Robot.driveTrain.getRightDistance() <= endDistanceR || Robot.driveTrain.getLeftDistance() <= endDistanceL);
		}
    }

    protected void end() {
		Robot.driveTrain.stopTank();
	}

	protected void interrupted() {
		end();
    }
    
    private double getSpeed(double current, double total) {
		double speed = (-1 / ((-1 - ((total - 1) / 2)) * (-1 - ((total - 1) / 2))));
		speed = speed * (current - ((total - 1) / 2)) * (current - ((total - 1) / 2));
		speed = speed + 1;
		// System.out.println("***Speed: " + speed);
		return speed * -2;
	}
}