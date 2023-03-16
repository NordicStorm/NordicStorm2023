package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    
    private static CANSparkMax IntakeMotor = new CANSparkMax(15, MotorType.kBrushless);

    public IntakeSubsystem(){
        
    }

    public void setIntakeMotorSpeed(double speed){
        IntakeMotor.set(speed);
    }

}
