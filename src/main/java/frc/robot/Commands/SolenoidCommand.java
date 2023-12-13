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
        m_solenoid.clawPushOff();
    }

    @Override
    public void execute() {
        if (m_controller.getRightBumperPressed() && !m_controller.getLeftBumperPressed()) {
            m_solenoid.closeClaw();
        } else if (m_controller.getLeftBumperPressed() && !m_controller.getRightBumperPressed()) {
            m_solenoid.openClaw();
        }
        if (m_controller.getXButtonPressed()) {
            m_solenoid.raiseArm();
        }else if (m_controller.getAButton()){
            m_solenoid.armOff();
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_solenoid.clawPushOff();
    }
}
