package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ArmPitchCommand extends CommandBase {
    public ArmPitchCommand() {
        this.addRequirements(RobotContainer.armSubsystem);
    }

    @Override
    public void execute() {
        // RobotContainer.armSubsystem.MoveExtension(pos);
        // armSubsystem.MoveExtension(RobotContainer.leftJoystick.getY());
        RobotContainer.armSubsystem.MovePitch(RobotContainer.leftJoystick.getY());
    }

    @Override
    public void end(boolean graceful) {
        // armSubsystem.MoveExtension(0);
        // RobotContainer.armSubsystem.MovePitch(0);
    }
}
