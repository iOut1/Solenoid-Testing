package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.SolenoidSystem;

public class SolenoidCommand extends CommandBase {
    private SolenoidSystem m_solenoid;
    private XboxController m_controller;

    public SolenoidCommand(SolenoidSystem solenoid, XboxController controller) {
        m_controller = controller;
        m_solenoid = solenoid;

        addRequirements(m_solenoid);
    }
    
    @Override
    public void initialize() {
        m_solenoid.pushOff();
    }

    @Override
    public void execute() {
        if (m_controller.getRightBumper() && !m_controller.getLeftBumper()) {
            m_solenoid.pushForward();
        } else if (m_controller.getLeftBumper() && !m_controller.getRightBumper()) {
            m_solenoid.pushBackward();
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_solenoid.pushOff();
    }
}
