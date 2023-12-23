package frc.robot.subsystems.pneumatics;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticIntake extends SubsystemBase {
  private final DoubleSolenoidIOPCM intakeSolenoid;
  private final CompressorIOPCM compressor;
  private final DoubleSolenoidIOInputsAutoLogged sInputs = new DoubleSolenoidIOInputsAutoLogged();
  private final CompressorIOInputsAutoLogged cInputs = new CompressorIOInputsAutoLogged();

  private boolean toggle = false;;
  /** Creates a new PneumaticIntake. */
  public PneumaticIntake(DoubleSolenoidIOPCM intakeSolenoid, CompressorIOPCM compressor) {
    this.intakeSolenoid = intakeSolenoid;
    this.compressor = compressor;
  }

  public void toggleCompressor() {
    if (!toggle) {
      compressor.enableCompressor();
      toggle = true;
    } else {
      compressor.disableCompressor();
      toggle = false;
    }
  }

  @Override
  public void periodic() {
    intakeSolenoid.updateInputs(sInputs);
    compressor.updateInputs(cInputs);

    Logger.processInputs("DoubleSolenoid", sInputs);
    Logger.processInputs("Compressor", cInputs);
    // This method will be called once per scheduler run
  }
}