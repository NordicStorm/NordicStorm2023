package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ArmCommand extends CommandBase{
    
    private double pos;

    public ArmCommand(double pos){
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
