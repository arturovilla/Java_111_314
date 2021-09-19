import java.util.ArrayList;
import java.util.List;

public class GameMechanics
{
	public GameMechanics() {	}
	
	public static boolean BattleTester(ArrayList<?> list)
    {

        for (int i = 0; i < list.size(); i++)
        {
            int armour;
            try
            {
                Hero testHero = (Hero) list.get(i);
                armour = testHero.getArmour();
            }
            catch(Exception e)
            {
                System.out.println("Error list does not contain only heros!!!!!!!");
                return false;
            }
        }
        return true;


    }

    public static void sortedBattlefieldCharacters(ArrayList<Character> list)
    {
        for(int i = 0; i < list.size()- 1; i++)
        {
            for(int j = 0; j < list.size()- 1 - i; j++)
            {
                if(list.get(j+1).getHearts() > list.get(j).getHearts() )
                {
                    Character Ttmp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,Ttmp);
                }
            }
        }
    }

    public static <E extends Character> void advancedWinChances(E obj1, E obj2)
    {
        if(obj1 instanceof Hero  && obj2 instanceof Villain)
        {
            Hero my1 = (Hero) obj1;
            if(my1.getArmour() == 100)
            {
                int newheart1 = (int) (1.5 * my1.getHearts());
                my1.setHearts(newheart1);
            }
            

            Villain my2 = (Villain) obj2;
            
            basicWinChances(my1, my2);
            return ;
        }
        if(obj1 instanceof Villain && obj2 instanceof Hero)
        {
            Villain my1 = (Villain) obj1;
            
            Hero my2 = (Hero) obj2;
            if(my2.getArmour() == 100)
            {
                int newheart2 = (int) (1.5 * my2.getHearts());
                my2.setHearts(newheart2);
            }

            basicWinChances(my1, my2);
            return;
        }
    }

    public static <E extends Character> void basicWinChances(E obj1, E obj2)
    {
        if(obj1 instanceof Hero && obj2 instanceof Hero)
        {
            System.out.println("HEROS DO NOT FIGHT HEROS \n");
            return;
        }
        if(obj1 instanceof Villain && obj2 instanceof Villain)
        {
            System.out.println("villains DO NOT FIGHT villains \n");
            return;
        }


        if(obj1 instanceof Hero)
        {
            Hero my1 = (Hero) obj1;
            Villain my2 = (Villain) obj2;

            if(my1.getHearts() > my2.getHearts())
            {
                System.out.println("HERO IS PREDICTED TO WIN BY A RATIO OF: " + my1.getHearts() + " to " + my2.getHearts() + "\n");
            }
            if(my1.getHearts() < my2.getHearts())
            {
                System.out.println("VILLIAN IS PREDICTED TO WIN BY A RATIO OF: " + my2.getHearts() + " to " + my1.getHearts() + "\n");
            }
            if(my1.getHearts() == my2.getHearts())
            {
                System.out.println("WINNER CANNOT BE PREDICETED");
            }
            return;
        }
        if(obj1 instanceof Villain)
        {
            Villain my1 = (Villain) obj1;
            Hero my2 = (Hero) obj2;

            if(my1.getHearts() > my2.getHearts())
            {
                System.out.println("VILLAIN IS PREDICTED TO WIN BY A RATIO OF: " + my1.getHearts() + " to "+my2.getHearts() + "\n");
            }
            if(my1.getHearts() < my2.getHearts())
            {
                System.out.println("HERO IS PREDICTED TO WIN BY A RATIO OF: " + my2.getHearts() + " to "+ my1.getHearts() + "\n");
            }
            if(my1.getHearts() == my2.getHearts())
            {
                System.out.println("WINNER CANNOT BE PREDICETED");
            }
            return;
        }
    }
	
}
