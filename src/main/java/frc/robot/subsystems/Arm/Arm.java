package frc.robot.subsystems.Arm;



import org.littletonrobotics.conduit.schema.Joystick;
import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.pneumatics.CompressorIO;
import frc.robot.subsystems.Arm.ArmIOInputsAutoLogged;
import frc.robot.subsystems.pneumatics.CompressorIOInputsAutoLogged;
import frc.robot.subsystems.pneumatics.DoubleSolenoidIO;
import frc.robot.subsystems.pneumatics.DoubleSolenoidIOInputsAutoLogged;
public class Arm extends SubsystemBase {
    private final ArmIO motor;
    private final DoubleSolenoidIO brake;
    private final CompressorIO compressor;
    private final ArmIOInputsAutoLogged sInputs = new ArmIOInputsAutoLogged();
    private final CompressorIOInputsAutoLogged cInputs = new CompressorIOInputsAutoLogged();
    private final DoubleSolenoidIOInputsAutoLogged dsInputs = new DoubleSolenoidIOInputsAutoLogged();
   // private final PivotIOInputsAutoLogged pInputs = new PivotIOInputsAutoLogged();
    //private final ArmMotorIOInputsAutoLogged pInputs = new ArmMotorIOInputsAutoLogged();
    
    //XboxController OneButton = new XboxController(1);

    //JoystickButton aButton = new JoystickButton(Joystick name, int 1);

    public Arm(CompressorIO compressor, DoubleSolenoidIO brake, ArmIO motor) {
        this.motor = motor;
        this.brake = brake;
        this.compressor = compressor;
    }

    public void periodic() {
        compressor.updateInputs(cInputs);
        brake.updateInputs(dsInputs);
        motor.updateInputs(sInputs);
        
        Logger.processInputs("Compressor", cInputs);
        Logger.processInputs("Brake", dsInputs);
        Logger.processInputs("Motor", sInputs);


    }

}

