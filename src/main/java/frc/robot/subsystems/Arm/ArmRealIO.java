package frc.robot.subsystems.Arm;
//import org.littletonrobotics.junction.AutoLog;

import org.littletonrobotics.junction.AutoLog;

public interface ArmRealIO {
    @AutoLog
    public static class ArmRealIOInputs {
    public double motorPostion = 0.0;
    public double motorVelocity = 0.0;

    public double appliedVolts = 0.0;
    public double currentAmps = 0.0;
    }

    public default void updateInputs(ArmRealIOInputs inputs) {}
    
    public default void setPosition(double position) {}

    public default void setVelocity(double veloicty) {}

    public default void stop() {}

    public default void configurePID(double kP, double kI, double kD) {}
}
