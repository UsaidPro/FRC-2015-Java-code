package org.usfirst.frc.team5431.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team5431.robot.commands.Teleop;
import org.usfirst.frc.team5431.robot.commands.Autonomous;
import org.usfirst.frc.team5431.robot.subsystems.Motorcontrol;
public class Robot extends IterativeRobot
{
	Command autonomous;//Start autonomous command
	Command teleop;//Start the teleop command
	public static Subsystem Motorcontrol;//Start motor control Subsystem
	int AutoLoopCounter;  //Counts how many seconds have passed during AUTON, increases during autonomous
    // ^The AutoLoopCounter is removable, it's only for functionality
    public void robotInit() 
    {
    	teleop = new Teleop();//Start teleop Command
    	autonomous = new Autonomous();//Start autonomous Command
    	Motorcontrol = new Motorcontrol();//start MotorControl Subsystem
    }
	
	public void disabledPeriodic() //Default function
	//- this is for code which will run even when robot is disabled
	{
		Scheduler.getInstance().run();
	}

    public void autonomousInit() //Starts when judge begins autonomous
    {
        // schedule the autonomous command
        if (autonomous != null) autonomous.start(); // If autonomous is off, start it
    }
    public void autonomousPeriodic() // This function is called periodically during autonomous
    {
        Scheduler.getInstance().run(); //This will run in a loop
    }
    public void teleopInit() // This runs when teleop is activated by judge/FMS field thingy
    { 
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
          if (autonomous != null) autonomous.cancel();//This doesn't effect anything below here
          teleop.start();//start teleop command
    }
    public void disabledInit(){//This function is called when the disabled button is hit. You can use it to reset subsystems before shutting down.
    teleop.cancel();//cancel teleop command
    autonomous.cancel();//cancel autonomous command
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
