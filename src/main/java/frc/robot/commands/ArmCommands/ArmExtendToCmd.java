package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class ArmExtendToCmd extends InstantCommand{



    private final double pos;

    public ArmExtendToCmd(double pos){
        this.pos = pos;
        this.addRequirements(RobotContainer.armSubsystem);
    }

    @Override
    public void execute(){
        RobotContainer.armSubsystem.MoveExtension(pos);
    }



}
