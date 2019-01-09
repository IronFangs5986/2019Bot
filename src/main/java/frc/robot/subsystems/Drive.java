package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Drive extends Subsystem {

 /* Call RobotDrive defined in RobotMap */
    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

    public Drive() {

    }

    @Override
    protected void initDefaultCommand() {
        /* Sets ArcadeDrive as default command to execute */
        //setDefaultCommand(new ArcadeDrive());
    }

    public void arcadeDrive(double rawAxis, double rawAxis2, double strafe) {
		/* Sets arcadeDrive values */
        robotDrive.arcadeDrive(rawAxis, rawAxis2);
        
        /* Sets starafing motor speed */
	}
    
}