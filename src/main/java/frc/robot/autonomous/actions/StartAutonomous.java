package frc.robot.autonomous.actions;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

/*
 * This is the command that starts and sets the autonomous configurations
 */
public class StartAutonomous extends Command {

    /*
     * Public function to call, require 
     */
    public StartAutonomous() {
    }

     /*
     * Executes the command
     */
    protected void execute() {

        /* Resets encoders */
        RobotMap.leftEncoder.reset();
        RobotMap.rightEncoder.reset();
        RobotMap.liftEncoder.reset();

        /* Retracts the cargo intake */
        Robot.cargoIntake.off();

        /* Closes the hatch holder */
        Robot.hatchHolder.close();

        /* Slides the hatch holder back */
        Robot.hatchHolder.slideBack();
    }
    
    /*
     * Makes sure the command is only executed once
     */
    @Override
    protected boolean isFinished() {
        return true;
    }
}