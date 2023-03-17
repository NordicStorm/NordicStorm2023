package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Util;
import frc.robot.commands.paths.CommandPathPiece;

public class theuhh extends CommandBase implements CommandPathPiece {

    
    long endingTime;


    @Override
    public void initialize(){

        endingTime = System.currentTimeMillis() + 8000;
        RobotContainer.driveTrain.drive(-0.35, 0.000,0);
    }

    boolean hasGone = false;

    @Override
    public void execute(){
        if(Math.abs(RobotContainer.driveTrain.getGyroPitch()) > 5 && Math.abs(RobotContainer.driveTrain.getGyroPitch()) < 50.0) {
            hasGone = true;
            RobotContainer.driveTrain.drive(RobotContainer.driveTrain.getGyroPitch() * -0.03, 0.000, 0);
        }
        else if(hasGone)
            RobotContainer.driveTrain.drive(0,0,0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    
    @Override
    public double getRequestedStartSpeed() {
        return 1.0;
    }

}
