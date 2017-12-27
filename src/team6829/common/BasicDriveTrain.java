package team6829.common;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;


public class BasicDriveTrain extends Subsystem {

	private RobotDrive robotDrive;
	private Command defaultCommand;
	
	public BasicDriveTrain(int leftFrontCanId, int leftRearCanId, int rightFrontCanId, int rightRearCanId) {
		
		CANTalon leftFrontMotor = new CANTalon(leftFrontCanId);
		CANTalon leftRearMotor = new CANTalon(leftRearCanId);
		CANTalon rightRearMotor  = new CANTalon(rightFrontCanId);
		CANTalon righFrontMotor = new CANTalon(rightRearCanId);
		robotDrive = new RobotDrive(leftFrontMotor, leftRearMotor, rightRearMotor, righFrontMotor);
	
	}
	
	public BasicDriveTrain(RobotDrive robotDrive) {
		this.robotDrive = robotDrive;
	}
	
	public void setDefaultCommand(Command defaultCommand) {
		// TODO Auto-generated method stub
		this.defaultCommand = defaultCommand;
	}

	public void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(defaultCommand);
	}

	public void drive(double throttlePower, double turnPower) {
		
		
	}

	public void drive(double power) {
		robotDrive.setLeftRightMotorOutputs(power, power);
		
	}

	public void turn(double power) {
		// TODO Auto-generated method stub
	
	}

	public void stop() {
		// TODO Auto-generated method stub
		robotDrive.stopMotor();
	}

}
