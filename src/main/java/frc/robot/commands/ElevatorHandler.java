package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

/*
 * This is the command that handles POV controls to move elevator
 */
public class ElevatorHandler extends Command {

    public ElevatorHandler() {
        requires(Robot.elevator);
    }

    /*
     * Executes the command
     */
    protected void execute() {

        /* Resets elevator lift encoder */
        if (!RobotMap.liftResetSensor.get()) {
            Robot.elevator.reset();
        }


        if (OI.operator.getRawButton(1)) {
            Robot.elevator.spin(OI.operator.getRawAxis(2));
        }

    }

    /*
     * Makes command run forever
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

}