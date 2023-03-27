package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase{
    
    private static CANSparkMax IntakeBeltMotor = new CANSparkMax(Constants.IntakeBeltMotorId, MotorType.kBrushless);

    private static CANSparkMax IntakeWheelMotorL = new CANSparkMax(Constants.IntakeWheelLMotorId, MotorType.kBrushless);
    private static CANSparkMax IntakeWheelMotorR = new CANSparkMax(Constants.IntakeWheelRMotorId, MotorType.kBrushless);

    private static Servo IntakeActuatorServo = new Servo(Constants.IntakeActuator);
    
    public IntakeSubsystem(){
        
    }

    public void setIntakeBeltMotorSpeed(double speed){
        IntakeBeltMotor.set(speed);
    }

    public void setIntakeWheelMotorSpeeds(double speed){
        IntakeWheelMotorL.set(speed);
        IntakeWheelMotorR.set(speed);
    }

    public void setIntakeWheelMotorSpeedL(double speed){
        IntakeWheelMotorL.set(speed);
    }
    
    public void setIntakeWheelMotorSpeedR(double speed){
        IntakeWheelMotorR.set(speed);
    }

}
