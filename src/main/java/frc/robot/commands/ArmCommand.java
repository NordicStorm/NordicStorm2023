package frc.robot.commands;

import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;

public class ArmCommand extends CommandBase{
    
    private ArmSubsystem armSubsystem;
    private double pos;

    public ArmCommand(ArmSubsystem subsystem, double pos){
        this.armSubsystem = subsystem;
        this.pos = pos;

        this.addRequirements(subsystem);
    }

    @Override
    public void execute(){
        armSubsystem.MoveExtension(pos);
        // armSubsystem.MoveExtension(RobotContainer.leftJoystick.getY());
        // armSubsystem.MovePitch(RobotContainer.leftJoystick.getX());      
    }

    @Override
    public void end(boolean graceful){
        // armSubsystem.MoveExtension(0);
        // armSubsystem.MovePitch(0);
    }
}
