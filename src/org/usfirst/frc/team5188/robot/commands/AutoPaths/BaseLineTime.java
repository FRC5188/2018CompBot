package org.usfirst.frc.team5188.robot.commands.AutoPaths;

import org.usfirst.frc.team5188.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class BaseLineTime extends Command {

	boolean finished = false;
	public BaseLineTime(){
		this.requires(Robot.driveTrain);
		
	}
	
	public void execute() {
		
		System.out.println("Baseline");
		for(double i = .05; i < .3; i = i + .05) {
			Robot.driveTrain.drive(-i , -i, 0);
			Timer.delay(.2);
		}
			
		Robot.driveTrain.drive(-.3, -.3, 0);//-.37 and -.3 and 0 was  0 0 .5
		System.out.println("Before Delasy");
		Timer.delay(4.5);//was 4 for straight, 5 for sideways
		System.out.println("After Delasy");
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
