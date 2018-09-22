/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team687.robot;

import org.usfirst.frc.team687.robot.commands.flywheel.MoveFlywheelBackAndForth;
import org.usfirst.frc.team687.robot.commands.flywheel.SetPower;
import org.usfirst.frc.team687.robot.commands.claw.OpenClaw;
import org.usfirst.frc.team687.robot.commands.claw.CloseClaw;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private static Joystick flywheelStick;
	private static JoystickButton forwards_1;
	
	public OI() {
		flywheelStick = new Joystick(0);
		forwards_1 = new JoystickButton(flywheelStick, 1);
		// forwards_1.whileHeld(new SetPower(0.5));
		// SmartDashboard.putData("Flywheel back and forth", new MoveFlywheelBackAndForth());
		SmartDashboard.putData("12 V", new SetPower(1));
		SmartDashboard.putData("9 V", new SetPower(0.75));
		SmartDashboard.putData("6 V", new SetPower(0.5));
		SmartDashboard.putData("3 V", new SetPower(0.25));
		SmartDashboard.putData("-12 V", new SetPower(-1));
		SmartDashboard.putData("-9 V", new SetPower(-0.75));
		SmartDashboard.putData("-6 V", new SetPower(-0.5));
		SmartDashboard.putData("-3 V", new SetPower(-0.25));
		SmartDashboard.putData("STAHP", new SetPower(0));

		SmartDashboard.putData("Close claw", new CloseClaw());
		SmartDashboard.putData("Open claw", new OpenClaw());
	}
	
	public double getJoystickY() {
		return flywheelStick.getY();
	}
}
