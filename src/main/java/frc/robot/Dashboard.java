package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

// TODO Add comments
public class Dashboard {

    /*  */
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("SmartDashboard");

    NetworkTableEntry battery = table.getEntry("battery");
    NetworkTableEntry selectedAuto = table.getEntry("autoSelected");
    NetworkTableEntry gyroX = table.getEntry("Gyro-X");
    NetworkTableEntry gyroY = table.getEntry("Gyro-Y");
    NetworkTableEntry gyroZ = table.getEntry("Gyro-Z");
    NetworkTableEntry autoList = table.getEntry("AutoList");

    public void setBattery(Double voltage) {
        battery.setDouble(voltage);
    }

    public int getSelectedAutonomous() {
        return (int) selectedAuto.getDouble(0.0);
    }

    public void setAutonomous(int mode) {
        selectedAuto.setNumber(mode);
    }

    public void setGyroscope(Double x, Double y, Double z) {
        gyroX.setDouble(x);
        gyroY.setDouble(y);
        gyroZ.setDouble(z);
    }

    public void setAutonomousList(String[] list) {
        autoList.setStringArray(list);
    }
}