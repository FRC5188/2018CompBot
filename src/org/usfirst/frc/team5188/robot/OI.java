package org.usfirst.frc.team5188.robot;



import org.usfirst.frc.team5188.robot.commands.ElevatorRaiseTo;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.BaseLineTime;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.CLSW;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.CRSW;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.SwitchLeftSideTime;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.SwitchRightSideTime;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {


	
	public static class Controller {
		public static final int DRIVE = 0, OPERATOR = 1;
	}
	
	//buttons of controller 
	public static class Buttons {
		public static int
		A = 1,
		B = 2,
		X = 3,
		Y = 4,
		L = 5,
		R = 6,
		BACK = 7,
		START = 8,
		L_STICK = 9,
		R_STICK = 10,
		TOTAL_BUTTONS = 10;
	}
	
	//controller axis  (including rTrigger and lTrigger) 
	public static class Axis {
		public static int
		LX = 0,
		LY = 1,
		LTrigger = 2,
		RTrigger = 3,
		RX = 4,
		RY = 5,
		AXIS_TOTAL = 6;
	}
	
	//p i and d variables
	public static double
	TURN_TO_DEGREE_P,
	TURN_TO_DEGREE_I,
	TURN_TO_DEGREE_D,
	TURN_TO_DEGREE_ANGLE,
	DRIVE_STAIGHT_P,
	DRIVE_STAIGHT_I,
	DRIVE_STAIGHT_D;
	
	//controllers
	public SuperJoystickPlus drive;
	public SuperJoystickPlus operator;
	
	private Preferences pref;
	
	public OI() {
		//create controllers
		drive = new SuperJoystickPlus(Controller.DRIVE);
		operator = new SuperJoystickPlus(Controller.OPERATOR);
		
		JoystickButton goToSwitch = new JoystickButton(operator, OI.Buttons.A);

		
		
		SmartDashboard.putData("DriveTraive", Robot.driveTrain);
		SmartDashboard.putData("Elevator", Robot.elevator);
		SmartDashboard.putData("Intake", Robot.intake);


		SmartDashboard.putData(Scheduler.getInstance());
		
		pref = Preferences.getInstance();
		//rereadPreferences();
	

	}
	
	
	
}
