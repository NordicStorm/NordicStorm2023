package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveForTime extends CommandBase {


    double xSpeed;
    long time;
    long timeToStop;
    DriveForTime(double xSpeed, long time){
        this.xSpeed = xSpeed;
        this.time = time;
    }
    
    @Override
    public void initialize() {
        timeToStop = System.currentTimeMillis()+time;
    }

    @Override
    public void execute() {
        RobotContainer.driveTrain.drive(xSpeed, 0, 0);
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() > timeToStop;
    }
    @Override
    public void end(boolean interrupted) {

    }

}
