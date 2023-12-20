package frc.robot.subsystems.Arm;
//import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {
    
    public default void setPosition(double position) {}

    public default void setVelocity(double veloicty) {}

    public default void stop() {}

    public default void configurePID(double kP, double kI, double kD) {}
}
