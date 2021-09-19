public abstract class Vehicle 
{
	protected float maxSpeed;
    protected String motor;
    
	
	public Vehicle(float speed) 
    {
		
		this.maxSpeed = speed;
	}

    public abstract void setMotor(String motor);

    public abstract String getMotor();

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
        System.out.println("this vehicle is going: " + maxSpeed + " mph." );
    }
	
}