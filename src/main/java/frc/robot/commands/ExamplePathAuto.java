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
// !PATHWEAVER_INFO: {"trackWidth":0.9271,"gameName":"Charged Up","outputDir":"C:\\Users\\Nordic Storm 3018\\FRC\\NordicStorm2023\\NordicStorm2023\\src\\main\\java\\frc\\robot\\commands\\ExamplePathAuto.java"}

        //driveTrain.resetSwerve();

        driveTrain.resetAngle();
        DriveTrainConfig config = driveTrain.getConfig().makeClone();
        config.maxVelocity = 4;
        config.maxAcceleration = 4;
        config.maxCentripetalAcceleration = 11;
        config.maxAngularAcceleration = 8;
        config.maxAnglularVelocity = 12;
        double halfWidth = 0.46355;
        driveTrain.setAngleOffset(180);

        MultiPartPath pathA;
        driveTrain.setPose(14.678+halfWidth, 4.393+halfWidth, 0);
        pathA = new MultiPartPath(driveTrain, config, null);
        pathA.addSequentialCommand(new FullStopPiece(pathA, 1));//ENDPOS:14.772,4.393
        pathA.setHeading(180);
        pathA.addWaypoint(14.363, 5.873);
        pathA.addWaypoint(11.246, 6.833);
        pathA.addWaypoint(10.978, 5.401);
        pathA.changeMaxVelocity(1);
        pathA.addStop();
        pathA.addWaypoint(10.553, 3.779);
        pathA.addWaypoint(15.386, 4.141);
        pathA.addStop();
        addCommands(pathA.finalizePath());


    }

    
}