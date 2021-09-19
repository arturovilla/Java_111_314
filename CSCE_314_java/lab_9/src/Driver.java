public class Driver
{

	public static void main(String[] args)
	{
		float speed = 75;
		String LP  = "4564156156156156";

		String FN = "9988";
		String company = "American Airlines";



		Car newcar = new Car(speed,LP);
		newcar.setMotor("combustion");
		newcar.display();
		System.out.println("the car's motor is " +  newcar.getMotor() );
		
		Airplane plane = new Airplane(speed,FN,company,"civilian","n/a","USA");
		plane.setMotor("jet");
		plane.display();
		System.out.println("the plane's motor is " +  plane.getMotor() + "\n\n");


		Airplane plane2 = new Airplane(speed,FN,company,"Warplane","rocket","USA");
		plane2.setMotor("jet");
		plane2.display();
		plane2.fireWeapon();
		
		
	}

}
