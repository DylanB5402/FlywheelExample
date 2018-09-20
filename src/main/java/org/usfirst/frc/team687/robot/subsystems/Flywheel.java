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
	
	private final TalonSRX m_flywheel1, m_flywheel2;
	
	public Flywheel() {
		m_flywheel1 = new TalonSRX(RobotMap.kFlywheelID);
		m_flywheel2 = new TalonSRX(RobotMap.kFlywheel2ID);
		
		m_flywheel1.setNeutralMode(NeutralMode.Coast);
		m_flywheel2.setNeutralMode(NeutralMode.Coast);

		m_flywheel1.config_kP(0, 15, 0);
		m_flywheel1.setInverted(false);
		m_flywheel2.setInverted(true);

	}

	public void setPower(double power) {
		m_flywheel1.set(ControlMode.PercentOutput, power);
		m_flywheel2.set(ControlMode.PercentOutput, power);
	}
	
	public void initDefaultCommand() {
		// setDefaultCommand(new FlywheelJoystickControl());
	}
	
	public double getFlywheelVoltage() {
		return m_flywheel1.getMotorOutputVoltage();
	}
	
	public double getFlywheelCurrent() {
		return m_flywheel1.getOutputCurrent();
	}
	
	public void reportToSmartDashboard() {
		SmartDashboard.putNumber("Flywheel 1 Current", getFlywheelCurrent());
		SmartDashboard.putNumber("Flywheel 1 Voltage", getFlywheelVoltage());
		SmartDashboard.putNumber("Flywheel 2 Current", m_flywheel2.getOutputCurrent());
		SmartDashboard.putNumber("Flywheel 2 Voltage", m_flywheel2.getMotorOutputVoltage());
	}
}
