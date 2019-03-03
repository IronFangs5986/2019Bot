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
    public void moveUp(double speed) {
        elevator.set(speed);
    }

    /*
     * Sets the elevator to move down
     */
    public void moveDown() {
        elevator.set(0);
    }

    /*
     * Sets the elevator to hold its current position
     */
    public void hold() {
        elevator.set(.2);
    }

    /*
     * Determines the current elevator distance based on an encoder.
     */
    public double getCurrentPosition() {
        return RobotMap.liftEncoder.getDistance();
    }

    /*
     * Sets the motor spin
     */
    public void spin(Double speed) {
        RobotMap.elevatorSpin.set(speed);
    }

    /*
     * Resets elevator encoder
     */
    public void reset() {
        RobotMap.liftEncoder.reset();
    }

    /*
     * Set public values of elevator distances of minimum and maximum for each target
     */
    public double bottomHatchLow = 0.0; // Unknown
    public double bottomHatchHigh = 0.0; // Unknown
    public double middleHatchLow = 0.0; // Unknown
    public double middleHatchHigh = 0.0; // Unknown
    public double topHatchLow = 0.0; // Unknown
    public double topHatchHigh = 0.0; // Unknown

    public double bottomCargoLow = 0.0; // Unknown
    public double bottomCargoHigh = 0.0; // Unknown
    public double middleCargoLow = 0.0; // Unknown
    public double middleCargoHigh = 0.0; // Unknown
    public double topCargoLow = 0.0; // Unknown
    public double topCargoHigh = 0.0; // Unknown

    public double shipCargoLow = 0.0; // Unknown
    public double shipCargoHigh = 0.0; // Unknown

    public double minimum = 0.0; // Unknown
    public double maximum = 0.0; // Unknown
}