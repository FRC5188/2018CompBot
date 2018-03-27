package org.usfirst.frc.team5188.robot.commands.AutoPaths;

import org.usfirst.frc.team5188.robot.Robot;
import org.usfirst.frc.team5188.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class BaseLineEncoder extends Command {
	boolean finished = false;
	
	
	public BaseLineEncoder(){
		this.requires(Robot.driveTrain);
		
	}
	
	public void execute() {
		
		System.out.println("BASELINE ENCODER");
		for(double i = .05; i < .3; i = i + .05) {
			Robot.driveTrain.drive(-i + .07 , -i, 0);
			Timer.delay(.2);
		}
			
//		while(tankEncoder.getDistance() < 120) {
//			Robot.driveTrain.drive(-.37,-.3, .0);
//			if(DriverStation.getInstance().isAutonomous(); ==  true) {
//				break;
//			}
//
//		}
		
		
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
