import java.util.Scanner;
/*
Name: Arturo Villalobos
UIN: 827008236
Date: 3-1-21
Assignment: Lab Work Week 7.1

so i thought the exercise methods assigment was the lab and i thought i was due on friday my bad
*/

/*Instructions: Refer to the instructions on Canvas.
*/

class lab7_1 {
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    String dogname;
    int dogage;
    welcome();
    System.out.print("What is your dog's name?");
    dogname = input.nextLine();
    dogName(dogname);
    System.out.print("How old is "+ dogname+"?");
    dogage = input.nextInt();
    int realage = dogYears(dogage);
    System.out.println(" "+dogname+" is "+ realage + " years old in human years!\n");
    exit();




  } //end main

  public static void welcome()
  {
    System.out.println("Hello! Welcome to the program.\n");
  }//end welcome

  public static void dogName(String name)
  {
    System.out.println(" Your dog's name is "+name+". That is so cute!\n");
    System.out.println("Let's convert "+name+"'s age into human years!");

  }//end dogName

  public static int dogYears(int years)
  {
    return years*7;    

  }//end dogYears
  
  public static void exit()
  {
    System.out.println("Thanks for stopping by!");
  }//end exit
} //end class
