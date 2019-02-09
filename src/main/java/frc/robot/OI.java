package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.MoveStrafeyBois;

/*
 * This class defines everything related to joysticks and controls
 */
public class OI {

  /* Define joysticks and controllers */
  public static Joystick driver;

  /* Define buttons */
  public JoystickButton strafeyBoisDown;
  public JoystickButton strafeyBoisUp;
  public JoystickButton shootCargo;

  /* Allows buttons and joysticks to be accessed from anywhere */
  public OI() {

    /* Assign joystick id to joystick */
    driver = new Joystick(1);

    /* Assign button id to buttons */
    shootCargo = new JoystickButton(driver, 2);

    /* Handle button presses */
    shootCargo.whenPressed(new MoveStrafeyBois(false));
    shootCargo.whenReleased(new MoveStrafeyBois(true));
  }
}
