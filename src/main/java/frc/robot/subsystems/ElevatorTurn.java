package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorHandler;
import frc.robot.commands.SpinElevator;

/*
 * This is the Elevator subsystem where anything related to the elevator is found
 */
public class ElevatorTurn extends Subsystem {
    
    public ElevatorTurn() {}

    @Override
    protected void initDefaultCommand() {    }

    
    /*
     * Determines the current elevator lift distance based on an encoder.
     */
    public double getCurrentPosition() {
        return RobotMap.turnEncoder.getDistance();
    }

    /*
     * Sets the motor spin
     */
    public void spin(Double speed) {
        if (Math.abs(speed) >= .2) {
        if (Math.abs(speed) >= .45) {
            if (speed > 0) {
                RobotMap.elevatorSpin.set(.45);
                //System.out.println("Elevator Spin: .35");
            } else {
                RobotMap.elevatorSpin.set(-.45);
                //System.out.println("Elevator Spin: -.35");
            }
        } else {
            RobotMap.elevatorSpin.set(speed);
            //System.out.println("Elevator Spin: "+speed);
        }
    } else {
        RobotMap.elevatorSpin.set(0.0);
        //System.out.println("Elevator Spin: 0.0");
    }
    }

    /*
     * Resets elevator encoder
     */
    public void reset() {
        RobotMap.turnEncoder.reset();
    }

    /*
     * Define distances of certain elevator turn positions in sprocket teeth.
     */
    public double elevatorFront = 0.0;
    public double elevatorRight = 18.0;
    public double elevatorLeft = -18.0;
}