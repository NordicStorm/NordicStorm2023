package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;

public class OscillateArmCommand extends CommandBase{
    public OscillateArmCommand(){
        this.addRequirements(RobotContainer.armSubsystem);
    }

    @Override
    public void execute(){
        double currentPos = ArmSubsystem.ArmExtensionMotor.getEncoder().getPosition();
    
        if (currentPos == 0 || Math.abs(currentPos - ArmSubsystem.inPos) < 0.5) {
            RobotContainer.armSubsystem.MoveExtension(ArmSubsystem.outPos);
        } else if (Math.abs(currentPos - ArmSubsystem.outPos) < 0.5) {
            RobotContainer.armSubsystem.MoveExtension(ArmSubsystem.inPos);
        }
        // armSubsystem.MoveExtension(RobotContainer.leftJoystick.getY());
        // armSubsystem.MovePitch(RobotContainer.leftJoystick.getX());      
    }

    @Override
    public void end(boolean graceful){
        // armSubsystem.MoveExtension(0);
        // armSubsystem.MovePitch(0);
    }
}
