package org.usfirst.frc.team5431.robot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5431.robot.OI;
import org.usfirst.frc.team5431.robot.RobotMap;
public class Teleop extends Command 
{
	PowerDistributionPanel PDP;//Create Power Distribution Panel
	RobotDrive Robot; // Robot object
	VictorSP lift;//Set lift motor
	Talon left;//Set left motor
	Talon right;//Set right motor
	Joystick xbox; //Drive the robot
	Joystick logitech; //Operate the lift
	Button x;//Get button x from Xbox controller
	Button Trigger;//Get the Trigger button from Logitech controller
	final double updatePeriod = 0.005; // update every 0.005 seconds/5 milliseconds (200Hz)
	boolean finished = false;
    public Teleop() 
    {
        // Use requires() here to declare subsystem dependencies
        
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	PDP = new PowerDistributionPanel();//New Distribution Panel
    	xbox = OI.xbox;//Set xbox Joystick
    	logitech = OI.logitech;//Set logitech joystick
    	x = OI.xboxX;//Set x button
    	Trigger = OI.logitechT;//Set Trigger button
    	lift = new VictorSP(RobotMap.liftmotor);//Set motor controller for lift
    	left = new Talon(RobotMap.leftmotor);//Set motor controller for left wheels
    	right = new Talon(RobotMap.rightmotor);//Set motor controller for right wheels
    	Robot = new RobotDrive(left, right); // This sets theRobot to have motors at ports 0 and 1
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	while (true){
    PDP.clearStickyFaults();//Clear any faults before continuing
    SmartDashboard.putNumber("Temp", PDP.getTemperature());//Smartdashboard put PDP temperature
    SmartDashboard.putNumber("Power", PDP.getTotalPower());//Smartdashboard put PDP Total Power
    double slowmo = 1.1;//Default slowmo for wheels
    double liftslowmo;//Slowmo for lift
    boolean last;//Last boolean value
    boolean current = true;//Initialize current value as true
    if(Trigger.get() == true)
    {//If trigger is pressed slow down lift
    	liftslowmo = 1.4;//Slow down by %40
    }
    else
    {//If it's not pushed
    	liftslowmo = 1;//Keep value of %100
    }
    if(x.get() != false)
    {//If button = true
    	current = true;//Set current value true
    }
    else
    {//If button not = true
    	current = false;//Set current value false
    }
    if(x.get() == current)
    {//If button = current
    		last = !current;//Last = not current which could be true by the way
    }
    else
    {//If button != current
    	last = true;//Last = true
    }
    if(last == current)
    {//If last value = current value than keep value
    	slowmo = 1.1;//Divide speed by 1
    }
    else
    {//If last value has changed
    	slowmo = 1.5;//Divide speed by 1.5
    }
    Robot.tankDrive(xbox.getRawAxis(2)/slowmo, xbox.getRawAxis(5)/slowmo);//Tank drive directly from Joysticks//Divide final lift by whatever slowmo was//Lift motor get from Logitech stick
    //Slow down right motors by toggle//Right motors get from Xbox right stick
    //Slow down Left motors by toggle//Left motors get from Xbox left stick
	Robot.setSafetyEnabled(true);//Set safety so robot doesn't go kasplat 
    lift.set(logitech.getRawAxis(2)/liftslowmo);//Lift drive directly from Joystick
	Timer.delay(updatePeriod);	// wait 5ms to the next update
    }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return finished;//This command does need to run again so once the interrupted is called to become true this becomes true
    }

    // Called once after isFinished returns true
    protected void end() 
    {
      	Robot.tankDrive(0, 0);//Turn off drive motors when disabled
      	lift.set(0);//Turn off lift motors when disabled
      	SmartDashboard.putBoolean("tele", false);//Set dashboard value tele to false
      	SmartDashboard.putBoolean("auton", false);//Set dashboard value auton to false
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	try
    	{
    		execute();//If interrupted try running the program once more
    	}
    	finally
    	{
    		finished = true;//Once the cancel command send is isFinished true
    		end();//If not working just end this will make sure that when cancel(); is called you have a shot at something
    	}
    }
}

