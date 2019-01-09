package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArcadeDrive extends Command {

    /* State the required driveTrain subsystem */
    public ArcadeDrive() {
		requires(Robot.driveTrain);
    }
    
    /* This function is what is done when the command is run */
    protected void execute() {
        /* Sets the arcadeDrive to the 2 drive axis and strafe axis (NEED ACTUAL AXIS) */
		Robot.driveTrain.arcadeDrive(Robot.oi.driver.getRawAxis(1), Robot.oi.driver.getRawAxis(1), Robot.oi.driver.getRawAxis(1));
    }
    
    /* Makes command run forever */
    @Override
    protected boolean isFinished() {
        return false;
    }

}