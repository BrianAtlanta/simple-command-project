package team6829.common;

public final class SquaredInputTransform implements IPowerTransform {
	
	private double _dampenValue = 1;
	
	public SquaredInputTransform() {}
	
	public SquaredInputTransform(double dampenValue)
	{
		_dampenValue = dampenValue;
	}
	public double transform (double input) {
		
		double result = 0;
		double sign = 0;
		
		if (input < 0) {
			sign = -1;
		} else if (input > 0) {
			sign = 1;
		}
		
		result = Math.pow(input, 2) * _dampenValue;
		
		result *= sign;
		return result;
	}
	


}
