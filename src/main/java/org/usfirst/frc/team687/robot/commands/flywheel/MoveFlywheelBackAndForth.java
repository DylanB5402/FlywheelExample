package org.usfirst.frc.team687.robot.commands.flywheel;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Rotate a flywheel one direction for 3 seconds and then the other direction for 3 seconds
 */
public class MoveFlywheelBackAndForth extends CommandGroup {

    public MoveFlywheelBackAndForth() {
        addSequential(new SetPowerTime(0.5, 3));
        addSequential(new SetPowerTime(-0.5, 3));
    }
}
