package org.usfirst.frc.team5188.robot.commands.AutoPaths;

import org.usfirst.frc.team5188.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class SwitchLeftSideTime extends Command {

	boolean finished = false;
	public SwitchLeftSideTime(){
		this.requires(Robot.driveTrain);
		this.requires(Robot.elevator);
		this.requires(Robot.intake);
	}
	
	public void execute() {
		
		System.out.println("SWITCH RIGHT");
		for(double i = .05; i < .5; i = i + .05) {
			Robot.driveTrain.drive(-i + .07 , -i, 0);
			Timer.delay(.1);
		}
			
		Robot.driveTrain.drive(-.3, -.3, 0);//-.37 and -.3 and 0 was  0 0 .5
		System.out.println("Before Delasy");
		Timer.delay(1);//was 3 for straight, 5 for sideways
		System.out.println("After Delasy");
		
		Robot.elevator.move(.6);
		Timer.delay(2);
		
		Robot.intake.intake(.5);
		Timer.delay(1.5);
		
		finished = true;
	}
	
	public void end() {
		Robot.driveTrain.stop();
	}
	
	public void interrupted() {
		
	}
	
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return finished;
	}

}
