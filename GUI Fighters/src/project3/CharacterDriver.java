/////////////////////////////////////////////////////////////////
// Miles Koehnemann
// CharacterDrive.java
// Battle Monsters
// CSE 205 - Programming Inheritances
// Time Spent : 4.5 hours
//////////////////////////////////////////////////////////////////

package project3;

import project3.characters.Fighter;
import project3.characters.Godzilla;
import project3.characters.Mecagodzilla;
import project3.characters.Monke;

import java.util.Random;
import java.util.Scanner;

public class CharacterDriver {

	public static void main(String[] args) {
		
		
		Fighter fighter1;
		Fighter fighter2;
		
		Fighter monke = new Monke("Monke");
		Fighter godzilla = new Godzilla("Godzilla");
		Fighter mecagodzilla = new Mecagodzilla("MecaGodzilla");
		
		System.out.println("Who would you like to battle?");
		System.out.println("1 : Godzilla \n2 : MecaGodzilla \n3 : Monke");
		Scanner dan = new Scanner(System.in);
		int input = dan.nextInt();
		if (input == 1){
			fighter1 = godzilla;
		}else if(input == 2){
			fighter1 = mecagodzilla;
		}else {
			fighter1 = monke;
		}

		System.out.println("1 : Godzilla \n2 : MecaGodzilla \n3 : Monke \n dont click the same monster");
		int input2 = dan.nextInt();
		if (input2 == 1){
			fighter2 = godzilla;
		}else if(input2 == 2){
			fighter2 = mecagodzilla;
		}else {
			fighter2 = monke;
		}
		dan.close();
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\nCharacters:");
		System.out.println("\n" + fighter1);
		System.out.println(fighter2);

		System.out.println("\nDuel Start");

		Random random = new Random();
		int round = 1;

		while (fighter1.isAlive() && fighter2.isAlive()) {

			int numOfAttackByfighter1 = random.nextInt(5);

			for (int i = 0; i < numOfAttackByfighter1; i++) {
				fighter2.hit(fighter1.attack());
			}

			int numOfAttackByfighter2 = random.nextInt(5);

			for (int i = 0; i < numOfAttackByfighter2; i++) {
				fighter1.hit(fighter2.attack());
			}
			System.out.println("\nStats After Round " + round + " :\n");
			System.out.println(fighter1);
			System.out.println(fighter2);
			round++;
		}

		System.out.println("\nFight Finished");

		if (!fighter1.isAlive()) {
			System.out.println("\n" + fighter1.getName() + " has won.");
		} else {
			System.out.println("\n" + fighter2.getName() + " has won.");
		}
	}
}


	