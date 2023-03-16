package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class ArmExtensionCommand extends CommandBase{
    
    private double pos;

    public ArmExtensionCommand(double pos){
        this.pos = pos;

        this.addRequirements(RobotContainer.armSubsystem);
    }

    @Override
    public void execute(){
        RobotContainer.armSubsystem.MoveExtension(pos);
        // armSubsystem.MoveExtension(RobotContainer.leftJoystick.getY());
        // armSubsystem.MovePitch(RobotContainer.leftJoystick.getX());  
            
    }

    @Override
    public void end(boolean graceful){
        // armSubsystem.MoveExtension(0);
        // armSubsystem.MovePitch(0);
    }
}
