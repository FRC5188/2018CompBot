package org.usfirst.frc.team5188.robot.commands.AutoPaths;

import org.usfirst.frc.team5188.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Base1 extends Command {

	boolean finished = false;
	public Base1(){
		this.requires(Robot.driveTrain);
		
	}
	
	public void execute() {
		for(double i = .05; i < .5; i = i + .05) {
			Robot.driveTrain.drive(0, 0, -i);
			Timer.delay(.2);
		}
			
		Robot.driveTrain.drive(0, 0, -.5);//-.37 and -.3 and 0 
		System.out.println("Before Delasy");
		Timer.delay(5);//was 3 for straight, 5 for sideways
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
