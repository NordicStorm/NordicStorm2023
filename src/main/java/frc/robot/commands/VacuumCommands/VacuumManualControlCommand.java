package frc.robot.commands.VacuumCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.VacuumSubsystem;

public class VacuumManualControlCommand extends CommandBase {

    private VacuumSubsystem vacuumSubsystem;

    public VacuumManualControlCommand(VacuumSubsystem vacuumSubsystem) {

        this.vacuumSubsystem = vacuumSubsystem;
        this.addRequirements(vacuumSubsystem);
    }

    @Override
    public void execute() {

        SmartDashboard.putNumber("Vacuum Percentage", vacuumSubsystem.getVacuumPercentage());
        SmartDashboard.putNumber("Vacuum Voltage", vacuumSubsystem.getVacuumVoltage());

        vacuumSubsystem.closeSolenoid();

        if (vacuumSubsystem.getVacuumPercentage() >= 1.0f) {
            vacuumSubsystem.stopVacuum();
            return;
        }

        vacuumSubsystem.startVacuum();
    }

    @Override
    public void end(boolean interrupted) {
        vacuumSubsystem.stopVacuum();
        vacuumSubsystem.openSolenoid();
    }

}
