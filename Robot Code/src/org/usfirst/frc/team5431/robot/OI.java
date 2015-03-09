package org.usfirst.frc.team5431.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team5431.robot.commands.ExampleCommand;
////// This class is for connecting the computer to robot with the joystick values
public class OI {
    ////////////////////////////////THE MAPPING OF THE BUTTONS/AXIS(Xbox Controller)
	//////////// All axis are a value from (-1 to 1) some are different and most are inverted
	///// button x = 3
	///// button a = 1
	///// button b = 2
	///// button y = 4
	///// button RB = 6 (Right bumper)
	///// button LB = 5 (Left bumper)
	///// button for press down on sticks are 9(topleft) and 10(bottom right)
	//////////////////// These are both one axis RT and LT
	///// axis RT (right trigger) = 3 (0 to -1)
	///// axis LT (left trigger) = 3 (0 to 1)
	///// axis TLX  (top left x value) = 1
	///// axis TLY  (top left y value) = 2
	///// axis BRX  (Bottom right x value) = 4
	///// axis BRY  (Bottom right y value) = 5
	///// POV(plus sign looking thing x value only is) = 6
	////////////////////////////////THE MAPPING OF THE BUTTONS/AXIS(Logitech Gamepad)
	///// button trigger = 1
	///// buttons everywhere else are numbered 1 thru 6
	////////////////
	///// Main joystick (x axis) = 1
	///// Main joystick (y axis) = 2
	///// Main joystick (z axis) = 3
	///// Slider on the bottom back(only one axis which is y) = 4
	///// POV(little thing on top x) = 5
	///// POV(little thing on top y) = 6
    /////////////////////////////////////// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

