package frc.robot.autonomous.paths;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.autonomous.actions.StartAutonomous;
import frc.robot.autonomous.actions.StraightDrive;

/*
 * Autonomous for delivering two hatches in the left
 */
public class Straight extends CommandGroup {

    public Straight() {
        /* Starts autonomous configuration */
        addSequential(new StartAutonomous());
        
        /* Drives forward for ~14ft 0in (Varies to to 2nd level HAB jump) */
        addSequential(new StraightDrive(true, 14, 0));
    }
}