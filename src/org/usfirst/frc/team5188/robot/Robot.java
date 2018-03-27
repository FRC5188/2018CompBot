
package org.usfirst.frc.team5188.robot;

import org.usfirst.frc.team5188.robot.commands.NullCommand;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.BaseLineTime;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.CLSW;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.CRSW;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.SCL;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.SCR;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.ScaleLeftTime;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.ScaleRightTime;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.SwitchLeftSideTime;
import org.usfirst.frc.team5188.robot.commands.AutoPaths.SwitchRightSideTime;
import org.usfirst.frc.team5188.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5188.robot.subsystems.Elevator;
import org.usfirst.frc.team5188.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	public static OI oi;
	public static DriveTrain driveTrain;
	public static Intake intake;
	public static Elevator elevator;
	public static Timer timer = new Timer();
	
	SendableChooser<Command> rightAutoOptions = new SendableChooser<>();
	SendableChooser<Command> leftAutoOptions = new SendableChooser<>();


	
	final String TIMERBOX = "Timer Box";
	final String baseTime = "baseLineTime";
	final String SWR = "SWR";
	final String SWL = "SWL";
	final String SCR = "SCR";
	final String SCL = "SCL";
	final String CRSW = "CRSW";
	final String CLSW = "CLSW";
	final String LEFT = "left";
	final String RIGHT = "right";


	String gameData;
	
	double delayLength;
	
	Command selectedAuto;
	
	@Override
	public void robotInit() {
		driveTrain = new DriveTrain();
		
		elevator = new Elevator();
		intake = new Intake();
		
		CameraServer.getInstance().startAutomaticCapture();
				
				
		SmartDashboard.putNumber(TIMERBOX, 0.0);		

		
		rightAutoOptions.addDefault("Null", new NullCommand());
		rightAutoOptions.addObject("BaseLineTime", new BaseLineTime());
		rightAutoOptions.addObject("Scale Right Time", new ScaleRightTime());
		rightAutoOptions.addObject("Switch Right Time", new SwitchRightSideTime());
		
		leftAutoOptions.addDefault("Null", new NullCommand());
		leftAutoOptions.addObject("BaseLineTime", new BaseLineTime());
		leftAutoOptions.addObject("Scale Left Time", new ScaleLeftTime());
		leftAutoOptions.addObject("Switch Left Time", new SwitchLeftSideTime());

		driverSide.addObject(LEFT, LEFT);
		driverSide.addObject(RIGHT, RIGHT);		
				
		SmartDashboard.putData("Right Auto Options", rightAutoOptions);
		SmartDashboard.putData("Left Auto Options", leftAutoOptions);
		SmartDashboard.putData("auto side", driverSide);

//		SmartDashboard.putData("Driver Stations", driverStations);

		
		// OI must be initialized after all subsystems
		oi = new OI();

		}

	
	@Override
	public void disabledInit() {
		
	}

	@Override
	public void disabledPeriodic() {
		
		
		Scheduler.getInstance().run();
	}

	
	@Override
	public void autonomousInit() {
		gameData =  DriverStation.getInstance().getGameSpecificMessage();
		delayLength = SmartDashboard.getNumber(TIMERBOX, 0);
		
	}

	
	@Override
	public void autonomousPeriodic() {
		
		
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
//		if (autonomousCommand != null)
//			autonomousCommand.cancel();
	}

	
	@Override
	public void teleopPeriodic() {
		
		if(Robot.oi.drive.getRawButton(OI.Buttons.X)) {
			Command baseline = new BaseLineTime();
			baseline.start();
		}
		
		Scheduler.getInstance().run();
	}

	
	@Override
	public void testPeriodic() {
	}


	/** Prevent button creep */
	public static double deadband(double d) {
		final double band = 0.05;
		if (d > -band && d < band) {
			return 0;
		} else {
			return d;
		}
	}
}
