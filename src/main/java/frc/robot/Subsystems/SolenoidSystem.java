package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SolenoidConstants;

public class SolenoidSystem extends SubsystemBase{
    private final PneumaticHub m_hub = new PneumaticHub();
    private final DoubleSolenoid m_clawSolenoid = m_hub.makeDoubleSolenoid(SolenoidConstants.forwardSolenoidChannel, SolenoidConstants.backwardSolenoidChannel);
    private final Solenoid m_raiseSolenoid = m_hub.makeSolenoid(SolenoidConstants.raiseSolenoidChannel);

    public void initialize() {
        m_hub.enableCompressorDigital();
    }

    public void clawToggle() {
        m_clawSolenoid.toggle();
    }


    public void closeClaw() {
        m_clawSolenoid.set(Value.kForward);
    }

    public void openClaw() {
        m_clawSolenoid.set(Value.kReverse);
    }

    public void clawPushOff() {
        m_clawSolenoid.set(Value.kOff);
    }
    public void raiseArm() {
        m_raiseSolenoid.set(true);
    }
    public void armOff() {
        m_raiseSolenoid.set(false);
    }
}