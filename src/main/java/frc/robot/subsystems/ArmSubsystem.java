package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {

    private static CANSparkMax ArmPitchMotor = new CANSparkMax(Constants.ArmPitchMotorId, MotorType.kBrushless);
    private static CANSparkMax ArmExtensionMotor = new CANSparkMax(Constants.ArmExtensionMotorId, MotorType.kBrushless);

    public ArmSubsystem() {
       ArmPitchMotor.setIdleMode(IdleMode.kBrake);
       ArmExtensionMotor.setIdleMode(IdleMode.kBrake);
    }

    public void MoveExtension(double amount){
        ArmExtensionMotor.set(amount);
       
    }

    public void MovePitch(double amnt){
        ArmPitchMotor.set(amnt);
    }


}
