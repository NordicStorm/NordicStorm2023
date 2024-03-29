// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final int ArmPitchMotorId = 14;
  public static final int ArmExtensionMotorId = 18;

  public static final int VacuumMotorId = 10;

  //Servo ids
  public static final int ArmHandRollServoId = 0;
  public static final int ArmHandPitchServoId = 1;
  public static final int IntakeActuator = 2;

  //change this once we know motor ids!!!!
  public static final int IntakeWheelRMotorId = 15;
  public static final int IntakeWheelLMotorId = 20;

  public static final int IntakeBeltMotorId= 13;

  //Edit these to proper values
  public static final double ArmExtendOutPos = 45;
  public static final double ArmExtendInPos = 5;

  //Edit these to proper values
  public static final double ArmPitchOutPos = 1234;
  public static final double ArmPitchNominalPos = 1234;


  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final double DRIVETRAIN_TRACKWIDTH_METERS = 0.5715;
  public static final double DRIVETRAIN_WHEELBASE_METERS = 0.5715;
  //0.5207
  /*
  1--/\--4
  |      |
  |      |
  2------3
  */
  public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 5;
  public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 6;
  public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 3;
  public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(177.7972412109375+180);

  public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 3;
  public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 4;
  public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 2;
  public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(329.1953125+180);

  public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 7;
  public static final int BACK_LEFT_MODULE_STEER_MOTOR = 8;
  public static final int BACK_LEFT_MODULE_STEER_ENCODER = 4;
  public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(257.16522216796875+180);

  public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 1;
  public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 2;
  public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 1;
  public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(294.43359375+180);
}
