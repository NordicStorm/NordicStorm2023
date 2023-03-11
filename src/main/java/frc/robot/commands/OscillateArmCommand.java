package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class OscillateArmCommand extends CommandBase{
    private ArmSubsystem armSubsystem;

    public OscillateArmCommand(ArmSubsystem subsystem){
        this.armSubsystem = subsystem;

        this.addRequirements(subsystem);
    }

    @Override
    public void execute(){
        double currentPos = ArmSubsystem.ArmExtensionMotor.getEncoder().getPosition();
    
        if (Math.abs(currentPos - ArmSubsystem.inPos) < 0.5) {
            armSubsystem.MoveExtension(ArmSubsystem.outPos);
        } else if (Math.abs(currentPos - ArmSubsystem.outPos) < 0.5) {
            armSubsystem.MoveExtension(ArmSubsystem.inPos);
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
