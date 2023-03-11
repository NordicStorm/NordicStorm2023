// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.AutoWithInit;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ExamplePathAuto;
import frc.robot.commands.FollowBall;
import frc.robot.commands.OperatorControl;
import frc.robot.commands.OscillateArmCommand;
import frc.robot.commands.ServoTestCommand;
import frc.robot.commands.VacuumCommands.VacuumDefaultCommand;
import frc.robot.commands.VacuumCommands.VacuumManualControlCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Pixy;
import frc.robot.subsystems.VacuumSubsystem;

import com.kauailabs.navx.frc.AHRS;
import com.playingwithfusion.TimeOfFlight;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RepeatCommand;
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

  public static TimeOfFlight timeOfFlight = new TimeOfFlight(24);
  public static TimeOfFlight timeOfFlight2 = new TimeOfFlight(23);

  public static DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
  public static Pixy pixyController = new Pixy();

  public static VacuumSubsystem vacuumSubsystem = new VacuumSubsystem();

  public static ArmSubsystem armSubsystem = new ArmSubsystem();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    VacuumSubsystem.initalizePcm();
    ArmSubsystem.InitalizeArmSubsystem();
    SmartDashboard.putNumber("Vacuum Speed", 0.30);
    //CommandScheduler.getInstance().setDefaultCommand(driveTrain, new OperatorControl());
    driveTrain.setDefaultCommand(new OperatorControl());
    vacuumSubsystem.setDefaultCommand(new VacuumDefaultCommand(vacuumSubsystem));
    
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

    new JoystickButton(leftJoystick, 2).and(new JoystickButton(leftJoystick, 1))
        .whileTrue(new RepeatCommand(new FollowBall(false, false, 3, 1, 3, false, 300)));
    new JoystickButton(leftJoystick, 2).and(new JoystickButton(leftJoystick, 1).negate())
        .whileTrue(new RepeatCommand(new FollowBall(false, false, 3, 2, 3, false, 300)));
    new JoystickButton(leftJoystick, 3).and(new JoystickButton(leftJoystick, 1))
        .whileTrue(new VacuumManualControlCommand(vacuumSubsystem));
    // new JoystickButton(leftJoystick, 3).whileTrue(new ArmCommand(armSubsystem));
    new JoystickButton(leftJoystick, 4).whileFalse(new OscillateArmCommand(armSubsystem));
    // new JoystickButton(leftJoystick, 4).whileTrue(new OscillateArmCommand(armSubsystem));
    // new JoystickButton(leftJoystick, 4).whileTrue(new ArmCommand(armSubsystem, ArmSubsystem.inPos));
    // new JoystickButton(leftJoystick, 5).whileTrue(new ArmCommand(armSubsystem, ArmSubsystem.outPos));
    // new JoystickButton(leftJoystick, 5).whileTrue(new ServoTestCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    AutoWithInit auto = new ExamplePathAuto(driveTrain);
    auto.initializeCommands();
    return auto;
  }
}
