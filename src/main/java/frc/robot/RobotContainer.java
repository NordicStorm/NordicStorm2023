// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutoWithInit;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ExamplePathAuto;
import frc.robot.commands.FollowBall;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.IntakeTestCmd;
import frc.robot.commands.OperatorControl;
import frc.robot.commands.OscillateArmCommand;
import frc.robot.commands.ServoTestCommand;
import frc.robot.commands.ArmCommands.ArmExtendToCmd;
import frc.robot.commands.ArmCommands.ArmOperatorControl;
import frc.robot.commands.ArmCommands.ArmPitchCommand;
import frc.robot.commands.TRexArms.TRexArmsUpCommand;
import frc.robot.commands.VacuumCommands.VacuumDefaultCommand;
import frc.robot.commands.VacuumCommands.VacuumManualControlCommand;
import frc.robot.commands.auto.StraightAuto;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.Pixy;
import frc.robot.subsystems.TimeOfFlightSubsystem;
import frc.robot.subsystems.VacuumSubsystem;
import frc.robot.subsystems.VisionSubsystem;

import java.util.function.BooleanSupplier;

import com.kauailabs.navx.frc.AHRS;
import com.playingwithfusion.TimeOfFlight;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RepeatCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static final Joystick leftJoystick = new Joystick(1);
  public static final Joystick rightJoystick = new Joystick(0);

  public static boolean isRed;
  public static double AllianceAngleDeg;
  
  public static double AllianceAngleRad;

  public static DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
  public static Pixy pixyController = new Pixy();

  public static VacuumSubsystem vacuumSubsystem = new VacuumSubsystem();

  public static ArmSubsystem armSubsystem = new ArmSubsystem();

  public static TimeOfFlightSubsystem timeOfFlightSubsystem = new TimeOfFlightSubsystem();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  public static VisionSubsystem visionSubsystem = new VisionSubsystem();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    VacuumSubsystem.initalizePcm();
    ArmSubsystem.InitalizeArmSubsystem();
    SmartDashboard.putNumber("Vacuum Speed", 0.30);
    SmartDashboard.putBoolean("DriveOntoRamp", true);
    SmartDashboard.putNumber("Intake Belt Speed", 0.5);
    SmartDashboard.putNumber("Intake Wheel Speed", 0.3);

    //CommandScheduler.getInstance().setDefaultCommand(driveTrain, new OperatorControl());
    driveTrain.setDefaultCommand(new OperatorControl());
    vacuumSubsystem.setDefaultCommand(new VacuumDefaultCommand(vacuumSubsystem));
    isRed = DriverStation.getAlliance() == Alliance.Red;
    AllianceAngleDeg = isRed ? 180 : 0;
    AllianceAngleRad = Units.degreesToRadians(AllianceAngleDeg);
    SmartDashboard.putNumber("Alliance Angle", AllianceAngleDeg);
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is
    // pressed,
    // cancelling on release.

    new JoystickButton(rightJoystick, 4).whileTrue(
          new ParallelCommandGroup(new RepeatCommand(new FollowBall(false, false, 3, 1, 3, false, 300)), new IntakeCommand(-1.0, 0.1)));
    
    
        new JoystickButton(rightJoystick, 3)
        .whileTrue(
          new ParallelCommandGroup(new RepeatCommand(new FollowBall(false, false, 3, 2, 3, false, 300)), new IntakeCommand(-1.0, 0.1)));


          //Reset gyro
    new JoystickButton(rightJoystick, 8).onTrue(new InstantCommand() {
      @Override
      public void execute(){
        driveTrain.zeroGyroscope();
      }
    });

   // new JoystickButton(leftJoystick, 1).whileTrue(new VacuumManualControlCommand(vacuumSubsystem));

    new JoystickButton(leftJoystick, 7).toggleOnTrue(new ArmOperatorControl());
    new JoystickButton(leftJoystick, 9).whileTrue(new VacuumManualControlCommand(RobotContainer.vacuumSubsystem));

    // new JoystickButton(leftJoystick, 4).whileFalse(new OscillateArmCommand(armSubsystem));
    //new JoystickButton(leftJoystick, 4).whileTrue(new OscillateArmCommand());
    new JoystickButton(leftJoystick, 10).whileTrue(new ArmExtendToCmd(ArmSubsystem.inPos));
    new JoystickButton(leftJoystick, 5).whileTrue(new ArmExtendToCmd(ArmSubsystem.outPos));
    // new JoystickButton(leftJoystick, 5).whileTrue(new ArmCommand(armSubsystem, ArmSubsystem.outPos));
    // new JoystickButton(leftJoystick, 5).whileTrue(new ServoTestCommand());
    new JoystickButton(leftJoystick, 4).whileTrue(new IntakeTestCmd());
    new JoystickButton(leftJoystick, 6).toggleOnTrue(new IntakeCommand(-1.0, 0.1));
    new JoystickButton(rightJoystick, 9).whileTrue(new TRexArmsUpCommand(0.3));
    
    //Reverse
    new JoystickButton(rightJoystick, 2).whileTrue(new IntakeCommand(1, -0.1));
  
    new JoystickButton(rightJoystick, 7).toggleOnTrue(new CommandBase() {
      @Override
      public void execute(){
        intakeSubsystem.setIntakeServo(1);
      }

      @Override
      public void end(boolean graceful){
        intakeSubsystem.setIntakeServo(0);
      }
    });

    new JoystickButton(leftJoystick, 7).toggleOnTrue(new CommandBase() {
      @Override
      public void execute(){
        intakeSubsystem.setIntakeServo(1);
      }

      @Override
      public void end(boolean graceful){
        intakeSubsystem.setIntakeServo(0);
      }
    });

    new JoystickButton(rightJoystick, 10).onTrue(new InstantCommand(() -> armSubsystem.MoveExtension(-1), armSubsystem).andThen(new WaitCommand(0.3)).andThen(new InstantCommand(() -> {
      armSubsystem.zeroExtensionEncoder();
      armSubsystem.MoveExtension(0);
    })));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    AutoWithInit auto = new StraightAuto();//new ExamplePathAuto(driveTrain);
    auto.initializeCommands();

    return auto;
  }
}
