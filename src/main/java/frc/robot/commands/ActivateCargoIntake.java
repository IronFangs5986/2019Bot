package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/*
 * This is the command that turns on and off the cargo intake
 */
public class ActivateCargoIntake extends Command {

    /* Boolean that holds wether to turn on or off the intake, and direction */
    boolean turnOn;
    boolean turnReverse;

    /*
     * Require the `on` parameter to know wether to turn on or off the intake, and requires the CargoIntake subsystem
     */
    public ActivateCargoIntake(boolean on, boolean reverse) {
        turnOn = on;
        turnReverse = reverse;
		requires(Robot.cargoIntake);
    }

    /*
     * Executes the command
     */
    protected void execute() {

        /* Checks if the intake should turn on or off, and executes the right command */
        if (turnOn) {
            if (turnReverse) {
                Robot.cargoIntake.out();
            } else {
                Robot.cargoIntake.on();
            }
        } else {
                Robot.cargoIntake.off();
        }
    }

    /*
     * Makes sure the command is only executed once
     */
    @Override
    protected boolean isFinished() {
        return true;
    }

}