package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class IntakeTestCmd extends CommandBase{
    
    public IntakeTestCmd(){
        this.addRequirements(RobotContainer.intakeSubsystem);


    }

    @Override
    public void execute(){
        double speed = RobotContainer.leftJoystick.getY();

        RobotContainer.intakeSubsystem.setIntakeBeltMotorSpeed(speed);
        SmartDashboard.putNumber("Intake speed", speed);
    }

    @Override
    public void end(boolean graceful){
        RobotContainer.intakeSubsystem.setIntakeBeltMotorSpeed(0);
    }

}
