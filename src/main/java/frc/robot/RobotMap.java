package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

public class RobotMap {

  /* Initialize drive Talon variables */
  public static WPI_TalonSRX FrontLeftMotor;
  public static WPI_TalonSRX FrontRightMotor;
  public static WPI_TalonSRX BackLeftMotor;
  public static WPI_TalonSRX BackRightMotor;

  /* Initialize RobotDrive */
  public static RobotDrive driveTrainRobotDrive;

  /* Initialize strafing Talon */
  public static WPI_TalonSRX strafeyBois;

  /* Initialize compressor */
  public static Compressor compressor;

  /* Initialize strafe solenoids */
  public static Solenoid strafePiston;

  /* Initialize all components */
  public static void init() {

    /* Define drive Talons with CAN id */
    FrontLeftMotor = new WPI_TalonSRX(1);
    FrontRightMotor = new WPI_TalonSRX(2);
    BackLeftMotor = new WPI_TalonSRX(3);
    BackRightMotor = new WPI_TalonSRX(4);

    /* Define RobotDrive with the drive Talons */
    driveTrainRobotDrive = new RobotDrive(FrontLeftMotor, BackLeftMotor, FrontRightMotor, BackRightMotor);

    /* Define strafing Talon with CAN id */
    strafeyBois = new WPI_TalonSRX(5);

    /* Define compressor */
    compressor = new Compressor(0);

    /* Define strafe solenoid */
    strafePiston = new Solenoid(0);
  }
}
