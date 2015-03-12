package org.usfirst.frc.team5431.robot.subsystems;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5431.robot.RobotMap;


/**
 *
 */
public class Motorcontrol extends Subsystem {
	static VictorSP lift = new VictorSP(RobotMap.liftmotor);
	static Talon left = new Talon(RobotMap.leftmotor);
	static Talon right = new Talon(RobotMap.rightmotor);
	static RobotDrive Robot = new RobotDrive(left, right);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new Motorcontrol());
    }
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
    	lift.set(0.8);
    	lift.setSafetyEnabled(true);
    }
    public static void liftdown(){//If you want to turn 45 degrees right
    	lift.set(-0.8);
    	lift.setSafetyEnabled(true);
    }
    public static void stoplift(){
    	lift.set(0);
    	lift.setSafetyEnabled(true);
    }
}

