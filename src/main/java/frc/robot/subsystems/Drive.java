package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

/*
 * This is the Drive subsystem where anything related to drive is found
 */
public class Drive extends Subsystem {

    /* Call RobotDrive defined in RobotMap */
    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    WPI_TalonSRX strafeyBois = RobotMap.strafeyBois;

    public Drive() {

    }

    /*
     * Sets ArcadeDrive as default command to execute
     */
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }

    /*
     * Arcade drive is used for teleop (manual driving)
     */
    public void arcadeDrive(double moveAxis, double rotateAxis, double strafe) {
        /* Sets arcadeDrive values */
        robotDrive.arcadeDrive(moveAxis, rotateAxis);
        /* Sets strafing motor speed */
        strafeyBois.set(strafe);
    }

    /*
     * Tank drive is used for autonomous
     */
    public void tankDrive(double leftSpeed, double rightSpeed, double strafe) {
        /* Sets tankDrive values */
        robotDrive.tankDrive(leftSpeed, rightSpeed);
        /* Sets starafing motor speed */
        strafeyBois.set(strafe);
    }

    /*
     * Return distance recorded by left drivetrain encoder
     */
    public double getLeftDistance() {
        return RobotMap.leftEncoder.getDistance();
    }

    /*
     * Return distance recorded by right drivetrain encoder
     */
    public double getRightDistance() {
        return RobotMap.rightEncoder.getDistance();
    }

    /*
     * Return distance recorded by strafe encoder
     */
    public double getStrafeDistance() {
        return RobotMap.strafeEncoder.getDistance();
    }
}