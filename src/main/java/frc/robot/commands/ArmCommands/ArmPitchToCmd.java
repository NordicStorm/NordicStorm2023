package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class ArmPitchToCmd extends InstantCommand{
    
    private final double pos;

    public ArmPitchToCmd(double pos){
        this.pos = pos;
        this.addRequirements(RobotContainer.armSubsystem);
    }

    @Override
    public void execute(){
        RobotContainer.armSubsystem.MovePitch(pos);
    }

}
