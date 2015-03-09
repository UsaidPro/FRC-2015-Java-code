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
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5431.robot.commands.ExampleCommand;
import org.usfirst.frc.team5431.robot.subsystems.ExampleSubsystem;
public class Robot extends IterativeRobot
{
	Command autonomousCommand; //did this to get rid of the error?(Usaid)
	
	RobotDrive Robot; // Robot object
	Joystick xbox; //Drive the robot
	Joystick logitech; //Operate the lift
	
	int AutoLoopCounter;  //Counts how many seconds have passed during AUTON, increases during autonomous
    // ^The AutoLoopCounter is removable, it's only for functionality
	
	//These two variable below were copy/pasted from RobotMap.java (have no idea how to make files access
	//one another in Java
    public void robotInit() {
    	
    	Robot = new RobotDrive(leftMotor, rightMotor); // This sets theRobot to have motors at ports 0 and 1
    }
	
	public void disabledPeriodic() //Default function
	//- this is for code which will run even when robot is disabled
	{
		Scheduler.getInstance().run();
	}

    public void autonomousInit() //Starts when judge begins autonomous
    {
        // schedule the autonomous command
        if (autonomousCommand != null) autonomousCommand.start(); // If autonomous is off, start it
        
        //This is where commands that robot would only do once (AT THE BEGINNING of auto) should go

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() // This function is called periodically during autonomous
    {
        Scheduler.getInstance().run(); //This will run in a loop
    }

    public void teleopInit() // This runs when teleop is activated by judge
    {
    	double rightSide = xbox.getRawAxis(5); // The right joystick on the Xbox Controller (5 is RightY axis)
    	double leftSide = xbox.getRawAxis(2); //The left axis on the Xbox Controller (2 is LeftY axis)
    	
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        Robot.tankDrive(leftSide, rightSide);
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
