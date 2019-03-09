package frc.robot;

import frc.robot.autonomous.paths.LeftDoubleHatch;
import frc.robot.autonomous.paths.RightDoubleHatch;
import frc.robot.autonomous.paths.Straight;
import frc.robot.subsystems.CargoIntake;
import frc.robot.subsystems.CargoShooter;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.HatchHolder;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/*
 * This is the "main" class 
 */
public class Robot extends TimedRobot {

  /* Initialize autonomousCommand to store chosen command */
  Command autonomousCommand;

  /* Initialize OI and Subsystems */
  public static OI oi;
  public static Drive driveTrain;
  public static HatchHolder hatchHolder;
  public static CargoShooter cargoShooter;
  public static Elevator elevator;
  public static CargoIntake cargoIntake;

  /* Initialize the tracking camera */
  public static Tracking trackingCam;

  /* Define default autonomous mode id */
  private int mode = 0;

  /* Initialize and define autonomous modes list */
  String[] autoList = { "Manual Drive", "Move Straight", "Left Rocket", "Right Rocket" };

  /* Initialize Dashboard */
  Dashboard dashboard = new Dashboard();

  /*
   * This function is executed only once when the robot boots up
   */
  @Override
  public void robotInit() {
    /* Initialize RobotMap */
    RobotMap.init();

    /* Define OI and Subsystems */
    driveTrain = new Drive();
    hatchHolder = new HatchHolder();
    cargoShooter = new CargoShooter();
    elevator = new Elevator();
    cargoIntake = new CargoIntake();
    oi = new OI();

    /* Define the tracking camera and start stream 1 */
    trackingCam = new Tracking();
    trackingCam.startCameraStream1();
    
    /* Push autonomous list to Dashboard */
    dashboard.setAutonomousList(autoList);

    /* Select default autonomous mode */
    dashboard.setAutonomous(0);
  }

  /*
   * This function is executed periodically in any mode (disabled, teleop,
   * autonomous, etc.)
   */
  @Override
  public void robotPeriodic() {
    /* Send gyroscope data to Dashboard */
    dashboard.setGyroscope(RobotMap.gyro.getAngleX(), RobotMap.gyro.getAngleY(), RobotMap.gyro.getAngleZ());

    /* Send battery voltage to Dashboard */
    dashboard.setBattery(RobotController.getBatteryVoltage());

    /* Send compressor state to Dashboard */
    dashboard.setCompressorState(RobotMap.compressor.enabled());

    /* Send camera tracking status to Dashboard */
    //dashboard.setCameraTrackingStatus(trackingCam.getValidConn());

    /* Send -99999 to Dashboard if there is no target, and target distance if there is one */
    if (trackingCam.getTv()) {
      dashboard.setVision(trackingCam.getTx());
    } else {
      dashboard.setVision(-99999.0);
    }

    /* Send remaining time */
    dashboard.setTime(DriverStation.getInstance().getMatchTime());

    /* Print to console for debugging*/
    System.out.println("Elevator Height: "+Robot.elevator.getCurrentPosition());
    System.out.println("Elevator Spin: "+Robot.elevator.getSpinPosition());
  }

  /*
   * This function is executed only once when the robot changes into disabled mode
   */
  @Override
  public void disabledInit() {
    /* Send disabled robot mode to Dashboard*/
    dashboard.setRobotMode("Disabled");
  }

  /*
   * This function is executed periodically when in disabled mode
   */
  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /*
   * This function is executed only once when the robot changes into autonomous
   * mode
   */
  @Override
  public void autonomousInit() {

    /* Send autonomous robot mode to Dashboard*/
    dashboard.setRobotMode("Autonomous");

    /* Set mode variable to the chosen autonomous mode id */
    mode = dashboard.getSelectedAutonomous();

    /* Set autonomousCommand to the right command according to the mode variable */
    if (mode == 0) {
      /* Manual driving using camera, leave autonomousCommand as null */
    } else if (mode == 1) {
      /* Move Straight selected*/
      autonomousCommand = (Command) new Straight();
    } else if (mode == 2) {
      /* Left Rocket selected*/
      autonomousCommand = (Command) new LeftDoubleHatch();
    } else if (mode == 3) {
      /* Right Rocket selected*/
      autonomousCommand = (Command) new RightDoubleHatch();
    } else {
      /* Manual driving using camera as last resort, leave autonomousCommand as null */
    }

    /* Start the autonomous command if it has not been started already */
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  /*
   * This function is executed periodically when in autonomous mode
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();

    /* Emergency autonomous shutdown */
    if (OI.driver.getRawButton(8)) {
      if (autonomousCommand != null) {
        autonomousCommand.cancel();
      }
    }
  }

  /*
   * This function is executed only once when the robot changes into teleop mode
   */
  @Override
  public void teleopInit() {

    /* Send teleop robot mode to Dashboard*/
    dashboard.setRobotMode("Teleop");

    /* Stop the autonomous if it is still running */
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  /*
   * This function is executed periodically when in teleop mode
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

}