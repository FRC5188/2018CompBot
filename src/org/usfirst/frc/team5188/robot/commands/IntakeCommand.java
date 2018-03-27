package org.usfirst.frc.team5188.robot.commands;

import org.usfirst.frc.team5188.robot.OI;
import org.usfirst.frc.team5188.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command {

	
	
	public IntakeCommand() {
		requires(Robot.intake);
	}
	
	@Override
	public void execute() {
		double leftTrigger = Robot.oi.operator.getAxis(OI.Axis.LTrigger);
		double rightTrigger = Robot.oi.operator.getAxis(OI.Axis.RTrigger);
		boolean leftButton =  Robot.oi.operator.getRawButton(OI.Buttons.L);
		boolean rightButton =  Robot.oi.operator.getRawButton(OI.Buttons.R);
		boolean xButton = Robot.oi.operator.getRawButton(OI.Buttons.X);

		

		
		if(leftTrigger > 0.05) {
			Robot.intake.intake(-leftTrigger * .6);  
		}
		else if(rightTrigger > 0.05) {
			Robot.intake.intake(rightTrigger * 1);
		}
		else if(leftButton == true) {
			Robot.intake.intake(-.3);

		}
		else if(rightButton == true) {
			Robot.intake.intake(.3);

		}
		else if(xButton == true) {
			Robot.intake.setRightIntake(.7);
			Robot.intake.setLeftIntake(-.4);
		}
		else {
			Robot.intake.stop();
		}	}
	
	public void end() {
		Robot.intake.stop();

	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
