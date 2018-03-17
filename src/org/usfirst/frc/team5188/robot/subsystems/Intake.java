package org.usfirst.frc.team5188.robot.subsystems;


import org.usfirst.frc.team5188.robot.RobotMap;
import org.usfirst.frc.team5188.robot.commands.IntakeCommand;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	private VictorSP leftIntake; 
	private VictorSP rightIntake;

	public Intake(){
		 leftIntake = new VictorSP(RobotMap.leftIntake);
		 rightIntake = new VictorSP(RobotMap.rightIntake);
		 
	}
	
	public void setLeftIntake(double speed) {
		leftIntake.set(speed);
	}
	
	public void setRightIntake(double speed) {
		rightIntake.set(speed);
	}
	public void stop() {
		intake(0);
	}
	
	public void intake(double speed) {
		leftIntake.set(speed);
		rightIntake.set(speed);

	}
			
	@Override
	protected void initDefaultCommand() {
			this.setDefaultCommand(new IntakeCommand());
	}

}
