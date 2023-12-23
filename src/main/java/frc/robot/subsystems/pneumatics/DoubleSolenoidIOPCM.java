package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class DoubleSolenoidIOPCM implements DoubleSolenoidIO{
    private final DoubleSolenoid dSolenoid;

    public DoubleSolenoidIOPCM (int module, int fChannel, int rChannel) {
        dSolenoid = new DoubleSolenoid(module, PneumaticsModuleType.CTREPCM, fChannel, rChannel);
    }

    @Override
    public void updateInputs(DoubleSolenoidIOInputs inputs) {
        if (dSolenoid.get() != Value.kOff) {
            inputs.isOn = true;
        } else {
            inputs.isOn = false;
        }
    }

    @Override
    public void activate() {
        dSolenoid.set(Value.kForward);
    }

    @Override
    public void deactivate() {
        dSolenoid.set(Value.kOff);
    }
}