/////////////////////////////////////////////////////////////////
// Miles Koehnemann
// Monke.java
// Battle Monsters
// CSE 205 - Programming Inheritances
// Time Spent : 4.5 hours
//////////////////////////////////////////////////////////////////
package project3.characters;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Monke extends Fighter {
	public Monke(String name) {
		super(name);
		this.health = 250;
		this.strength = 19;
		this.fighterImage = new ImageIcon("images/KingKong.png");
		Image KKImg = fighterImage.getImage();
		Image KKImage = KKImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		fighterImage = new ImageIcon(KKImage);
	}

	@Override
	public int attack() {
		return strength;
	}

	@Override
	public void hit(int points) {
		this.health -= points;
	}

	@Override
	public boolean isAlive() {
		return health >= 0;
	}
	@Override
    public ImageIcon getImage() {
    	return fighterImage;
    }
	@Override
	public String toString() {
		return "Class: Monke         | " + super.toString();
	}
}
