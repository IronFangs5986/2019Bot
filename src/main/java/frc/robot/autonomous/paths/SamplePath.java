package frc.robot.autonomous.paths;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.autonomous.actions.StraightDrive;
import frc.robot.autonomous.actions.TurnDrive;

/*
 * Test path to make sure encoders and sensors work properly. Should return to original position after.
 */
public class SamplePath extends CommandGroup {

    public SamplePath() {
        /* Drives forward and then back for 4ft 2in */
        addSequential(new StraightDrive(true, 4, 2));
        addSequential(new StraightDrive(false, 4, 2));

        /* Turns right 90 degrees forward and back on a 24in radius */
        addSequential(new TurnDrive(true, true, 90, 24));
        addSequential(new TurnDrive(true, false, 90, 24));
    }
}