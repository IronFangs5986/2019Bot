package frc.robot.autonomous.paths;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.autonomous.actions.StartAutonomous;
import frc.robot.autonomous.actions.StraightDrive;
import frc.robot.autonomous.actions.TurnDrive;
import frc.robot.commands.MoveHatchHolder;

public class MiddleHatch extends CommandGroup {

    public MiddleHatch() {
        /* Starts autonomous configuration */
        addSequential(new StartAutonomous());

        /* Drives forward for ~11ft 6in (Varies due to 1st level HAB jump) */
        addParallel(new StraightDrive(true, 11, 6));

        /* Waits 3 seconds before closing the hatch holder*/
        addSequential(new WaitCommand(3));

        /* Closes the hatch holder*/
        addSequential(new MoveHatchHolder(false));

        /* Drives back 3ft 0in */
        addSequential(new StraightDrive(false, 3, 0));

        /* Opens the hatch holder*/
        addSequential(new MoveHatchHolder(true));

        /* Turns 135 degrees to the right */
        addSequential(new TurnDrive(true, true, 135, 12));
    }
}