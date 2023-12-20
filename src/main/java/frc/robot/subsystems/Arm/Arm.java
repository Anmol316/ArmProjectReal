package frc.robot.subsystems.Arm;



import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class Arm extends SubsystemBase {
    private final ArmMotorIO motor;

    public Arm(ArmMotorIO motor) {
        this.motor = motor;

      }

      public void setPosition(double position) {
        motor.setPosition(position);
}
}