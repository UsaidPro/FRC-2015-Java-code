//TODO Fix the main code::: under Robot.java
// THIS CODE WON'T WORK for sure - no idea how to do this right + no testing = 100% chance to fail in coding
//This was based off example code - not perfect
//Autonomous will need edits
//All comments done here were by FRC and Usaid and David

package org.usfirst.frc.team5431.robot;
//This class corresponds each area with whatever period it is in such as Auto or Teleop
//To configure joystick buttons/mappings go to IO.java
//To map what motor controllers/sensors go where go to RobotMap.java
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team5431.robot.commands.ExampleCommand;
import org.usfirst.frc.team5431.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team5431.robot.OI;
import org.usfirst.frc.team5431.robot.RobotMap;
public class Robot extends IterativeRobot
{
	Command autonomousCommand; //did this to get rid of the error?(Usaid)
	int AutoLoopCounter;  //Counts how many seconds have passed during AUTON, increases during autonomous
    // ^The AutoLoopCounter is removable, it's only for functionality
	RobotDrive Robot; // Robot object
	VictorSP lift;
	Joystick xbox; //Drive the robot
	Joystick logitech; //Operate the lift
	//These two variable below were copy/pasted from RobotMap.java (have no idea how to make files access
	//one another in Java
    public void robotInit() {
    	xbox = new Joystick(0);
    	logitech = new Joystick(1);
    	int leftMotor = RobotMap.leftmotor;//Get motor port from RobotMap.java for left motor
    	int rightMotor = RobotMap.rightmotor;//Get motor port from RobotMap.java for right motor
    	int liftMotor = RobotMap.liftmotor;//Get motor port from RobotMap.java for
    	lift = new VictorSP(liftMotor);
    	Robot = new RobotDrive(leftMotor, rightMotor); // This sets theRobot to have motors at ports 0 and 1
    }
	
	public void disabledPeriodic() //Default function
	//- this is for code which will run even when robot is disabled
	{
		Scheduler.getInstance().run();
	}
	
	public void autonomousCommand.initialize()
	{
		//run auto code here that we only do once
	}
	
	public void autonomousCommand.execute()
	{
		//run code that would go into a loop
	}
	
	public void autonomousCommand.interrupted()
	{
		//Run what would happen if autonomousCommand failed by error/another function
	}

    public void autonomousInit() //Starts when judge begins autonomous
    {
        // schedule the autonomous command
        if (autonomousCommand != null) autonomousCommand.start(); // If autonomous is off, start it
        
        //This is where commands that robot would only do once (AT THE BEGINNING of auto) should go
        // Maybe autonomousCommand.start() means to start a series of commands? Where would those be?
        //If autonomousCommand fails in the middle of running, it will run
        //autonomousCommand.interrupted() where it would then run another series of steps
        // Another thing we could do instead is that if we don't want to use autonomousCommand, we simply remove it and have an else statement do another series of steps instead 
        

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() // This function is called periodically during autonomous
    {
        Scheduler.getInstance().run(); //This will run in a loop
    }

    public void teleopInit() // This runs when teleop is activated by judge/FMS field thingy
    {
    	double lift = logitech.getRawAxis(2);
    	double leftSide = xbox.getRawAxis(2);
    	double rightSide = xbox.getRawAxis(5);
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
//<<<<<<< HEAD
        
        Robot.tankDrive(leftSide, rightSide);
        
//=======
        Robot.tankDrive(leftSide, rightSide);
        Robot.setSafetyEnabled(isEnabled());
        Robot.drive(lift, 0);
        //Robot. - what were you going to do here David?
//>>>>>>> origin/master
    }
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit()
    {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() // Note this is called 'periodically' - there is a wait time before it
    {							//runs again
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() // This is called periodically when test mode is activated
    {
        LiveWindow.run();
    }
}
