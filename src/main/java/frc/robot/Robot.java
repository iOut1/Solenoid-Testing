package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Commands.SolenoidCommand;
import frc.robot.Subsystems.SolenoidSystem;

public class Robot extends TimedRobot {
    private SolenoidSystem m_solenoid = new SolenoidSystem();
    private XboxController m_controller = new XboxController(0);

    @Override
    public void robotInit() {
        m_solenoid.initialize();

        m_solenoid.setDefaultCommand(
            new SolenoidCommand(m_solenoid, m_controller)
        );
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
}
