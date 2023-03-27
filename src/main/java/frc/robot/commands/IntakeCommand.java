package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class IntakeCommand extends CommandBase {

    private double beltSpeed;
    private double wheelSpeed;

    public IntakeCommand(double beltSpeed, double wheelSpeed) {
        this.addRequirements(RobotContainer.intakeSubsystem);
        this.beltSpeed = beltSpeed;
        this.wheelSpeed = wheelSpeed;
    }

    @Override
    public void execute() {
        RobotContainer.intakeSubsystem.setIntakeBeltMotorSpeed(beltSpeed);
        RobotContainer.intakeSubsystem.setIntakeWheelMotorSpeeds(wheelSpeed);
    }

    @Override
    public void end(boolean graceful) {
        RobotContainer.intakeSubsystem.setIntakeBeltMotorSpeed(0);
        RobotContainer.intakeSubsystem.setIntakeWheelMotorSpeeds(0);
    }
}
