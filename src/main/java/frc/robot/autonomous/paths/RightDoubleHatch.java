package frc.robot.autonomous.paths;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.autonomous.actions.SideDriveWithCamera;
import frc.robot.autonomous.actions.StartAutonomous;
import frc.robot.autonomous.actions.StraightDrive;
import frc.robot.autonomous.actions.StraightDriveReachTape;
import frc.robot.autonomous.actions.TurnAndStrafe;
import frc.robot.autonomous.actions.TurnDrive;
import frc.robot.commands.ActivateHatchHolder;

/*
 * Autonomous for delivering two hatches in the right rocket
 */
public class RightDoubleHatch extends CommandGroup {

    public RightDoubleHatch() {
        /* Starts autonomous configuration */
        addSequential(new StartAutonomous());

        /* Drives forward for ~14ft 0in (Varies to to 2nd level HAB jump) */
        addSequential(new StraightDrive(true, 14, 0));

        /* Strafes to the right until it is centered with reflective tape */
        addSequential(new SideDriveWithCamera(true));

        /* Turns 45 degrees forward to the right with a radius of 5in */
        addSequential(new TurnDrive(true, true, 45, 5));

        /* Opens and extends hatch holder to deliver hatch */
        addSequential(new ActivateHatchHolder(true));

        /* Drives forward until the robot reaches the rocket */
        addSequential(new StraightDriveReachTape());

        /* Turns 45 degrees backward to the right with a radius of 5in */
        addSequential(new TurnDrive(true, false, 45, 5));

        /* Turns and strafes at the same time until it successfully turns 180 degrees */
        addSequential(new TurnAndStrafe(true, 180));

        /* Drives forward until the robot reaches the loading station */
        addSequential(new StraightDriveReachTape());

        /* Closes and retracts the hatch holder */
        addSequential(new ActivateHatchHolder(false));

        /* Drives back 8ft 0in */
        addSequential(new StraightDrive(false, 8, 0));

        /* Turns 135 degrees backward to the left with a radius of 6ft 6in */
        addSequential(new TurnDrive(false, false, 135, 6.5*12));

        /* Opens and extends hatch holder to deliver hatch */
        addSequential(new ActivateHatchHolder(true));

        /* Drives forward until the robot reaches the rocket */
        addSequential(new StraightDriveReachTape());

        /* Drives back 2ft 0in */
        addSequential(new StraightDrive(false, 2, 0));

        /* Closes and retracts hatch holder */
        addSequential(new ActivateHatchHolder(false));
    }
}