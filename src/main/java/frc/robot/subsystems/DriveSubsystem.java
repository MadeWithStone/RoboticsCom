/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManuallyCommand;
import edu.wpi.first.wpilibj.Servo;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // instantiate new motor controller objects
  public Spark leftMaster = new Spark(RobotMap.leftMasterPort);
  public Spark leftSlave = new Spark(RobotMap.leftSlavePort);
  public Spark rightMaster = new Spark(RobotMap.rightMasterPort);
  public Spark rightSlave = new Spark(RobotMap.rightSlavePort);

  SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftMaster, leftSlave);
  SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(rightMaster, rightSlave);

  //Servo Motor object
  Servo daServa = new Servo(RobotMap.servoPort);
  //instantiate a new DifferentialDrive object
  // assign motor controllers to differential drive
  public DifferentialDrive drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);



  // create constructor function
  public DriveSubsystem(){

  }

  // add teleopDrive() method
  public void manualDrive(double move, double turn) {
    // set max speed
    /*if (move > .5) {
      move = .5;
    */

    if (Math.abs(move) < 0.1){
      move = 0;
    }
    else if(Math.abs(turn) < 0.1){
      turn = 0;
    }

    drive.arcadeDrive(move, turn);
  }

  public void turnServo(double angle){
    double calculatedAngle = (angle + 1)/2;
    System.out.println(calculatedAngle);
    daServa.set(calculatedAngle);
  }

  public void turnServoDegrees(double degrees){
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveManuallyCommand());
  }
}
