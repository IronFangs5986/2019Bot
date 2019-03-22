package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/*
 * This is the CargoIntake subsystem where anything related to the cargo intake is found
 */
public class CargoIntake extends Subsystem {

    /* Initialize and define the cargo intake motor and solenoid from RobotMap */
    private final WPI_TalonSRX cargoIntake = RobotMap.cargoIntake;
    private final Solenoid cargoIntakePiston = RobotMap.cargoIntakePiston;

    public CargoIntake() {}

    /*
     * Left empty as there is no default command to run
     */
    @Override
    protected void initDefaultCommand() {}

    /*
     * Turns on the intake motor
     */
    public void on() {
        cargoIntake.set(.85);
    }

    /*
     * Reverses the intake motor
     */
    public void out() {
        cargoIntake.set(-.85);
    }

    /*
     * Turns off the intake motor and piston
     */
    public void off() {
        cargoIntake.set(0);
    }

    /*
     * Lowers the Cargo Intake
     */
    public void lower() {
        cargoIntakePiston.set(true);
    }

    /*
     * Raises the Cargo Intake
     */
    public void raise() {
        cargoIntakePiston.set(false);
    }
}