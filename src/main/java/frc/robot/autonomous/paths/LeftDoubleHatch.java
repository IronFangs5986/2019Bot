package frc.robot.autonomous.paths;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.autonomous.actions.SideDriveWithCamera;
import frc.robot.autonomous.actions.StraightDrive;
import frc.robot.autonomous.actions.TurnDrive;
import frc.robot.commands.ActivateHatchHolder;

/*
 * Autonomous for delivering two hatches in the left
 */
public class LeftDoubleHatch extends CommandGroup {

    public LeftDoubleHatch() {
        /* Drives forward for 14ft 0in */
        addSequential(new StraightDrive(true, 14, 0));

        addSequential(new SideDriveWithCamera(false));

        addSequential(new TurnDrive(false, 45, 5));

        addSequential(new ActivateHatchHolder(true));

        addSequential(new StraightDrive(true, 3, 0));

    }
}