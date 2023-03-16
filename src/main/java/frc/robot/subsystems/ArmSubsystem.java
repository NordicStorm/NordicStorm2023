package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.REVLibError;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {

    public static CANSparkMax ArmPitchMotor = new CANSparkMax(Constants.ArmPitchMotorId, MotorType.kBrushless);
    public static CANSparkMax ArmExtensionMotor = new CANSparkMax(Constants.ArmExtensionMotorId, MotorType.kBrushless);

    public static double minPos = 5;
    public static double maxPos = 52;
    public final static double inPos = 5;
    public final static double outPos = 52;
    public static double count = 0;
    public static double kP, kI, kD, kIz, kFF, kSpeed, mAcc, mVel;


    public ArmSubsystem() {
       // ArmExtensionMotor.getPIDController().setOutputRange(-0.1, 0.1);
        // var extensionPIDController = ArmExtensionMotor.getPIDController();
       // ArmExtensionMotor.disableVoltageCompensation();

    }

    public static void InitalizeArmSubsystem(){
        kP = 0.5; 
        kI = 0.5;
        kD = 0; 
        kIz = 0;
        kFF = 0.0;
        kSpeed = 0.05;
        mAcc = 10;
        mVel = 10;

        ArmPitchMotor.setIdleMode(IdleMode.kBrake);
        

        SmartDashboard.putNumber("kP", kP);
        SmartDashboard.putNumber("kI", kI);
        SmartDashboard.putNumber("kD", kD);
        SmartDashboard.putNumber("kIz", kIz);
        SmartDashboard.putNumber("kFF", kFF);
        SmartDashboard.putNumber("kSpeed", kSpeed);

        var m_pidController = ArmExtensionMotor.getPIDController();

        // m_pidController.setP(kP);
        // m_pidController.setI(kI);
        // m_pidController.setD(kD);
        // m_pidController.setIZone(kIz);
        // m_pidController.setFF(kFF);
        m_pidController.setP(kP, 0);
        m_pidController.setI(kI, 0);
        m_pidController.setD(kD, 0);
        m_pidController.setIZone(kIz, 0);
        m_pidController.setFF(kFF, 0);
        m_pidController.setOutputRange(-kSpeed, kSpeed, 0);
        // //m_pidController.setSmartMotionAccelStrategy(AccelStrategy.kTrapezoidal, 0);
        m_pidController.setSmartMotionMaxAccel(mAcc, 0);
        m_pidController.setSmartMotionMaxVelocity(200, 0);
        // m_pidController.setSmartMotionAllowedClosedLoopError(2, 0);
        // ArmExtensionMotor.burnFlash();



        //Yes this is intentional the pitch encoder is wired into the extension motor's controller /shrug
        //ArmPitchMotor.getPIDController().setFeedbackDevice(ArmExtensionMotor.getAbsoluteEncoder(Type.kDutyCycle));
        
        
        ArmPitchMotor.getPIDController().setOutputRange(-0.5, 0.5);
        
        //I have no idea what the numbers for this are yet
        ArmPitchMotor.setSoftLimit(SoftLimitDirection.kForward, 0);
        ArmPitchMotor.setSoftLimit(SoftLimitDirection.kReverse, 0.5f);
    }

    // public void MoveExtension(double amount) {
    public void MoveExtension(double pos) {
        ArmSubsystem.count++;
        //double p = SmartDashboard.getNumber("P Gain", 1);
 
        // double p = SmartDashboard.getNumber("kP", 0);
        // if(p != kP){
        //     ArmExtensionMotor.getPIDController().setP(p, 0);
        //     kP = p;
        // }
        // double i = SmartDashboard.getNumber("kI", 0);
        // if(i != kI){
        //     ArmExtensionMotor.getPIDController().setI(i, 0);
        //     kI = i;
        // }
        // double d = SmartDashboard.getNumber("kD", 0);
        // if(d != kD){
        //     ArmExtensionMotor.getPIDController().setD(d, 0);
        //     kD = d;
        // }
        // double iz = SmartDashboard.getNumber("kIz", 0);
        // if(iz != kIz){
        //     ArmExtensionMotor.getPIDController().setIZone(iz, 0);
        //     kIz = iz;
        // }
        // double ff = SmartDashboard.getNumber("kFF", 0);
        // if(ff != kFF){
        //     ArmExtensionMotor.getPIDController().setFF(ff, 0);
        //     kFF = ff;
        // }
        // double speed = SmartDashboard.getNumber("kSpeed", 0);
        // if(speed != kSpeed){
        //     ArmExtensionMotor.getPIDController().setOutputRange(-speed, speed, 0);
        //     kSpeed = speed;
        // }

        // amount = (amount + 1) / 2;

        SmartDashboard.putNumber("Target Position", pos);
        // REVLibError result = ArmExtensionMotor.getPIDController().setReference(pos, ControlType.kPosition);
        REVLibError result = ArmExtensionMotor.getPIDController().setReference(pos, ControlType.kSmartMotion, 0);
        SmartDashboard.putString("Motor Call Result", result.name());
        
        // double pos = Util.lerp(minPos,  maxPos, amount);
        // ArmExtensionMotor.getPIDController().setReference(ff, null, 0, speed)
        // double curPos = ArmExtensionMotor.getEncoder().getPosition();
        // SmartDashboard.putNumber("Current pos", curPos);
        //ArmExtensionMotor.getPIDController().
      // ArmExtensionMotor.getPIDController().
        /* 
        double pos = ArmExtensionMotor.getEncoder().getPosition();

        double end = ArmExtensionMotor
                .getSoftLimit(amount > 0 ? SoftLimitDirection.kForward : SoftLimitDirection.kReverse);

        double percentToEnd = pos / end;


        //percent of the way to start slowing down at
        double slowdownClamping = 0.70;

        double speed = amount;

        if (percentToEnd >= slowdownClamping) {
            //percentToEnd = Util.clamp(percentToEnd, slowdownClamping, 1.0);
            speed *= (1 / percentToEnd);
        }
        ArmExtensionMotor.set(speed);
*/
    }

    public void MovePitch(double amnt) {
        ArmPitchMotor.getPIDController().setReference(amnt, ControlType.kPosition);
    }

}
