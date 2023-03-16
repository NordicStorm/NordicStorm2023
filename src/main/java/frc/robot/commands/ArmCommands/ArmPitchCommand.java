package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;

public class ArmPitchCommand extends CommandBase {
    public ArmPitchCommand() {
        this.addRequirements(RobotContainer.armSubsystem);
    }

    @Override
    public void execute() {
        // RobotContainer.armSubsystem.MoveExtension(pos);
        // armSubsystem.MoveExtension(RobotContainer.leftJoystick.getY());
        double throttle = ((-RobotContainer.leftJoystick.getZ() + 1) / 2);
        RobotContainer.armSubsystem.MovePitch(RobotContainer.leftJoystick.getY() * throttle);
        SmartDashboard.putNumber("Pitch Throttle", throttle);
    }

    @Override
    public void end(boolean graceful) {
        // armSubsystem.MoveExtension(0);
        RobotContainer.armSubsystem.MovePitch(0);
        // RobotContainer.armSubsystem.MovePitch(0);
    }
}
