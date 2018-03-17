package org.usfirst.frc.team5188.robot.commands.AutoPaths;

import org.usfirst.frc.team5188.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class SWL extends Command {

	boolean finished = false;
	public SWL(){
		this.requires(Robot.driveTrain);
		
	}
	
	public void execute() {
		for(double i = .05; i < .9; i = i + .03) {
			Robot.driveTrain.drive(0, 0, -i);
			Timer.delay(.2);
		}
			
		Robot.driveTrain.drive(0, 0, -.9);//-.37 and -.3 and 0 for straight 
				
		//Robot.intake.
		System.out.println("Before Delasy");
		Timer.delay(1.);//was 3 for straight, 5 for sideways
		System.out.println("After Delasy");
		
		Robot.driveTrain.drive(-.2, -.2, 0); 
		Timer.delay(.6);
		
		Robot.intake.intake(1);
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
