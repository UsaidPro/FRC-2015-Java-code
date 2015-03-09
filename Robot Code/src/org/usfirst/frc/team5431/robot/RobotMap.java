package org.usfirst.frc.team5431.robot;
//This class is made to map sensors and motor controllers to the Robot.java 
//The difference between this and IO.java is that OI is for the computer mainly and this is mainly for the robot mapping
public class RobotMap {
    // To Map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
	public static int leftmotor = 0;//port for leftMotor
    public static int rightmotor = 1;//port for rightMotor
    public static int liftmotor = 2;//port for liftMotor
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
