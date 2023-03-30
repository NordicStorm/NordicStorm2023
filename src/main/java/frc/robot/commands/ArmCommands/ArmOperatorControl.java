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

    private double targetPos = 0.5;

    @Override
    public void execute() {
        // RobotContainer.armSubsystem.MoveExtension(pos);

        if (RobotContainer.leftJoystick.getTrigger()) {

            RobotContainer.armSubsystem.MoveHandPitchAbs((RobotContainer.leftJoystick.getY() + 1) / 2);
            RobotContainer.armSubsystem.MoveHandRollAbs((RobotContainer.leftJoystick.getX() + 1) / 2);
            return;
        }
        RobotContainer.armSubsystem
                .MoveExtension(Util.lerp(0, 36, Util.clamp(RobotContainer.leftJoystick.getY(), 0, 1)));
        // armSubsystem.MovePitch(RobotContainer.leftJoystick.getX());
        double throttle =RobotContainer.leftJoystick.getX();
       
        if(Math.abs(throttle) < 0.01)
        throttle = 0;

        targetPos += throttle * 0.003;
        targetPos = Util.clamp(targetPos, 0.24, 0.6);
        SmartDashboard.putNumber("Target Pos", targetPos);
       RobotContainer.armSubsystem.MovePitch(targetPos);
        SmartDashboard.putNumber("Pitch Throttle", throttle);

    }

    @Override
    public void end(boolean graceful) {
        //RobotContainer.armSubsystem.MoveExtension(0);
        //RobotContainer.armSubsystem.MovePitch(0);
       // RobotContainer.armSubsystem.MoveHandPitchAbs(0.5);
        //RobotContainer.armSubsystem.MoveHandRollAbs(0.5);
    }
}
