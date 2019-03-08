package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ActivateCargoIntake;
import frc.robot.commands.ActivateHatchHolder;
import frc.robot.commands.MoveCargoIntake;
import frc.robot.commands.MoveElevator;
import frc.robot.commands.MoveStrafeyBois;

/*
 * This class defines everything related to joysticks and controls
 */
public class OI {

  /* Define joysticks and controllers */
  public static Joystick driver;
  public static Joystick operator;

  /* Define buttons */
  public JoystickButton shootCargo;
  public JoystickButton intakeCargo;
  public JoystickButton activateHatchHolder;
  public JoystickButton raiseCargoIntake;
  public JoystickButton lowerCargoIntake;
  public JoystickButton reverseCargoIntake;
  public JoystickButton hatchBottom;
  public JoystickButton hatchMiddle;
  public JoystickButton hatchTop;
  public JoystickButton cargoBottom;
  public JoystickButton cargoMiddle;
  public JoystickButton cargoTop;

  /* Allows buttons and joysticks to be accessed from anywhere */
  public OI() {

    /* Assign joystick id to joystick */
    driver = new Joystick(1);
    operator = new Joystick(2);

    /* Assign button id to buttons */
    shootCargo = new JoystickButton(driver, 4);
    intakeCargo = new JoystickButton(driver, 2);
    activateHatchHolder = new JoystickButton(driver, 1);
    raiseCargoIntake = new JoystickButton(driver, 5);
    lowerCargoIntake = new JoystickButton(driver, 3);
    reverseCargoIntake = new JoystickButton(driver, 6);
    hatchBottom = new JoystickButton(operator, 11);
    hatchMiddle = new JoystickButton(operator, 9);
    hatchTop = new JoystickButton(operator, 7);
    cargoBottom = new JoystickButton(operator, 12);
    cargoMiddle = new JoystickButton(operator, 10);
    cargoTop = new JoystickButton(operator, 8);

    /* Handle button presses */
    shootCargo.whenPressed(new MoveStrafeyBois(false));
    shootCargo.whenReleased(new MoveStrafeyBois(true));
    intakeCargo.whenPressed(new ActivateCargoIntake(true, false));
    intakeCargo.whenReleased(new ActivateCargoIntake(false, false));
    activateHatchHolder.whenPressed(new ActivateHatchHolder(true));
    activateHatchHolder.whenReleased(new ActivateHatchHolder(false));
    raiseCargoIntake.whenPressed(new MoveCargoIntake(true));
    lowerCargoIntake.whenPressed(new MoveCargoIntake(false));
    reverseCargoIntake.whenPressed(new ActivateCargoIntake(true, true));
    reverseCargoIntake.whenReleased(new ActivateCargoIntake(false, true));
    hatchBottom.whenPressed(new MoveElevator(1));
    hatchMiddle.whenPressed(new MoveElevator(2));
    hatchTop.whenPressed(new MoveElevator(3));
    cargoBottom.whenPressed(new MoveElevator(4));
    cargoMiddle.whenPressed(new MoveElevator(5));
    cargoTop.whenPressed(new MoveElevator(6));
  }
}
