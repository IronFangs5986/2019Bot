package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

/*
 * All universal variables and robot components are found here
 */
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

  /* Initialize encoders and information */
  public static Encoder rightEncoder;
  public static Encoder leftEncoder;
  public static Encoder strafeEncoder;

  /* Initialize gyroscope */
  public static ADIS16448_IMU gyro;

  /* Initialize robot information */
  public static Double robotWidth;
  public static Double robotLength;
  public static Double robotHeight;
  public static Double minDriveSpeed;

  /*
   * Initialize all components
   */
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

    /* Set up right encoder */
    rightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    rightEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 64); // 4 inch wheel
    rightEncoder.reset();

    /* Set up left encoder */
    leftEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
    leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    leftEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 64); // 4 inch wheel
    leftEncoder.reset();

    /* Set up strafe encoder */
    strafeEncoder = new Encoder(4, 5, true, Encoder.EncodingType.k4X);
    strafeEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    strafeEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 64); // 4 inch wheel
    strafeEncoder.reset();

    /* Define gyroscope class */
    gyro = new ADIS16448_IMU();

    /* Define robot information */
    robotWidth = 24.0; // Unknown. Put 24in temporarily for testing purposes
    robotLength = 0.0; // Unknown
    robotHeight = 0.0; // Unknown
    minDriveSpeed = 0.3; //Unknown. Put 0.3 temporarily for testing purposes
  }
}
