public class Car extends Vehicle
{
	protected String licensePlate;
    
	
	public Car(float speed, String LP) 
    {
		
		super(speed);
        this.licensePlate = LP;
	}

    
    public void setMotor(String motor)
    {
        //////////
        this.motor = motor;
    }

    public String getMotor()
    {
        ///////
        return this.motor;
    }

    public String getLicense()
    {
        return licensePlate;
    }

    public void setLicense(String newval)
    {
        this.licensePlate = newval;
    }

	public void left()
    {

    }
    
    public void right()
    {
        
    }

    public void forward()
    {
        
    }

    public void reverse()
    {
        
    }

    public void display()
    {
        System.out.println("this car is going: " + maxSpeed + " mph.\nIts license plate is " + licensePlate);
    }
	
}