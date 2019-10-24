/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.PneumaticsCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Compressor compressor;
  private DoubleSolenoid solenoid;
  

  

  public Pneumatics() {
    compressor = RobotMap.compressor;
    solenoid = new DoubleSolenoid(RobotMap.solenoid1, RobotMap.solenoid2);
    //compressor.setClosedLoopControl(true);
    //compressor.start();
    solenoid.set(DoubleSolenoid.Value.kOff);
  }

  public void openPiston(){   
    solenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void closePiston(){
    solenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new PneumaticsCommand());
  }
}
