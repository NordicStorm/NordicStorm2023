package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    private static CANSparkMax IntakeBeltMotor = new CANSparkMax(Constants.IntakeBeltMotorId, MotorType.kBrushless);

    private static CANSparkMax IntakeWheelMotorL = new CANSparkMax(Constants.IntakeWheelLMotorId, MotorType.kBrushless);
    private static CANSparkMax IntakeWheelMotorR = new CANSparkMax(Constants.IntakeWheelRMotorId, MotorType.kBrushless);

    private static CANSparkMax IntakeTRexArmMotorR = new CANSparkMax(23, MotorType.kBrushed);
    private static CANSparkMax IntakeTRexArmMotorL = new CANSparkMax(16, MotorType.kBrushed);

    private static Servo IntakeActuatorServo = new Servo(Constants.IntakeActuator);

    public IntakeSubsystem() {
        setIntakeServo(0); // initialize up
    }


    public void setIntakeServo(double d){
        IntakeActuatorServo.set(d);
    }

    public void setIntakeBeltMotorSpeed(double speed) {
        IntakeBeltMotor.set(speed);
    }

    public void setIntakeWheelMotorSpeeds(double speed) {
        IntakeWheelMotorL.set(speed);
        IntakeWheelMotorR.set(-speed);
    }

    public void setIntakeWheelMotorSpeedL(double speed) {
        IntakeWheelMotorL.set(speed);
    }

    public void setIntakeWheelMotorSpeedR(double speed) {
        IntakeWheelMotorR.set(speed);
    }

    public void setTRexArmLeftSpeed(double speed) {
        IntakeTRexArmMotorL.set(speed);
    }

    public void setTRexArmRightSpeed(double speed) {
        IntakeTRexArmMotorR.set(speed);
    }
}
