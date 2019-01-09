package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/* This class defines everything related to joysticks and controls */
public class OI {

  public static Joystick driver;

  /* Allows buttons and joysticks to be accessed from anywhere */
  public OI() {

    driver = new Joystick(1);
  }
}
