/////////////////////////////////////////////////////////////////
// Miles Koehnemann
// BattleRoyale.java
// Battle Monsters
// CSE 205 - Programming Inheritances
// Time Spent : 2 hours
//////////////////////////////////////////////////////////////////
package project3;

import java.util.Random;

import project3.characters.Fighter;
import project3.characters.Godzilla;
import project3.characters.KingCaesar;
import project3.characters.Mecagodzilla;
import project3.characters.Monke;

public class BattleRoyale {

	public static int numAlive(Fighter[] characters) {
		int count = 0;
		for (int i = 0; i < characters.length; i++) {
			if (characters[i].isAlive())
				count++;
		}

		return count;
	}

	public static void main(String[] args) {

		Fighter[] characters = new Fighter[4];
		characters[0] = new Godzilla("Godzilla");
		characters[1] = new KingCaesar("King Caesar");
		characters[2] = new Mecagodzilla("MecaGodzilla");
		characters[3] = new Monke("Monke");

		Random rand = new Random();
		int attackerIndex, index;

		System.out.println("Fighters: \n--------------------------------------------------------------------");
		for (int i = 0; i < characters.length; i++) {
			System.out.println(characters[i]);
		}
		System.out.println();

		while (numAlive(characters) > 1) {
			attackerIndex = rand.nextInt(characters.length);
			while (!characters[attackerIndex].isAlive())
				attackerIndex = rand.nextInt(characters.length);

			index = rand.nextInt(characters.length);

			while ((attackerIndex == index) || (!characters[index].isAlive())) {
				index = rand.nextInt(characters.length);
			}

			System.out.println(characters[attackerIndex].getName() + " attacked " + characters[index].getName());
			characters[index].hit(characters[attackerIndex].attack());
			System.out.println(characters[index].getName() + "'s health: " + characters[index].getHealth() + "\n");
		}

		System.out.println("\nResults: \n------------------------------------------------------------------ ");

		for (int i = 0; i < characters.length; i++) {
			System.out.println(characters[i]);
		}

		for (int i = 0; i < characters.length; i++) {
			if (characters[i].isAlive()) {
				System.out.println("------------------------------------------------------------------\n"
						+ characters[i].getName() + " is the winner.");

			}
		}

	}
}
