package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.SpinElevator;

/*
 * This is the Elevator subsystem where anything related to the elevator is found
 */
public class Elevator extends Subsystem {

    /* Initialize and define the elevator motor from RobotMap */
    private final WPI_VictorSPX elevator = RobotMap.elevator;
    
    public Elevator() {}

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new SpinElevator());
    }

    /*
     * Sets the elevator to move up
     */
    public void moveUp() {
        elevator.set(1);
    }

    /*
     * Sets the elevator to move down
     */
    public void moveDown() {
        elevator.set(-.7);
    }

    /*
     * Sets the elevator to hold its current position
     */
    public void hold() {
        elevator.set(.2);
    }

    /*
     * Determines the current elevator position based on hall effect sensors. Returns 0 if for some reason none of the sensors detect the elevator
     */
    public int getCurrentPosition() {
        if (RobotMap.bottomSensor.get()) {
            return 1;
        } else if (RobotMap.middleSensor.get()) {
            return 2;
        } else if (RobotMap.topSensor.get()) {
            return 3;
        } else {
            return 0;
        }
    }

    /*
     * Sets the motor spin
     */
    public void spin(Double speed) {
        RobotMap.elevatorSpin.set(speed);
    }

}