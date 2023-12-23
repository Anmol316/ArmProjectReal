package frc.robot.subsystems.Arm;
//package frc.robot.subsystems.intake;


import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.math.util.Units;

public class ArmMotorIO implements ArmRealIO {
    private final TalonFX falcon;

    private final StatusSignal<Double> pivotPosition;
    private final StatusSignal<Double> pivotVelocity;
    private final StatusSignal<Double> appliedVolts;
    private final StatusSignal<Double> currentAmps;

    public ArmMotorIO(int id) {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.CurrentLimits.StatorCurrentLimit = 30;
        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        falcon = new TalonFX(id);

        falcon.getConfigurator().apply(config);

        pivotPosition = falcon.getPosition();
        pivotVelocity = falcon.getVelocity();
        appliedVolts = falcon.getMotorVoltage();
        currentAmps = falcon.getStatorCurrent();

        BaseStatusSignal.setUpdateFrequencyForAll(100, pivotPosition, pivotVelocity, appliedVolts, currentAmps);

    //    falcon.configSelectedFeedbackSensor()
}

public void updateInputs(ArmRealIOInputs inputs) {
    inputs.motorPostion = Units.rotationsToDegrees(pivotPosition.getValueAsDouble());
    inputs.motorVelocity = Units.rotationsPerMinuteToRadiansPerSecond(pivotVelocity.getValueAsDouble());

    inputs.appliedVolts = appliedVolts.getValue();
    inputs.currentAmps = currentAmps.getValue();

}

public void stop() {
    falcon.stopMotor();
}

public void configurePID(double kP, double kI, double kD) {
    Slot0Configs config = new Slot0Configs();

    config.kP = kP;
    config.kI = kI;
    config.kD = kD;

    falcon.getConfigurator().apply(config);

}
public void setPosition(double position) {
        falcon.setControl(new PositionVoltage(position));

}
public void recordVelocity(double velocity) {
    falcon.setControl(new VelocityVoltage(velocity));
  }

}
