package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.paths.DriveTrainConfig;
import frc.robot.commands.paths.FullStopPiece;
import frc.robot.commands.paths.MultiPartPath;
import frc.robot.subsystems.DriveTrainSubsystem;

public class ExamplePathAuto extends AutoWithInit{

    DriveTrainSubsystem driveTrain;
    
    public ExamplePathAuto(DriveTrainSubsystem driveTrain){
        this.driveTrain = driveTrain;
        
    }
    @Override
    public void initializeCommands() {

        //driveTrain.resetSwerve();

        driveTrain.resetAngle();
        DriveTrainConfig config = driveTrain.getConfig().makeClone();
        config.maxVelocity = 4;
        config.maxAcceleration = 4;
        config.maxCentripetalAcceleration = 11;
        config.maxAngularAcceleration = 8;
        config.maxAnglularVelocity = 12;
        double halfWidth = 0.46355;
        driveTrain.setPose(7.1882+halfWidth, 1.343025+halfWidth, 0);
        driveTrain.setAngleOffset(-90);

        MultiPartPath pathA;

        pathA = new MultiPartPath(driveTrain, config, null);
        pathA.addSequentialCommand(new FullStopPiece(pathA, 1));//ENDPOS:7.741,2.029
        pathA.setHeading(-90);
        pathA.addWaypoint(7.669, 1.514);

        pathA.setHeading(-120);

        pathA.addWaypoint(7.130, 1.538);
        pathA.addStop();
        //pathA.addSequentialCommand(new TurnAndShoot(driveTrain, barrel, vision, 2000, true, true));//ENDPOS:7.034,1.562
             

    }

    
}