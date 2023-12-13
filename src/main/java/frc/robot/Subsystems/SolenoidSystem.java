package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SolenoidConstants;

public class SolenoidSystem extends SubsystemBase{
    private final PneumaticHub m_hub = new PneumaticHub();
    private final DoubleSolenoid m_solenoid = m_hub.makeDoubleSolenoid(SolenoidConstants.forwardSolenoidChannel, SolenoidConstants.backwardSolenoidChannel);

    public void initialize() {
        m_hub.enableCompressorDigital();
    }

    public void toggle() {
        m_solenoid.toggle();
    }

    public void pushForward() {
        m_solenoid.set(Value.kForward);
    }

    public void pushBackward() {
        m_solenoid.set(Value.kReverse);
    }

    public void pushOff() {
        m_solenoid.set(Value.kOff);
    }
}