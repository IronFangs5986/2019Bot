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

  /* Allows buttons and joysticks to be accessed from anywhere */
  public OI() {

    /* Assign joystick id to joystick */
    driver = new Joystick(1);

    /* Assign button id to buttons */
    strafeyBoisDown = new JoystickButton(driver, 1); //Unknown button id
    strafeyBoisUp = new JoystickButton(driver, 1); //Unknown button id

    /* Handle button presses */
    strafeyBoisDown.whenPressed(new MoveStrafeyBois(false));
    strafeyBoisUp.whenPressed(new MoveStrafeyBois(false));
  }
}
