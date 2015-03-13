package org.usfirst.frc.team5431.robot.commands;
import org.usfirst.frc.team5431.robot.Robot;//Import Robot.java
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import org.usfirst.frc.team5431.robot.RobotMap;//Import Robot map to map switches
import edu.wpi.first.wpilibj.DigitalInput;//Import digital input so you can 
import org.usfirst.frc.team5431.robot.subsystems.Motorcontrol;//Import motor control so you can move
import edu.wpi.first.wpilibj.Timer;//Import timer so it can run those commands
import edu.wpi.first.wpilibj.command.Command;//Import the Command base system
public class Autonomous extends Command {
//This is the Autonmous Command  is where all the code for auton is... the subsystem that is located in this is called Motorcontrol
//Go to Motorcontrol to find more info on forward backward etc...
	BuiltInAccelerometer accel;
	DigitalInput on_off;//New input on Roborio
	DigitalInput auto1;//New input on Roborio
	DigitalInput auto2;//New input on Roborio
	DigitalInput auto3;//New input on Roborio
    public Autonomous() {
        requires(Robot.Motorcontrol);//Import subsystem Motorcontrol to control forward backward etc...
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	accel = new BuiltInAccelerometer();
    	on_off = new DigitalInput(RobotMap.auto_onoff);//Import DIO pin on_off from RobotMap
    	auto1 = new DigitalInput(RobotMap.auto1);//Import DIO pin auto1 from RobotMap
    	auto2 = new DigitalInput(RobotMap.auto2);//Import DIO pin auto2 from RobotMap
    	auto3 = new DigitalInput(RobotMap.auto3);//Import DIO pin auto3 from RobotMap
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(on_off.get() == true){//If the Main on/off switch is on then run whatever below::: else Run nothing
    		if(auto1.get() == true && auto2.get() == false && auto3.get()==false){//If auto1 is true and the rest are false then run auto 1
    			Motorcontrol.forward();//move forward
    			Timer.delay(1);//For 1 second
    			Motorcontrol.stopdrive();//stop
    		}else if(auto1.get() == false && auto2.get() == true && auto3.get() == false){//Else If auto2 is true and the rest are false then run auto 2
    			Motorcontrol.backward();//move backward
    			Timer.delay(1);//for 1 second
    			Motorcontrol.stopdrive();//stop
    		}else if(auto1.get() == false && auto2.get() == false && auto3.get() == true){//Else If auto3 is true and the rest are false then run auto 3
    			Motorcontrol.backward();//Move backward
    			Timer.delay(1);//for 1 second
    			Motorcontrol.forward();//move forward 
    			Timer.delay(0.5);//for 1/2 second
    			Motorcontrol.stopdrive();//stop
    		}else{//If one of the switches have 2 trues or none of them are on then run this
    			Motorcontrol.forward();//Move forward
    			Timer.delay(1);//for 1 second
    			Motorcontrol.stopdrive();//stop
    		}
    	}else{//If the main switch is off run this
    		Motorcontrol.stopdrive();//stopdrive
    		Timer.delay(0.05);//wait so no interruption
    		Motorcontrol.stoplift();//stoplift
    	}
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;//You only need to run this command once but set it to false so it won't interrupt anything
    }

    // Called once after isFinished returns true
    protected void end() {
		Motorcontrol.stopdrive();//stop
		Motorcontrol.stoplift();//stop
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();//If there is a interruption call end(); p.s. it's right above
    }
}