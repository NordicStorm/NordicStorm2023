package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class VacuumSubsystem extends SubsystemBase {

    private static final AnalogInput VacuumSensor = new AnalogInput(0);
    private static final CANSparkMax VacuumMotor = new CANSparkMax(Constants.VacuumMotorId, MotorType.kBrushless);
    private static PneumaticsControlModule pControlModule = new PneumaticsControlModule(19);

    private static Solenoid vacuumRepressurizationSolenoid;

    private boolean isVacuumRunning = false;

    public VacuumSubsystem() {

    }

    public static void initalizePcm() {
        vacuumRepressurizationSolenoid = pControlModule.makeSolenoid(0);
    }

    public void startVacuum() {
        if (!isVacuumRunning) {
            VacuumMotor.set(SmartDashboard.getNumber("Vacuum Speed", 0.30));
            isVacuumRunning = true;
        }
    }

    public void stopVacuum() {
        if (isVacuumRunning) {
            VacuumMotor.set(0);
            isVacuumRunning = false;
        }
    }

    public void openServo() {
        vacuumRepressurizationSolenoid.set(false);
    }

    public void closeServo() {
        vacuumRepressurizationSolenoid.set(true);
    }

    public double getVacuumPercentage() {
        return Math.abs((VacuumSensor.getVoltage() - 1.0) / 4.0f);
    }
    public double getVacuumVoltage(){
        return VacuumSensor.getVoltage();
    }

}
