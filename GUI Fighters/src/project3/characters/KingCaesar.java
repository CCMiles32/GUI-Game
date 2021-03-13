/////////////////////////////////////////////////////////////////
// Miles Koehnemann
// KingCaesar.java
// Battle Monsters
// CSE 205 - Programming Inheritances
// Time Spent : 4.5 hours
//////////////////////////////////////////////////////////////////
package project3.characters;

import java.awt.Image;

import javax.swing.ImageIcon;

public class KingCaesar extends Fighter {
	public KingCaesar(String name) {
		super(name);
		this.health = 250;
		this.strength = 19;
		this.fighterImage = new ImageIcon("images/KingCesear.jpg");
		Image KCImg = fighterImage.getImage();
		Image KCImage = KCImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		fighterImage = new ImageIcon(KCImage);
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
		return "Class: King Caesar   | " + super.toString();
	}
}
