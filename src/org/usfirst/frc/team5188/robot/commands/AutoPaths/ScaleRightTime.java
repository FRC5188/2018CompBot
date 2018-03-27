package org.usfirst.frc.team5188.robot.commands.AutoPaths;

import org.usfirst.frc.team5188.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ScaleRightTime extends Command {

	boolean finished = false;
	public ScaleRightTime(){
		this.requires(Robot.driveTrain);
		
	}
	
	public void execute() {
		
		System.out.println("Baseline");
		for(double i = .05; i < .5; i = i + .05) {
			Robot.driveTrain.drive(-i , -i, 0);
			Timer.delay(.1);
		}
			
		Robot.driveTrain.drive(-.5, -.5, 0);//-.37 and -.3 and 0 was  0 0 .5
		System.out.println("Before Delasy");
		Timer.delay(2.9);//was 4 for straight, 5 for sideways
		System.out.println("After Delasy");
		
		
		Robot.driveTrain.drive(0, -.4, 0);
		Timer.delay(.5);
		Robot.driveTrain.stop();
		
		
		Robot.elevator.move(-.8);
		Robot.intake.intake(.5);
		Timer.delay(2.2);
		
		Robot.intake.stop();
		
		Robot.intake.intake(-1);
		Timer.delay(.5);
		
		finished = true;
	}
	
	public void end() {
		Robot.driveTrain.stop
	();
	}
	
	public void interrupted() {
		
	}
	
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return finished;
	}

}
