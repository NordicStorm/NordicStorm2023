package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.AutoWithInit;
import frc.robot.commands.paths.DriveTrainConfig;
import frc.robot.commands.paths.FullStopPiece;
import frc.robot.commands.paths.MultiPartPath;
import frc.robot.subsystems.DriveTrainSubsystem;

public class StraightAuto extends AutoWithInit {


    public StraightAuto() {

    }

    @Override
    public void initializeCommands() {
        

        boolean goOntoRamp = SmartDashboard.getBoolean("DriveOntoRamp", true);
        RobotContainer.driveTrain.resetAngle();
        RobotContainer.driveTrain.setAngleOffset(180 + RobotContainer.AllianceAngleDeg);

        addCommands(new DropCube());
        addCommands(new DriveForTime(-1.5, 3000)); 
    }

}