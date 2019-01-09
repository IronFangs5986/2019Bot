package frc.robot;

import frc.robot.ADIS16448_IMU;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Robot extends TimedRobot {

  /* Initialize autonomousCommand to store chosen command */
  Command autonomousCommand;

  /* Initialize OI and Subsystems */
  public static OI oi;

  /* Initialize and define NetworkTable 'SmartDashbaord' */
  NetworkTable table = NetworkTable.getTable("SmartDashboard");

  /* Define default autonomous mode id */
  private int mode = 0;

  /* Initialize and define autonomous modes list */
  String[] autoList = { "" };

  /* Define gyroscope class */
  public static final ADIS16448_IMU imu = new ADIS16448_IMU();

  /*
   * This function is executed only once when the robot boots up
   */
  @Override
  public void robotInit() {
    /* Initialize RobotMap */
    RobotMap.init();

    /* Define OI and Subsystems */
    oi = new OI();

    /* Push autonomous list into NetworkTables */
    NetworkTable table = NetworkTable.getTable("SmartDashboard");
    table.putStringArray("AutoList", autoList);

    /* Select default autonomous mode */
    table.putNumber("autoSelected", 0);
  }

  /*
   * This function is executed periodically in any mode (disabled, teleop, autonomous, etc.)
   */
  @Override
  public void robotPeriodic() {
    /* Send gyroscope data to NetworkTables */
    table.putNumber("Gyro-X", imu.getAngleX());
    table.putNumber("Gyro-Y", imu.getAngleY());
    table.putNumber("Gyro-Z", imu.getAngleZ());

    /* Send battery voltage to NetworkTables */
    table.putNumber("battery", DriverStation.getInstance().getBatteryVoltage());
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
   * This function is executed only once when the robot changes into autonomous mode
   */
  @Override
  public void autonomousInit() {

    /* Set mode variable to the chosen autonomous mode id */
    mode = (int) table.getNumber("autoSelected", 0);

    /* Set autonomousCommand to the right command according to the mode variable */
    // ACTUALLY SET THE MODES WHEN WE HAVE THEM :)

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
