package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorHandler;
import frc.robot.commands.SpinElevator;

/*
 * This is the Elevator subsystem where anything related to the elevator is found
 */
public class Elevator extends Subsystem {

    /* Initialize and define the elevator motor from RobotMap */
    private final WPI_TalonSRX elevator = RobotMap.elevator;
    
    public Elevator() {}

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ElevatorHandler());
    }

    /*
     * Sets the elevator to move up
     */
    public void moveUp(double speed) {
        elevator.set(-speed);
    }

    /*
     * Sets the elevator to move down
     */
    public void moveDown() {
        elevator.set(1);
    }

    /*
     * Sets the elevator to hold its current position
     */
    public void hold() {
        elevator.set(-0.5);
    }

    /*
     * Determines the current elevator lift distance based on an encoder.
     */
    public double getCurrentPosition() {
        return RobotMap.liftEncoder.getDistance();
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
    public double bottomHatchLow = 0.0;
    public double bottomHatchHigh = 0.0;
    public double middleHatchLow = 8.6;
    public double middleHatchHigh = 11.8;
    public double topHatchLow = 15.9 ;
    public double topHatchHigh = 18.3;

    public double bottomCargoLow = 0.0; // Unknown
    public double bottomCargoHigh = 0.0; // Unknown
    public double middleCargoLow = 6.77;
    public double middleCargoHigh = 6.77;
    public double topCargoLow = 14.16;
    public double topCargoHigh = 14.16;

    public double shipCargoLow = 1.2;
    public double shipCargoHigh = 1.2;

    public double minimum = 0.0; // Unknown
    public double maximum = 16.5; // Unknown
}