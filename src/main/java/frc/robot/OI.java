package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ActivateCargoIntake;
import frc.robot.commands.ActivateHatchHolder;
import frc.robot.commands.MoveStrafeyBois;

/*
 * This class defines everything related to joysticks and controls
 */
public class OI {

  /* Define joysticks and controllers */
  public static Joystick driver;

  /* Define buttons */
  public JoystickButton shootCargo;
  public JoystickButton intakeCargo;
  public JoystickButton activateHatchHolder;
  /* Allows buttons and joysticks to be accessed from anywhere */
  public OI() {

    /* Assign joystick id to joystick */
    driver = new Joystick(1);

    /* Assign button id to buttons */
    shootCargo = new JoystickButton(driver, 2);
    intakeCargo = new JoystickButton(driver, 0); //Unknown button id
    activateHatchHolder = new JoystickButton(driver, 0); //Unknown button id

    /* Handle button presses */
    shootCargo.whenPressed(new MoveStrafeyBois(false));
    shootCargo.whenReleased(new MoveStrafeyBois(true));
    intakeCargo.whenPressed(new ActivateCargoIntake(true));
    intakeCargo.whenReleased(new ActivateCargoIntake(false));
    activateHatchHolder.whenPressed(new ActivateHatchHolder(true));
    activateHatchHolder.whenReleased(new ActivateHatchHolder(false));
  }
}
