package org.usfirst.frc.team5431.robot.subsystems;
import edu.wpi.first.wpilibj.RobotDrive;//Drive the robot
import edu.wpi.first.wpilibj.Talon;//Motor controller for drive
import edu.wpi.first.wpilibj.VictorSP;//Motor controller for lift
import edu.wpi.first.wpilibj.command.Subsystem;//Subsystem Commands
import org.usfirst.frc.team5431.robot.RobotMap;//Import ports for motor
public class Motorcontrol extends Subsystem {
	static VictorSP lift = new VictorSP(RobotMap.liftmotor);//Set VictorSP to correct motorport
	static Talon left = new Talon(RobotMap.leftmotor);//Set Talon to left motor
	static Talon right = new Talon(RobotMap.rightmotor);//Set Talon to right motor
	static RobotDrive Robot = new RobotDrive(left, right);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new Motorcontrol());
    }//You can call these subsystem commands in Autonomous.java ||||||||||||||||| PLEASE ONLY USE FOR AUTONOMOUS
    public static void forward(){//If you want to move forward
        Robot.tankDrive(0.7, 0.7);//Tank drive directly from Joysticks
    	Robot.setSafetyEnabled(true);//Set safety so robot doesn't go kasplat 
    }
    public static void backward(){//If you want to move backward
        Robot.tankDrive(-0.7, -0.7);//Tank drive directly from Joysticks
    	Robot.setSafetyEnabled(true);//Set safety so robot doesn't go kasplat 
    }
    public static void stopdrive(){//If you want to stop
        Robot.tankDrive(0, 0);//Tank drive directly from Joysticks
    	Robot.setSafetyEnabled(true);//Set safety so robot doesn't go kasplat 
    }
    public static void turnleft(){//if you want to turn 90 degrees left
        Robot.tankDrive(-0.5, 5);//Tank drive directly from Joysticks
    	Robot.setSafetyEnabled(true);//Set safety so robot doesn't go kasplat 
    }
    public static void turnright(){//if you want to turn 90 degrees right
        Robot.tankDrive(0.5, -0.5);//Tank drive directly from Joysticks
    	Robot.setSafetyEnabled(true);//Set safety so robot doesn't go kasplat 
    }
    public static void liftup(){//If you want to turn 45 degrees left
    	lift.set(0.8);//Lift go up
    	lift.setSafetyEnabled(true);//Set safety so robot doesn't go kasplat 
    }
    public static void liftdown(){//If you want to turn 45 degrees right
    	lift.set(-0.8);//Lift go down
    	lift.setSafetyEnabled(true);//Set safety so robot doesn't go kasplat 
    }
    public static void stoplift(){
    	lift.set(0);//Stop the lift
    	lift.setSafetyEnabled(true);//Set safety so robot doesn't go kasplat 
    }
}

