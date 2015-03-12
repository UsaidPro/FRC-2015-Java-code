package org.usfirst.frc.team5431.robot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5431.robot.OI;
import org.usfirst.frc.team5431.robot.RobotMap;
public class Teleop extends Command {
	RobotDrive Robot; // Robot object
	VictorSP lift;
	Talon left;
	Talon right;
	Joystick xbox; //Drive the robot
	Joystick logitech; //Operate the lift
	final double updatePeriod = 0.005; // update every 0.005 seconds/5 milliseconds (200Hz)
    public Teleop() {
        // Use requires() here to declare subsystem dependencies
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	xbox = OI.xbox;//Set xbox Joystick
    	logitech = OI.logitech;//Set logitech joystick
    	int leftMotor = RobotMap.leftmotor;//Get motor port from RobotMap.java for left motor
    	int rightMotor = RobotMap.rightmotor;//Get motor port from RobotMap.java for right motor
    	int liftMotor = RobotMap.liftmotor;//Get motor port from RobotMap.java for
    	lift = new VictorSP(liftMotor);
    	left = new Talon(leftMotor);
    	right = new Talon(rightMotor);
    	Robot = new RobotDrive(left, right); // This sets theRobot to have motors at ports 0 and 1
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    Robot.tankDrive(xbox.getRawAxis(2), xbox.getRawAxis(5));//Tank drive directly from Joysticks
	Robot.setSafetyEnabled(true);//Set safety so robot doesn't go kasplat 
    lift.set(logitech.getY());//Lift drive directly from Joystick
	Timer.delay(updatePeriod);	// wait 5ms to the next update
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
    	end();
    }
}

