package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/*
 * All universal variables and robot components are found here
 */
public class RobotMap {

  /* Initialize drive Victor variables */
  public static WPI_VictorSPX FrontLeftMotor;
  public static WPI_VictorSPX FrontRightMotor;
  public static WPI_VictorSPX BackLeftMotor;
  public static WPI_VictorSPX BackRightMotor;

  /* Initialize DifferentialDrive */
  public static DifferentialDrive robotDrive;

  /* Initialize SpeedControllerGroups for DifferentialDrive */
  public static SpeedControllerGroup leftGroup;
  public static SpeedControllerGroup rightGroup;

  /* Initialize strafing Victor */
  public static WPI_VictorSPX strafeyBois;

  /* Initialize elevator Victor*/
  public static WPI_VictorSPX elevator;

  /* Initialize compressor */
  public static Compressor compressor;

  /* Initialize solenoids */
  public static Solenoid strafePiston;
  public static Solenoid hatchHolderPiston;
  public static Solenoid hatchSliderPiston;
  public static Solenoid cargoShooterPiston;

  /* Initialize encoders and information */
  public static Encoder rightEncoder;
  public static Encoder leftEncoder;
  public static Encoder strafeEncoder;

  /* Initialize gyroscope */
  public static ADIS16448_IMU gyro;

  /* Initialize hall effect sensors */
  public static DigitalInput bottomSensor;
  public static DigitalInput middleSensor;
  public static DigitalInput topSensor;

  /* Initialize robot information */
  public static Double robotWidth;
  public static Double robotLength;
  public static Double robotHeight;
  public static Double minDriveSpeed;

  /*
   * Initialize all components
   */
  public static void init() {

    /* Define drive Victors with CAN id */
    FrontLeftMotor = new WPI_VictorSPX(1);
    FrontRightMotor = new WPI_VictorSPX(2);
    BackLeftMotor = new WPI_VictorSPX(3);
    BackRightMotor = new WPI_VictorSPX(4);

    /* Define SpeedControllerGroups for DifferentialDrive */
    leftGroup = new SpeedControllerGroup(FrontLeftMotor, BackLeftMotor);
    rightGroup = new SpeedControllerGroup(FrontRightMotor, BackRightMotor);

    /* Define robotDrive as a DifferentialDrive for drivetrain */
    robotDrive = new DifferentialDrive(leftGroup, rightGroup);

    /* Define strafing Victor with CAN id */
    strafeyBois = new WPI_VictorSPX(5);

    /* Define elevator Victor with CAN id */
    elevator = new WPI_VictorSPX(6);

    /* Define compressor */
    compressor = new Compressor(0);

    /* Define solenoids */
    strafePiston = new Solenoid(0);
    hatchHolderPiston = new Solenoid(1);
    hatchSliderPiston = new Solenoid(2);
    cargoShooterPiston = new Solenoid(3);

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

    /* Define hall effect sensors */
    bottomSensor = new DigitalInput(0);
    middleSensor = new DigitalInput(1);
    topSensor = new DigitalInput(2);

    /* Define robot information */
    robotWidth = 24.0; // Unknown. Put 24in temporarily for testing purposes
    robotLength = 0.0; // Unknown
    robotHeight = 0.0; // Unknown
    minDriveSpeed = 0.3; // Unknown. Put 0.3 temporarily for testing purposes
  }
}
