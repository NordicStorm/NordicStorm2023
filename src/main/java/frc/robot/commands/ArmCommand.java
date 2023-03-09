package frc.robot.commands;

import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;

public class ArmCommand extends CommandBase{
    
    private ArmSubsystem armSubsystem;

    public ArmCommand(ArmSubsystem subsystem){
        this.armSubsystem = subsystem;

        this.addRequirements(subsystem);
    }

    @Override
    public void execute(){
        armSubsystem.MoveExtension(RobotContainer.leftJoystick.getY());
        armSubsystem.MovePitch(RobotContainer.leftJoystick.getX());      
    }

    @Override
    public void end(boolean graceful){
        armSubsystem.MoveExtension(0);
        armSubsystem.MovePitch(0);
    }
}
