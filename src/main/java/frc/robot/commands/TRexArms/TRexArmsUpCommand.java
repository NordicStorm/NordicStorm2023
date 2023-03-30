package frc.robot.commands.TRexArms;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class TRexArmsUpCommand extends CommandBase {

    private final double speed;

    public TRexArmsUpCommand(double speed) {
        this.speed = speed;
        this.addRequirements(RobotContainer.armSubsystem);
    }

    @Override
    public void execute() {
        double joystickshit = RobotContainer.leftJoystick.getY() * 0.5;
        RobotContainer.intakeSubsystem.setTRexArmLeftSpeed(-joystickshit);
        RobotContainer.intakeSubsystem.setTRexArmRightSpeed(joystickshit);
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.intakeSubsystem.setTRexArmLeftSpeed(0);
        RobotContainer.intakeSubsystem.setTRexArmRightSpeed(0);
    }
}
