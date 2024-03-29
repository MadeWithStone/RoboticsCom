/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Compressor;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  //PWM


  //DIO

  //CAN
  public static int leftMasterPort = 2;
  public static int leftSlavePort = 3;
  public static int leftMiddlePort = 8;
  public static int rightMasterPort = 0;
  public static int rightSlavePort = 1;
  public static int rightMiddlePort = 7;
  public static int servoPort = 5;
  public static int motorSwitch = 7;
  public static int potServ = 0;

  // Compressor
  public static final int COMPRESSOR_CAN_ID = 0;
  public static Compressor compressor = new Compressor(COMPRESSOR_CAN_ID);

  // Solenoid
  public static int solenoid1 = 5;
  public static int solenoid2 = 4;

  //USB
  public static int joystickPort = 0;

  //Other Drivetrain Constants
  public static int wheelDiameter = 6;
}
