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
            //Robot.elevator.spin(OI.operator.getRawAxis(2));
          //  Robot.elevator.hold();
          //Robot.elevator.moveUp(.3);
        } else {
          //  Robot.elevator.moveUp(OI.operator.getRawAxis(1));
          Robot.elevator.moveUp(0.0);
        }

        //if (OI.operator.getRawButton(3)) {
            //if (Robot.elevator.getSpinPosition() <= 2.323 && Robot.elevator.getSpinPosition() >= 0.0) {
                Robot.elevator.spin(OI.operator.getRawAxis(2));
            //} else {
             //   Robot.elevator.spin(0.0); 
            //}
       // } else {
         //   Robot.elevator.spin(0.0);
        //}

    }

    /*
     * Makes command run forever
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

}