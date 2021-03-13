/////////////////////////////////////////////////////////////////
// Miles Koehnemann
// Godzilla.java
// Battle Monsters
// CSE 205 - Programming Inheritances
// Time Spent : 4.5 hours
//////////////////////////////////////////////////////////////////
package project3.characters;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Godzilla extends Fighter {
    public Godzilla(String name) {
        super(name);
        this.health = 1000;
        this.strength = 16; 
        this.fighterImage = new ImageIcon("images/Godzilla.png");
		Image GzImg = fighterImage.getImage();
		Image GZImage = GzImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		fighterImage = new ImageIcon(GZImage);
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
        return "Class: Godzilla      | " + super.toString();
    }
}