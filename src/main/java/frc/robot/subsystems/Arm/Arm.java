package frc.robot.subsystems.Arm;



import org.littletonrobotics.conduit.schema.Joystick;
import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
public class Arm extends SubsystemBase {
    private final ArmMotorIO motor;
    
    //XboxController OneButton = new XboxController(1);

    //JoystickButton aButton = new JoystickButton(Joystick name, int 1);

    public Arm(ArmMotorIO motor) {
        this.motor = motor;
    }


      public void setPosition(double position) {
        motor.setPosition(position);

        Logger.recordOutput("", position);
}

public void recordVelocity(double veloicty) {
  motor.setPosition(veloicty);

  Logger.recordOutput("", veloicty);
}

public void recordVolts(double appliedVolts) {
  motor.setPosition(appliedVolts);

  Logger.recordOutput("", appliedVolts);

}

public void recordCurrent(double currentAmps) {
  motor.setCurrent(currentAmps);
 // motor.setPosition(currentAmps);

  Logger.recordOutput("", currentAmps);

}

public void recordPressure(double pressure)
}