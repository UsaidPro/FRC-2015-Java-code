package org.usfirst.frc.team5431.robot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5431.robot.OI;
import org.usfirst.frc.team5431.robot.RobotMap;
public class Teleop extends Command {
	BuiltInAccelerometer Accel;
	RobotDrive Robot; // Robot object
	VictorSP lift;//Set lift motor
	Talon left;//Set left motor
	Talon right;//Set right motor
	Joystick xbox; //Drive the robot
	Joystick logitech; //Operate the lift
	Button x;
	final double updatePeriod = 0.005; // update every 0.005 seconds/5 milliseconds (200Hz)
    public Teleop() {
        // Use requires() here to declare subsystem dependencies
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Accel = new BuiltInAccelerometer();
    	xbox = OI.xbox;//Set xbox Joystick
    	logitech = OI.logitech;//Set logitech joystick
    	x = OI.xboxX;
    	int leftMotor = RobotMap.leftmotor;//Get motor port from RobotMap.java for left motor
    	int rightMotor = RobotMap.rightmotor;//Get motor port from RobotMap.java for right motor
    	int liftMotor = RobotMap.liftmotor;//Get motor port from RobotMap.java for
    	lift = new VictorSP(liftMotor);//Set motor controller for lift
    	left = new Talon(leftMotor);//Set motor controller for left wheels
    	right = new Talon(rightMotor);//Set motor controller for right wheels
    	Robot = new RobotDrive(left, right); // This sets theRobot to have motors at ports 0 and 1
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    double slowmo = 1.1;
    boolean last;
    boolean current = true;
    double LM = xbox.getRawAxis(2);
    double RM = xbox.getRawAxis(5);
    if(x.get() != false){//If button = true
    	current = true;//Set current value true
    }else{//If button not = true
    	current = false;//Set current value false
    }
    	if(x.get() == current){//If button = current
    		last = false;//Last = false
    }else{//If button != current
    	last = true;//Last = true
    }if(last == current){//If last value = current value than keep value
    	slowmo = 1.1;//Divide speed by 1
    }else{//If last value has changed
    	slowmo = 1.5;//Divide speed by 1.5
    }
    double leftfinal = LM/slowmo;//Slow down Left motors by toggle
    double rightfinal = RM/slowmo;//Slow down right motors by toggle
    Robot.tankDrive(leftfinal, rightfinal);//Tank drive directly from Joysticks
	Robot.setSafetyEnabled(true);//Set safety so robot doesn't go kasplat 
    lift.set(logitech.getY());//Lift drive directly from Joystick
	Timer.delay(updatePeriod);	// wait 5ms to the next update
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;//This command does need to run again
    }

    // Called once after isFinished returns true
    protected void end() {
      	Robot.tankDrive(0, 0);//Turn off drive motors when disabled
      	lift.set(0);//Turn off lift motors when disabled
      	SmartDashboard.putBoolean("tele", false);//Set dashboard value tele to false
      	SmartDashboard.putBoolean("auton", false);//Set dashboard value auton to false
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	try{
    		execute();//If interrupted try running the program once more
    	}finally{
    		end();//If not working just end this will make sure that when cancel(); is called you have a shot at something
    	}
    }
}

