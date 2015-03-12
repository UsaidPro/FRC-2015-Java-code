package org.usfirst.frc.team5431.robot.commands;
import org.usfirst.frc.team5431.robot.Robot;
import org.usfirst.frc.team5431.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team5431.robot.subsystems.Motorcontrol;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
public class Autonomous extends Command {
	DigitalInput on_off;
	DigitalInput auto1;
	DigitalInput auto2;
	DigitalInput auto3;
    public Autonomous() {
        requires(Robot.Motorcontrol);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	Motorcontrol.stopdrive();
    	Motorcontrol.stoplift();
    	on_off = new DigitalInput(RobotMap.auto_onoff);
    	auto1 = new DigitalInput(RobotMap.auto1);
    	auto2 = new DigitalInput(RobotMap.auto2);
    	auto3 = new DigitalInput(RobotMap.auto3);
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(on_off.get() == true){
    		if(auto1.get() == true && auto2.get() == false && auto3.get()==false){
    			Motorcontrol.forward();
    			Timer.delay(1);
    			Motorcontrol.stopdrive();
    		}else if(auto1.get() == false && auto2.get() == true && auto3.get() == false){
    			Motorcontrol.backward();
    			Timer.delay(1);
    			Motorcontrol.stopdrive();
    		}else if(auto1.get() == false && auto2.get() == false && auto3.get() == true){
    			Motorcontrol.backward();
    			Timer.delay(1);
    			Motorcontrol.forward();
    			Timer.delay(0.5);
    			Motorcontrol.stopdrive();
    		}else{
    			Motorcontrol.forward();
    			Timer.delay(1);
    			Motorcontrol.stopdrive();
    		}
    	}else{
    		Motorcontrol.stopdrive();
    		Timer.delay(0.05);
    		Motorcontrol.stoplift();
    	}
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