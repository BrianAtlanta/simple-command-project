package Fakes;

import edu.wpi.first.wpilibj.RobotDrive;

public class FakeRobotDrive extends RobotDrive {

	
    public FakeRobotDrive() {
    	super(0, 0, 0, 0);
	}
    
	public double leftPower = Double.MIN_VALUE;
    public double rightPower = Double.MIN_VALUE;
    
    
	public void setLeftRightMotorOutputs(double leftPower, double rightPower) {
	
		this.leftPower = leftPower;
		this.rightPower = rightPower;
	}
}
