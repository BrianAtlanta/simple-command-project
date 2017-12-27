package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Fakes.FakeRobotDrive;
import team6829.common.BasicDriveTrain;

class DriveTrain {

	
	@Test
	void DriveTrainCanDriveStraight() {
		FakeRobotDrive robotDrive = new FakeRobotDrive();
		BasicDriveTrain driveTrain = new BasicDriveTrain(robotDrive);
		driveTrain.drive(.4);
		assertEquals(robotDrive.leftPower, .4);
		assertEquals(robotDrive.rightPower, .4);
		
	}

}
