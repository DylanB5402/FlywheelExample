/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team687.robot.subsystems;

import org.usfirst.frc.team687.robot.RobotMap;
import org.usfirst.frc.team687.robot.commands.flywheel.FlywheelJoystickControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Flywheel extends Subsystem {
	
	private final TalonSRX m_flywheel;
	
	public Flywheel() {
		m_flywheel = new TalonSRX(RobotMap.kFlywheelID);
		m_flywheel.setNeutralMode(NeutralMode.Coast);
		m_flywheel.setInverted(false);
	}

	public void setPower(double power) {
		m_flywheel.set(ControlMode.PercentOutput, power);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new FlywheelJoystickControl());
	}
	
	public double getFlywheelVoltage() {
		return m_flywheel.getMotorOutputVoltage();
	}
	
	public double getFlywheelCurrent() {
		return m_flywheel.getOutputCurrent();
	}
	
	public void reportToSmartDashboard() {
		SmartDashboard.putNumber("Flywheel Current", getFlywheelCurrent());
		SmartDashboard.putNumber("Flywheel Voltage", getFlywheelVoltage());
	}
}
