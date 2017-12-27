package org.usfirst.frc.team6829.robot.commands;

import org.usfirst.frc.team6829.robot.OI;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import team6829.common.BasicDriveTrain;
import team6829.common.IPowerTransform;

/**
 *
 */
public class ArcadeDriveCommand extends Command {

	private final int THROTTLE_AXIS;
	private final int ROTATE_AXIS;
	private final int USE_ALTERNATE_BUTTON;

	
	private BasicDriveTrain driveTrain;
	private Joystick driverJoyStick;
	
	private IPowerTransform defaultTransform;
	private IPowerTransform alternateTransform;
	

   
    public ArcadeDriveCommand(Joystick driverJoystick, BasicDriveTrain driveTrain, 
    		IPowerTransform defaultTransform, IPowerTransform alternateTransform, int throttleId, int turnId, int useAtlernateId) {
    	
    	this.THROTTLE_AXIS = throttleId;
    	this.ROTATE_AXIS = turnId;
    	this.USE_ALTERNATE_BUTTON = useAtlernateId;
    	this.defaultTransform = defaultTransform;
    	this.alternateTransform = alternateTransform;
        this.driveTrain = driveTrain;
        this.driverJoyStick = driverJoystick;
        requires(this.driveTrain);
        
    }
    
    
    


    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	   	
    	double driverStickRawAxis = driverJoyStick.getRawAxis(THROTTLE_AXIS);    	
    	
    	double driveTrainPower = defaultTransform.transform(driverStickRawAxis);
    	
    	if (!driverJoyStick.getRawButton(USE_ALTERNATE_BUTTON)) {
    		driveTrainPower = alternateTransform.transform(driverStickRawAxis);
    	}
   	
    	driveTrain.drive(driveTrainPower);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
