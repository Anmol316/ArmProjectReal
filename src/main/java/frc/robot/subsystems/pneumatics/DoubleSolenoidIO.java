package frc.robot.subsystems.pneumatics;

import org.littletonrobotics.junction.AutoLog;

public interface DoubleSolenoidIO {
    @AutoLog
    public static class DoubleSolenoidIOInputs {
        public boolean isOn = false;
    }

    public default void updateInputs(DoubleSolenoidIOInputs inputs) {}

    public default void toggleCompressor() {

    }

    public default void retractIntake() {
        
    }
    public default void activate() {}

    public default void deactivate() {}
}