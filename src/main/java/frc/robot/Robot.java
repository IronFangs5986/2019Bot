package main.java.frc.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

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

  @Override
  public void robotPeriodic() {
    /* Send gyroscope data to NetworkTables */
    table.putNumber("Gyro-X", imu.getAngleX());
    table.putNumber("Gyro-Y", imu.getAngleY());
    table.putNumber("Gyro-Z", imu.getAngleZ());

    /* Send battery percentage to NetworkTables */
    table.putNumber("battery", DriverStation.getInstance().getBatteryVoltage());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

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

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {

    /* Stop the autonomous if it is still running */
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
