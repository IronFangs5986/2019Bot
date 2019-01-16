package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

/*
 * This is the Drive subsystem where anything related to drive is found
 */
public class Drive extends Subsystem {

    /* Call DifferentialDrive defined in RobotMap */
    DifferentialDrive robotDrive = RobotMap.robotDrive;
    WPI_VictorSPX strafeyBois = RobotMap.strafeyBois;

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
     * Arcade drive is used for teleop (manual driving) straight driving
     */
    public void curvatureDrive(double moveAxis, double rotateAxis, double strafe, boolean turn) {
        /* Sets curvatureDrive values */
        robotDrive.curvatureDrive(moveAxis, rotateAxis, turn);
        /* Sets strafing motor speed */
        strafeyBois.set(strafe);
    }

    /*
     * Tank drive is used for autonomous
     */
    public void tankDrive(double leftSpeed, double rightSpeed) {
        /* Sets tankDrive values */
        robotDrive.tankDrive(leftSpeed, rightSpeed);
    }

    /*
     * Strafeybois drive is used to move sideways
     */
    public void strafeyBoisDrive(double speed) {
        /* Sets strafing motor speed */
        strafeyBois.set(speed);
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

    /*
     * Stops tank drivetrain by setting speeds to 0
     */
    public void stopTank() {
        robotDrive.arcadeDrive(0.0, 0.0);
        robotDrive.tankDrive(0.0, 0.0);
    }

    /*
     * Stops strafe drivetrain by setting speeds to 0
     */
    public void stopStrafeyBois() {
        strafeyBois.set(0);
    }
}