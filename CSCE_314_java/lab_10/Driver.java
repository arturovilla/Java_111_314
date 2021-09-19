import java.util.ArrayList;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Block testBlock = new Block("copper", new Location(0, 0, 0), 5);
		System.out.println(testBlock);
		
		// Character textCharacter = new Character
		// good, just checking, but since Character is abstract, can't create an instance
		
		Villain testVillain = new Villain("Creeper", new Location(0, 1, 0), false, "axe", 6);
		System.out.println(testVillain);
		Villain testVillain1 = new Villain("Creeper1", new Location(0, 1, 0), false, "axe", 8);
		System.out.println(testVillain1);

		
		Hero testHero = new Hero("Bowen", new Location(0, 0, 40), Arrays.asList("iron sword", "beef", "flare"), 1, 100) ;
		System.out.println(testHero);
		Hero testHero1 = new Hero("Bowen1", new Location(1, 0, 40), Arrays.asList("iron sword", "beef", "flare"), 2, 10) ;
		System.out.println(testHero1);
		Hero testHero2 = new Hero("Bowen2", new Location(2, 0, 40), Arrays.asList("iron sword", "beef", "flare"), 4, 0) ;
		System.out.println(testHero2);
		Hero testHero3 = new Hero("Bowen3", new Location(3, 0, 40), Arrays.asList("iron sword", "beef", "flare"), 2, 0) ;
		System.out.println(testHero3);

		GameMechanics gm = new GameMechanics();
		ArrayList<Character> BattleRoyale = new ArrayList<Character>();
		//BattleRoyale.add(testBlock); won't work!! (Thankfully)
		//BattleRoyale.add(testVillain);
		BattleRoyale.add(testHero);
		BattleRoyale.add(testHero1);
		BattleRoyale.add(testHero2);
		BattleRoyale.add(testHero3);
		BattleRoyale.add(testVillain);
		BattleRoyale.add(testVillain1);
		//BattleRoyale.add(testVillain);
		boolean ishero = gm.BattleTester(BattleRoyale);

		System.out.println("\nIs the list all heros??: " +  ishero);

		gm.basicWinChances(testHero,testHero1);
		gm.basicWinChances(testHero,testVillain);
		gm.basicWinChances(testVillain1,testVillain);
		// ======= Advanced win chances test ========
		gm.advancedWinChances(testHero,testHero1);
		gm.advancedWinChances(testHero,testVillain);
		gm.advancedWinChances(testVillain1,testVillain);

		//=========== Sorting test cases ============
		System.out.println(BattleRoyale);
		gm.sortedBattlefieldCharacters(BattleRoyale);
		System.out.println("=== AFTER SORT ===\n\n");
		System.out.println(BattleRoyale);
		
		
	}

}
