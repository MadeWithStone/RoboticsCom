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
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.AnalogInput;

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
    
    double degrees = Robot.m_oi.pot.get();
    System.out.println("degrees: "+degrees);
    
    if(!Robot.m_oi.limitSwitch.get()){
      if (multiplier == 1){
        multiplier++;
        Robot.pneumatics.openPiston();
      }
    } else {
      if (multiplier == 2){
        multiplier--;
        Robot.pneumatics.closePiston();
      } 
    }
    double throttle = -(Robot.m_oi.stick.getThrottle() - 1.1);
    //System.out.println("Multipler: "+ multiplier);
    double y = -Robot.m_oi.stick.getY();
    double move = 0.5*y*throttle;
    double turn = 0.5*Robot.m_oi.stick.getTwist()*throttle;
    Robot.driveSubsystem.manualDrive(move, turn);
    //Robot.driveSubsystem.turnServoDegrees(degrees);;

    
    
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
