package frc.robot.subsystems.Arm;


import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.pneumatics.CompressorIO;
import frc.robot.subsystems.pneumatics.CompressorIOInputsAutoLogged;
import frc.robot.subsystems.pneumatics.DoubleSolenoidIO;
import frc.robot.subsystems.pneumatics.DoubleSolenoidIOInputsAutoLogged;

public class ArmReal extends SubsystemBase {
    private final ArmRealIO motor;
    private final DoubleSolenoidIO brake;
    private final CompressorIO compressor;
    private final ArmRealIOInputsAutoLogged pInputs = new ArmRealIOInputsAutoLogged();
    private final CompressorIOInputsAutoLogged cInputs = new CompressorIOInputsAutoLogged();
    private final DoubleSolenoidIOInputsAutoLogged dsInputs = new DoubleSolenoidIOInputsAutoLogged();
   // private final PivotIOInputsAutoLogged pInputs = new PivotIOInputsAutoLogged();
    //private final ArmMotorIOInputsAutoLogged pInputs = new ArmMotorIOInputsAutoLogged();
    
    //XboxController OneButton = new XboxController(1);

    //JoystickButton aButton = new JoystickButton(Joystick name, int 1);

    public ArmReal(CompressorIO compressor, DoubleSolenoidIO brake, ArmRealIO motor) {
        this.motor = motor;
        this.brake = brake;
        this.compressor = compressor;
    }

    public void periodic() {
        compressor.updateInputs(cInputs);
        brake.updateInputs(dsInputs);
        motor.updateInputs(pInputs);
        
        Logger.processInputs("Compressor", cInputs);
        Logger.processInputs("Brake", dsInputs);
        Logger.processInputs("Motor", pInputs);


    }
     public void setPosition(double position) {
    brake.deactivate();
    motor.setPosition(position);
    brake.activate();

    Logger.recordOutput("Intake Target", position);
  }

  public void stop() {
    motor.stop();
  }

  public void activateBrake() {
    brake.activate();
  }

  public void deactivateBrake() {
    brake.deactivate();
  }

  public void toggleCompressor() {
    compressor.toggleCompressor();
  }
}



