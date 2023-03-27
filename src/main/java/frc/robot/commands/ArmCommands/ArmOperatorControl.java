package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj.event.EventLoop;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;
import frc.robot.Util;
import frc.robot.subsystems.ArmSubsystem;

public class ArmOperatorControl extends CommandBase {

    public ArmOperatorControl() {
        this.addRequirements(RobotContainer.armSubsystem);
    }

    @Override
    public void execute() {
        // RobotContainer.armSubsystem.MoveExtension(pos);

        if (RobotContainer.leftJoystick.getTrigger()) {

            RobotContainer.armSubsystem.MoveHandPitchRelativeAngle(RobotContainer.leftJoystick.getY() * 0.1);
            RobotContainer.armSubsystem.MoveHandRollRelativeAngle(RobotContainer.leftJoystick.getX() * 0.1);
            return;
        }
        RobotContainer.armSubsystem
                .MoveExtension(Util.lerp(4, 30, Util.clamp(RobotContainer.leftJoystick.getY(), 0, 1)));
        // armSubsystem.MovePitch(RobotContainer.leftJoystick.getX());
        double throttle = ((-RobotContainer.leftJoystick.getZ() + 1) / 2);
        RobotContainer.armSubsystem.MovePitch(Util.lerp(0, 200, Util.clamp(RobotContainer.leftJoystick.getX(), 0, 1)));
        SmartDashboard.putNumber("Pitch Throttle", throttle);

    }

    @Override
    public void end(boolean graceful) {
        RobotContainer.armSubsystem.MoveExtension(4);
        RobotContainer.armSubsystem.MovePitch(0);
        RobotContainer.armSubsystem.MoveHandPitchAbs(0.5);
        RobotContainer.armSubsystem.MoveHandRollAbs(0.5);
    }
}
