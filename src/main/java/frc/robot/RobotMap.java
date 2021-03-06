package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;
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

  /* Initialize drive Talon variables */
  public static WPI_TalonSRX FrontLeftMotor;
  public static WPI_TalonSRX FrontRightMotor;
  public static WPI_TalonSRX BackLeftMotor;
  public static WPI_TalonSRX BackRightMotor;

  /* Initialize DifferentialDrive */
  public static DifferentialDrive robotDrive;

  /* Initialize SpeedControllerGroups for DifferentialDrive */
  public static SpeedControllerGroup leftGroup;
  public static SpeedControllerGroup rightGroup;

  /* Initialize strafing Talon */
  public static WPI_TalonSRX strafeyBois;

  /* Initialize elevator Talon */
  public static WPI_TalonSRX elevator;

  /* Initialize elevator spin Talon */
  public static WPI_TalonSRX elevatorSpin;

  /* Initialize cargo intake Talon */
  public static WPI_TalonSRX cargoIntake;

  /* Initialize compressor */
  public static Compressor compressor;

  /* Initialize solenoids */
  public static Solenoid strafePiston;
  public static Solenoid hatchHolderPiston;
  public static Solenoid hatchSliderPiston;
  public static Solenoid cargoShooterPiston;
  public static Solenoid cargoIntakePiston;

  /* Initialize encoders and information */
  public static Encoder rightEncoder;
  public static Encoder leftEncoder;
  public static Encoder liftEncoder;
  public static Encoder turnEncoder;

  /* Initialize gyroscope */
  public static ADIS16448_IMU gyro;

  /* Initialize hall effect sensors */
  public static DigitalInput liftResetSensor;

  /* Initialize camera and camera server variables */
  public static UsbCamera driverCamera = null;
  public static MjpegServer driverCameraServer = null;

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
    FrontLeftMotor = new WPI_TalonSRX(1);
    FrontLeftMotor.setSafetyEnabled(false);
    FrontRightMotor = new WPI_TalonSRX(2);
    FrontRightMotor.setSafetyEnabled(false);
    BackLeftMotor = new WPI_TalonSRX(3);
    BackLeftMotor.setSafetyEnabled(false);
    BackRightMotor = new WPI_TalonSRX(4);
    BackRightMotor.setSafetyEnabled(false);

    /* Define SpeedControllerGroups for DifferentialDrive */
    leftGroup = new SpeedControllerGroup(FrontLeftMotor, BackLeftMotor);
    rightGroup = new SpeedControllerGroup(FrontRightMotor, BackRightMotor);

    /* Define robotDrive as a DifferentialDrive for drivetrain */
    robotDrive = new DifferentialDrive(leftGroup, rightGroup);

    /* Define strafing Victor with CAN id */
    strafeyBois = new WPI_TalonSRX(5);
    strafeyBois.setSafetyEnabled(false);

    /* Define elevator Victor with CAN id */
    elevator = new WPI_TalonSRX(6);
    elevator.setSafetyEnabled(false);

    /* Define elevator spin Victor with CAN id */
    elevatorSpin = new WPI_TalonSRX(7);
    elevatorSpin.setSafetyEnabled(false);

    /* Define cargo intake Victor with CAN id */
    cargoIntake = new WPI_TalonSRX(8);
    cargoIntake.setSafetyEnabled(false);

    /* Define compressor */
    compressor = new Compressor(0);

    /* Define solenoids */
    strafePiston = new Solenoid(4);
    hatchHolderPiston = new Solenoid(1);
    hatchSliderPiston = new Solenoid(0);
    cargoShooterPiston = new Solenoid(2);
    //cargoIntakePiston = new Solenoid(4);

    /* Set up right encoder */
    rightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    rightEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 64); // 4 inch wheel
    rightEncoder.setReverseDirection(false);
    rightEncoder.reset();

    /* Set up left encoder */
    leftEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
    leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    leftEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 64); // 4 inch wheel
    leftEncoder.setReverseDirection(false);
    leftEncoder.reset();

    /* Set up elevator lift encoder */
    liftEncoder = new Encoder(4, 5, true, Encoder.EncodingType.k4X);
    liftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    liftEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 64); // 4 inch wheel
    liftEncoder.setReverseDirection(true);
    liftEncoder.reset();

    /* Set up elevator turn encoder */
    turnEncoder = new Encoder(6, 7, true, Encoder.EncodingType.k4X);
    turnEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    rightEncoder.setDistancePerPulse(16.0 / 64); //16 teeth sprocket
    turnEncoder.setReverseDirection(false);
    turnEncoder.reset();

    /* Define gyroscope class */
    gyro = new ADIS16448_IMU();

    /* Define hall effect sensors */
    liftResetSensor = new DigitalInput(8);

    /* Define and start camera server */
    //driverCamera = new UsbCamera("180Camera", 1);
    //driverCamera.setVideoMode(PixelFormat.kMJPEG, 160, 120, 30);
    //driverCameraServer = new MjpegServer("180Server", 1182);
    //driverCameraServer.setSource(driverCamera);
    UsbCamera server = CameraServer.getInstance().startAutomaticCapture(0);
    server.setResolution(160, 120);
    server.setFPS(30);

    /* Define robot information */
    robotWidth = 21.75;
    robotLength = 38.0;
    robotHeight = 0.0; // Unknown
    minDriveSpeed = 0.3; // Unknown. Put 0.3 temporarily for testing purposes
  }
}
