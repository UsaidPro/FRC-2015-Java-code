package org.usfirst.frc.team5431.robot;

import edu.wpi.first.wpilibj.Joystick;//Imported the stuff to control the Joysticks

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
////// This class is for connecting the computer to robot with the joystick values
public class OI 
{
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
	////////////////////////For Xbox Controller
    public static Joystick xbox = new Joystick(0);//Created the Joystick called Xbox on port 0
    Button xboxA = new JoystickButton(xbox, 1);//access button (A) on joystick XBOX and button number(whatever) (stick, buttonNumber)
    Button xboxB = new JoystickButton(xbox, 2);//access button (B) on joystick XBOX and button number(whatever) (stick, buttonNumber)
    public static Button xboxX = new JoystickButton(xbox, 3);//access button (X) on joystick XBOX and button number(whatever) (stick, buttonNumber)
    Button xboxY = new JoystickButton(xbox, 4);//access button (Y) on joystick XBOX and button number(whatever) (stick, buttonNumber)
    Button xboxRB = new JoystickButton(xbox, 6);//access button (RB) on joystick XBOX and button number(whatever) (stick, buttonNumber)
    Button xboxLB = new JoystickButton(xbox, 5);//access button (LB) on joystick XBOX and button number(whatever) (stick, buttonNumber)
    Button xboxLS = new JoystickButton(xbox, 9);//access button (LS)=left stick on joystick XBOX and button number(whatever) (stick, buttonNumber)
    Button xboxRS = new JoystickButton(xbox, 10);//access button (RS)=right stick on joystick XBOX and button number(whatever) (stick, buttonNumber)
    //END of Xbox mapping
    //////////////////////For Logitech controller
    public static Joystick logitech = new Joystick(1);//Created the Joystick called Logitech on port 1
    public static Button logitechT = new JoystickButton(logitech, 1);//access button (Trigger) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    Button logitechThumb = new JoystickButton(logitech, 2);//access button (Thumb button aka 2) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    Button logitechBl = new JoystickButton(logitech, 3);//access button (bottom left aka 3) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    Button logitechBR = new JoystickButton(logitech, 4);//access button (bottom right aka 4) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    Button logitechTR = new JoystickButton(logitech, 6);//access button (top left aka 5) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    Button logitechTL = new JoystickButton(logitech, 5);//access button (top right aka 6) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    Button logitech7 = new JoystickButton(logitech, 7);//access button (7) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    Button logitech8 = new JoystickButton(logitech, 8);//access button (8) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    Button logitech9 = new JoystickButton(logitech, 9);//access button (9) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    Button logitech10 = new JoystickButton(logitech, 10);//access button (10) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    Button logitech11 = new JoystickButton(logitech, 11);//access button (11) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    Button logitech12 = new JoystickButton(logitech, 12);//access button (12) on joystick Logitech and button number(whatever) (stick, buttonNumber)
    //END of Logitech mapping
    
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

