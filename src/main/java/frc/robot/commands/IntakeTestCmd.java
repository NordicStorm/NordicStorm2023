package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class IntakeTestCmd extends CommandBase{
    
    public IntakeTestCmd(){
        this.addRequirements(RobotContainer.intakeSubsystem);


    }

    @Override
    public void execute(){
        RobotContainer.intakeSubsystem.setIntakeMotorSpeed(RobotContainer.leftJoystick.getY());
    }

    @Override
    public void end(boolean graceful){
        RobotContainer.intakeSubsystem.setIntakeMotorSpeed(0);
    }

}
