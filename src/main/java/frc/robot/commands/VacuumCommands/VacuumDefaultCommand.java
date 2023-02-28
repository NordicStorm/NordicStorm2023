package frc.robot.commands.VacuumCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.VacuumSubsystem;

public class VacuumDefaultCommand extends CommandBase{
    
    private VacuumSubsystem vacuumSubsystem;

    public VacuumDefaultCommand(VacuumSubsystem vacuumSubsystem){

        this.vacuumSubsystem = vacuumSubsystem;
        this.addRequirements(vacuumSubsystem);
    }

    @Override
    public void execute(){
        SmartDashboard.putNumber("Vacuum Percentage", vacuumSubsystem.getVacuumPercentage());
        SmartDashboard.putNumber("Vacuum Voltage", vacuumSubsystem.getVacuumVoltage());
        
    }
}
