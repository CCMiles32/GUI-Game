/////////////////////////////////////////////////////////////////
// Miles Koehnemann
// MecaGodzilla.java
// Battle Monsters
// CSE 205 - Programming Inheritances
// Time Spent : 4.5 hours
//////////////////////////////////////////////////////////////////
package project3.characters;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Mecagodzilla extends Fighter {
    public Mecagodzilla(String name) {
        super(name);
        this.health = 80;
        this.strength = 40; 
        this.fighterImage = new ImageIcon("images/MecaGodzilla.png");
		Image MGImg = fighterImage.getImage();
		Image MGImage = MGImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		fighterImage = new ImageIcon(MGImage);
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
        return "Class: MecaGodzilla  | " + super.toString();
    }
}