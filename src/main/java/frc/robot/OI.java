package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.commands.ActivateCargoIntake;
import frc.robot.commands.ActivateHatchHolder;
import frc.robot.commands.MoveCargoIntake;
import frc.robot.commands.MoveElevator;
import frc.robot.commands.MoveHatchHolder;
import frc.robot.commands.MoveStrafeyBois;
import frc.robot.commands.SlideHatchHolder;
import frc.robot.commands.SpinElevator;

/*
 * This class defines everything related to joysticks and controls
 */
public class OI {

  /* Define joysticks and controllers */
  public static Joystick driver;
  public static Joystick operator;

  /* Define buttons */
  public JoystickButton intakeCargo;
  public JoystickButton openHatchHolder;
  public JoystickButton slideHatchHolder;
  public JoystickButton moveStrafeyBois;
  public JoystickButton raiseCargoIntake;
  public JoystickButton lowerCargoIntake;
  public JoystickButton reverseCargoIntake;
  public JoystickButton hatchBottom;
  public JoystickButton hatchMiddle;
  public JoystickButton hatchTop;
  public JoystickButton cargoBottom;
  public JoystickButton cargoMiddle;
  public JoystickButton cargoTop;
  public POVButton forwardElevator;
  public POVButton rightElevator;
  public POVButton backElevator;
  public POVButton leftElevator;

  /* Allows buttons and joysticks to be accessed from anywhere */
  public OI() {

    /* Assign joystick id to joystick */
    driver = new Joystick(1);
    operator = new Joystick(2);

    /* Assign button id to buttons */
    intakeCargo = new JoystickButton(driver, 10);
    openHatchHolder = new JoystickButton(driver, 11);
    slideHatchHolder = new JoystickButton(driver, 12);
    moveStrafeyBois = new JoystickButton(driver, 1);
    raiseCargoIntake = new JoystickButton(driver, 5);
    lowerCargoIntake = new JoystickButton(driver, 3);
    reverseCargoIntake = new JoystickButton(driver, 9);
    hatchBottom = new JoystickButton(operator, 11);
    hatchMiddle = new JoystickButton(operator, 9);
    hatchTop = new JoystickButton(operator, 7);
    cargoBottom = new JoystickButton(operator, 12);
    cargoMiddle = new JoystickButton(operator, 10);
    cargoTop = new JoystickButton(operator, 8);
    forwardElevator = new POVButton(operator, 0);
    rightElevator = new POVButton(operator, 90);
    backElevator = new POVButton(operator, 180);
    leftElevator = new POVButton(operator, 270);

    /* Handle button presses */
    intakeCargo.whenPressed(new ActivateCargoIntake(true, false));
    intakeCargo.whenReleased(new ActivateCargoIntake(false, false));
    openHatchHolder.whenPressed(new MoveHatchHolder(true));
    openHatchHolder.whenReleased(new MoveHatchHolder(false));
    slideHatchHolder.whenPressed(new SlideHatchHolder(true));
    slideHatchHolder.whenReleased(new SlideHatchHolder(false));
    moveStrafeyBois.whenPressed(new MoveStrafeyBois(false));
    moveStrafeyBois.whenReleased(new MoveStrafeyBois(true));
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
    forwardElevator.whenPressed(new SpinElevator(1));
    rightElevator.whenPressed(new SpinElevator(2));
    backElevator.whenPressed(new SpinElevator(3));
    leftElevator.whenPressed(new SpinElevator(4));
  }
}
