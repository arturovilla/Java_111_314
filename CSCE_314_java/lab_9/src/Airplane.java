public class Airplane extends Vehicle implements Warplane
{
	
    protected String flightNumber;
    protected String company;
    protected String Airplane_type;
    protected String weapon_type;
    protected String country; 
	
	public Airplane(float speed, String FN, String company, String type, String weapon, String country) 
    {
		
		super(speed);
        this.flightNumber = FN;
        this.company = company;
        this.Airplane_type = type;
        this.weapon_type = weapon;
        this.country = country;
	}

    public void setCountry(String country)
    {
        this.country = country;
    }

	public String getCountry()
    {
        return country;
    }
	
	public void fireWeapon()
    {
        System.out.println("BOOOOOOOM");
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

    void setFlightNumber(String FN)
    {
        this.flightNumber = FN;
    }

    void setCompany(String company)
    {
        this.company = company;
    }

    public String getFlightNumber()
    {
        return flightNumber;
    }

    public String getCompany()
    {
        return company;
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
        System.out.println("this plane is going: " + maxSpeed + " mph.\nIts flight number is: " + flightNumber+ "\nThe companyu flying is: " + company + ".\nthis plane is of type: " + Airplane_type + ".\nthe weapons on this plane: " + weapon_type + ".\nCountry of origin: " + country);
    }
	
}