package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Dashboard;
import frc.robot.Robot;

/*
 * This is the command that raises and lowers the cargo intake
 */
public class MoveCargoIntake extends Command {

    /* Boolean that holds wether to raise or lower the intake */
    boolean moveUp;

    /* Initialize Dashboard */
    Dashboard dashboard = new Dashboard();
    
    /*
     * Require the `on` parameter to know wether to raise or lower the intake, and requires the CargoIntake subsystem
     */
    public MoveCargoIntake(boolean up) {
        moveUp = up;
		requires(Robot.cargoIntake);
    }

    /*
     * Executes the command
     */
    protected void execute() {

        /* Checks if the intake should raise or lower, and executes the right command */
        if (moveUp) {
                Robot.cargoIntake.raise();
                dashboard.setIntakePosition("up");
        } else {
                Robot.cargoIntake.lower();
                dashboard.setIntakePosition("down");
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