/////////////////////////////////////////////////////////////////
// Miles Koehnemann
// Fighters.java
// Battle Monsters
// CSE 205 - Programming Inheritances
// Time Spent : 4.5 hours
//////////////////////////////////////////////////////////////////
package project3.characters;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Fighter {

	protected String name;
	protected int strength;
	protected int health;
	protected ImageIcon fighterImage;

	
	public Fighter(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public int getStrength() {
		return strength;
	}


	public int getHealth() {
		return health; 
	}
	public ImageIcon getImage() {
		return fighterImage;
	}


	public abstract int attack();

	public abstract void hit(int points);

	
	public abstract boolean isAlive();

	@Override
	public String toString() {
		return "Name: " + name + ", Strength: " + strength + ", Health: " + health;
	}
}