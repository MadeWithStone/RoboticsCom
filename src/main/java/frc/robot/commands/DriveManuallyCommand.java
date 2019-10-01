/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Counter;

public class DriveManuallyCommand extends Command {
  Counter counter = new Counter(Robot.m_oi.limitSwitch);

  public boolean isSwitchSet() {
    return counter.get() > 0;
  }

  public DriveManuallyCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    int multiplier = 1;
    System.out.println("Get: "+Robot.m_oi.limitSwitch.get());
    
    if(Robot.m_oi.limitSwitch.get()){
      if (multiplier == 1){
        multiplier++;
      }
    } else {
      if (multiplier == 2){
        multiplier--;
      } 
    }
    double throttle = -(Robot.m_oi.stick.getThrottle() - 1.1);
    System.out.println("Multipler: "+ multiplier);
    double move = -Robot.m_oi.stick.getY()*multiplier;
    double turn = Robot.m_oi.stick.getTwist() * throttle;
    Robot.driveSubsystem.manualDrive(move, turn);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
