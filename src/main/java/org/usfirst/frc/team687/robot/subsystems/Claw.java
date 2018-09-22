/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team687.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Claw extends Subsystem {

  private final DoubleSolenoid m_claw;

  public Claw() {
    m_claw = new DoubleSolenoid(0, 1);
  }

  public void openClaw() {
	  m_claw.set(DoubleSolenoid.Value.kForward);
  }

  public void closeClaw() {
	  m_claw.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
  }
}
