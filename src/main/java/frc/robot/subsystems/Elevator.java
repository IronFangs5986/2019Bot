package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorHandler;
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
        elevator.set(0);
    }

    /*
     * Sets the elevator to hold its current position
     */
    public void hold() {
        elevator.set(-.3);
    }

    /*
     * Determines the current elevator lift distance based on an encoder.
     */
    public double getCurrentPosition() {
        return RobotMap.liftEncoder.getDistance();
    }

    /*
     * Determines the current elevator spin distance based on an encoder.
     */
    public double getSpinPosition() {
        return RobotMap.turnEncoder.getDistance();
    }

    /*
     * Sets the motor spin
     */
    public void spin(Double speed) {
        if (Math.abs(speed) >= .1) {
        if (Math.abs(speed) >= .35) {
            if (speed > 0) {
                RobotMap.elevatorSpin.set(.35);
                System.out.println("Elevator Spin: .35");
            } else {
                RobotMap.elevatorSpin.set(-.35);
                System.out.println("Elevator Spin: -.35");
            }
        } else {
            RobotMap.elevatorSpin.set(speed);
            System.out.println("Elevator Spin: "+speed);
        }
    } else {
        RobotMap.elevatorSpin.set(0.0);
        System.out.println("Elevator Spin: 0.0");
    }
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
    public double bottomHatchLow = 1.5; // Unknown
    public double bottomHatchHigh = 2.5; // Unknown
    public double middleHatchLow = 10.5; // Unknown
    public double middleHatchHigh = 11.5; // Unknown
    public double topHatchLow = 15 ; // Unknown
    public double topHatchHigh = 16; // Unknown

    public double bottomCargoLow = 0.0; // Unknown
    public double bottomCargoHigh = 0.0; // Unknown
    public double middleCargoLow = 0.0; // Unknown
    public double middleCargoHigh = 0.0; // Unknown
    public double topCargoLow = 0.0; // Unknown
    public double topCargoHigh = 0.0; // Unknown

    public double shipCargoLow = 0.0; // Unknown
    public double shipCargoHigh = 0.0; // Unknown

    public double minimum = 0.0; // Unknown
    public double maximum = 16.5; // Unknown

    public double elevatorFront = 0.0; // Unknown
    public double elevatorRight = 0.0; // Unknown
    public double elevatorBack = 0.0; // Unknown
    public double elevatorLeft = 0.0; // Unknown
}