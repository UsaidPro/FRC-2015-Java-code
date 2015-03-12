package org.usfirst.frc.team5431.robot.commands;
import org.usfirst.frc.team5431.robot.Robot;
import org.usfirst.frc.team5431.robot.subsystems.Motorcontrol;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
public class Autonomous extends Command {

    public Autonomous() {
        requires(Robot.Motorcontrol);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	Motorcontrol.stopdrive();
    	Motorcontrol.stoplift();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    Motorcontrol.forward();
    Timer.delay(1);
    Motorcontrol.backward();
    Timer.delay(1);
    Motorcontrol.stopdrive();
    
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Motorcontrol.stopdrive();
    	Motorcontrol.stoplift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}