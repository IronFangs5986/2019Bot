package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
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
    WPI_TalonSRX strafeyBois = RobotMap.strafeyBois;

    public Drive() {}

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
        /* Set Dead Zones */
        if (Math.abs(rotateAxis) <= .2) {
            rotateAxis = 0;
        }
        
        if (Math.abs(rotateAxis) >= .95) {
            if (rotateAxis > 0) {
                rotateAxis = .95;
            } else {
                rotateAxis = -.95;
            }
        }

        /* Sets arcadeDrive values */
        robotDrive.arcadeDrive(moveAxis, rotateAxis);

        /*
         * Automatically drop Strafey Bois when they move
         */
        //strafeyBois.set(-strafe);
        //if (Math.abs(strafe) >= .4) {
            //lowerStrafeyBois();

            /* Sets strafing motor speed */
        //strafeyBois.set(-strafe);
        //} else {
          //  riseStrafeyBois();

            /* Sets strafing motor speed */
        //strafeyBois.set(0);
        //}
    }

    /*
     * Arcade drive is used for teleop (manual driving) straight driving
     */
    public void curvatureDrive(double moveAxis, double rotateAxis, double strafe, boolean turn) {
        /* Sets curvatureDrive values */
        robotDrive.curvatureDrive(moveAxis, rotateAxis, turn);
        /* Sets strafing motor speed */
       // strafeyBois.set(strafe);
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
        strafeyBois.set(-speed);
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
        //strafeyBois.set(0);
    }

    /*
     * Rise Strafey Bois mechanism
     */
    public void riseStrafeyBois() {
        //RobotMap.strafePiston.set(false);
        //RobotMap.hatchHolderPiston.set(false);
    }

    /*
     * Lower Strafey Bois mechanism
     */
    public void lowerStrafeyBois() {
        //RobotMap.strafePiston.set(true);
        //RobotMap.hatchHolderPiston.set(true);
    }

    /*
     * Tests subsystem to make sure all components in drivetrain work
     */
    public void checkSystem() {
        WPI_TalonSRX frontRight = RobotMap.FrontRightMotor;
        WPI_TalonSRX frontLeft = RobotMap.FrontLeftMotor;
        WPI_TalonSRX backRight = RobotMap.BackRightMotor;
        WPI_TalonSRX backLeft = RobotMap.BackLeftMotor;
        WPI_TalonSRX strafeyBois = RobotMap.strafeyBois;

        frontRight.set(0);
        frontLeft.set(0);
        backRight.set(0);
        backLeft.set(0);
        strafeyBois.set(0);
        
        frontRight.set(.6);
        frontLeft.set(.6);
        backRight.set(.6);
        backLeft.set(.6);

        Timer.delay(2.0);
        
        frontRight.set(-.6);
        frontLeft.set(-.6);
        backRight.set(-.6);
        backLeft.set(-.6);

        Timer.delay(2.0);

        frontRight.set(0);
        frontLeft.set(0);
        backRight.set(0);
        backLeft.set(0);
        strafeyBois.set(.6);

        Timer.delay(2.0);

        strafeyBois.set(-.6);

        Timer.delay(2.0);

        strafeyBois.set(0);

    }
}