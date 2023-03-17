package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.paths.DriveTrainConfig;
import frc.robot.commands.paths.FullStopPiece;
import frc.robot.commands.paths.MultiPartPath;
import frc.robot.subsystems.DriveTrainSubsystem;

public class ExamplePathAuto extends AutoWithInit {

    DriveTrainSubsystem driveTrain;

    public ExamplePathAuto(DriveTrainSubsystem driveTrain) {
        this.driveTrain = driveTrain;

    }

    @Override
    public void initializeCommands() {
        // !PATHWEAVER_INFO: {"trackWidth":0.9271,"gameName":"Charged
        // Up","outputDir":"C:\\Users\\Nordic Storm
        // 3018\\FRC\\NordicStorm2023\\NordicStorm2023\\src\\main\\java\\frc\\robot\\commands\\ExamplePathAuto.java"}

        boolean goOntoRamp = SmartDashboard.getBoolean("DriveOntoRamp", true);

        // driveTrain.resetSwerve();

        driveTrain.resetAngle();
        DriveTrainConfig config = driveTrain.getConfig().makeClone();
        config.maxVelocity = 2;
        config.maxAcceleration = 2;
        config.maxCentripetalAcceleration = 11;
        config.maxAngularAcceleration = 8;
        config.maxAnglularVelocity = 12;
        double halfWidth = 0.46355;
        driveTrain.setAngleOffset(180);

        MultiPartPath pathA;
        driveTrain.setPose(5.005, 0.733, 0);
        pathA = new MultiPartPath(driveTrain, config, null);
        pathA.addSequentialCommand(new FullStopPiece(pathA, 1));//ENDPOS:4.921,0.754
        pathA.setHeading(180);
        
        
        if (goOntoRamp) {//path off
            pathA.addWaypoint(6.104, 1.621);
            pathA.addWaypoint(5.660, 2.826);
            pathA.addStop();
            pathA.changeMaxVelocity(1.5);
            pathA.addSequentialCommand(new theuhh());//ENDPOS:3.885,2.741
        } else {//path on
            pathA.addWaypoint(5.660, 2.826);
        }
        pathA.addStop();
        addCommands(pathA.finalizePath());
    }

}