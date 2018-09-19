package org.usfirst.frc.team687.robot.commands.flywheel;

import org.usfirst.frc.team687.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetPowerTime extends Command {

	private double m_power, m_time;
	private double m_startTime;
	
    public SetPowerTime(double power, double time) {
       m_power = power;
       m_time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_startTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.flywheel.setPower(m_power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - m_startTime > m_time;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
