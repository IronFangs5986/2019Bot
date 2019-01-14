package frc.robot;

import frc.robot.subsystems.Drive;
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

  /* Define default autonomous mode id */
  private int mode = 0;

  /* Initialize and define autonomous modes list */
  String[] autoList = { "" }; // List is currently empty :)

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
    oi = new OI();

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
  }

  /*
   * This function is executed only once when the robot changes into disabled mode
   */
  @Override
  public void disabledInit() {
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

    /* Set mode variable to the chosen autonomous mode id */
    mode = dashboard.getSelectedAutonomous();

    /* Set autonomousCommand to the right command according to the mode variable */
    if (mode == 0) {
      // TODO Set autonomous modes
    } else {
      /* Run a default command */
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
  }

  /*
   * This function is executed only once when the robot changes into teleop mode
   */
  @Override
  public void teleopInit() {

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