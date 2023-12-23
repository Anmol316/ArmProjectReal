package frc.robot.subsystems.Arm;
//import org.littletonrobotics.junction.AutoLog;

import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {
    @AutoLog
    public static class ArmMotorIO {
    public double motorPostion = 0.0;
    public double motorVelocity = 0.0;

    public double appliedVolts = 0.0;
    public double currentAmps = 0.0;
    }
    
    public default void setPosition(double position) {}

    public default void setVelocity(double veloicty) {}

    public default void stop() {}

    public default void configurePID(double kP, double kI, double kD) {}
}
