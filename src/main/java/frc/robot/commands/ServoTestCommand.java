package frc.robot.commands;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.PWM.PeriodMultiplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ServoTestCommand extends CommandBase{
    
private static Servo servoPitch = new Servo(0);
private static Servo servoYaw = new Servo(1);

public ServoTestCommand(){
    servoPitch.setBounds(2.5, 0, 0, 0, 0.5);
    servoPitch.setPeriodMultiplier(PeriodMultiplier.k1X);

    servoYaw.setBounds(2.5, 0, 0, 0, 0.5);
    servoYaw.setPeriodMultiplier(PeriodMultiplier.k1X);
}

    @Override
    public void execute(){

        double percentX = (RobotContainer.leftJoystick.getX() + 1) / 2.0;
        double percentY = (RobotContainer.leftJoystick.getY() + 1) / 2.0;

        servoPitch.setPosition(percentX);
        servoYaw.setPosition(percentY);

    }

}
