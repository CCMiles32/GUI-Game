import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import project3.characters.Godzilla;
import project3.characters.KingCaesar;
import project3.characters.Mecagodzilla;
import project3.characters.Monke;

public class FightWindow extends MainMenu implements ActionListener {
	
	static JFrame frame = new JFrame();
	
	JButton fightButton;
	JButton attack1Button;
	JButton attack2Button;
	static JButton target1Button;
	JButton target2Button;
	JButton fleeButton;
	JLabel background1v1;
	JLabel background2v2;
	JLabel fighter1Image;
	JLabel fighter2Image;
	JLabel fighter3Image;
	JLabel fighter4Image;
	static JTextArea battleLog;
	static boolean attack1;
	static boolean attack2;
	static boolean attackRight;
	static boolean target = false;

	
	FightWindow() {
		
		
		ImageIcon fightBackground = new ImageIcon("images/oneVoneFightBackground.png");
		System.out.println("FW Const " + characters);
		
//		ImageIcon godzillaImage = new ImageIcon("images/Godzilla.png");
//		Image GzImg = godzillaImage.getImage();
//		Image GZImage = GzImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
//		godzillaImage = new ImageIcon(GZImage);
//		ImageIcon mecagodzillaImage = new ImageIcon("images/MecaGodzilla.png");
//		Image MGImg = mecagodzillaImage.getImage();
//		Image MGImage = MGImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
//		mecagodzillaImage = new ImageIcon(MGImage);
//		ImageIcon monkeImage = new ImageIcon("images/KingKong.png");
//		Image KKImg = monkeImage.getImage();
//		Image KKImage = KKImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
//		monkeImage = new ImageIcon(KKImage);
//		ImageIcon kingCaesarImage = new ImageIcon("images/KingCaesar.jpg");
//		Image KCImg = kingCaesarImage.getImage();
//		Image KCImage = KCImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
//		kingCaesarImage = new ImageIcon(KCImage);

		
		
		
		fightButton = new JButton();
		fightButton.setText("FIGHT");
		fightButton.setBounds(0, 426, 760, 100);   ////////////    Fight Button
		fightButton.setFocusable(false);
		fightButton.setVisible(true);
		fightButton.addActionListener(this);
		
		attack1Button = new JButton();
		attack1Button.setText("Attack 1");
		attack1Button.setBounds(0, 426, 380, 100);   
		attack1Button.setFocusable(false);         ///////////////      Attack 1 Button
		attack1Button.setVisible(false);
		attack1Button.addActionListener(this);
		
		attack2Button = new JButton();
		attack2Button.setText("Attack 2");
		attack2Button.setBounds(380, 426, 380, 100);   
		attack2Button.setFocusable(false);        ///////////////////     Attack 2 button
		attack2Button.setVisible(false);
		attack2Button.addActionListener(this);
		
		
		target1Button = new JButton();
		target1Button.setText("Target 1");
		target1Button.setBounds(0, 426, 380, 100);   
		target1Button.setFocusable(false);       ///////////////////     Target 1 button
		target1Button.setVisible(false);
		target1Button.addActionListener(this);
		
		target2Button = new JButton();
		target2Button.setText("Target 2");
		target2Button.setBounds(380, 426, 380, 100);  ///////////////////     Target 2 button
		target2Button.setFocusable(false);
		target2Button.setVisible(false);
		target2Button.addActionListener(this);
		
	
		fleeButton = new JButton();              ///////////////////     Flee button
		fleeButton.setText("Flee");
		fleeButton.setBounds(0, 525, 760, 86);   
		fleeButton.setFocusable(false);
		fleeButton.setVisible(true);
		fleeButton.addActionListener(this);
		
		
		battleLog = new JTextArea();   ///////////////////      Battle Log 
		battleLog.setText("");
		battleLog.setText("BATTLE START ---------------------------------\n");
		battleLog.setLineWrap(true);
		battleLog.setWrapStyleWord(true);
		battleLog.setBackground(new Color(150, 150, 150));
		battleLog.setBorder(BorderFactory.createBevelBorder(1));
		battleLog.setFont(new Font("Comic Sans", Font.BOLD, 20));
		battleLog.setEditable(false);
		battleLog.setBounds(0, 611, 760, 260);
		//battleLog.setText("Foo"); // replaces whats already there
//test	//battleLog.append("She reached her goal, exhausted. Even more chilling to her was that the euphoria that she thought she'd feel upon reaching it wasn't there. Something wasn't right. Was this the only feeling she'd have for over five years of hard work?She reached her goal, exhausted. Even more chilling to her was that the euphoria that she thought she'd feel upon reaching it wasn't there. Something wasn't right. Was this the only feeling she'd have for over five years of hard work?She reached her goal, exhausted. Even more chilling to her was that the euphoria that she thought she'd feel upon reaching it wasn't there. Something wasn't right. Was this the only feeling she'd have for over five years of hard work?She reached her goal, exhausted. Even more chilling to her was that the euphoria that she thought she'd feel upon reaching it wasn't there. Something wasn't right. Was this the only feeling she'd have for over five years of hard work?She reached her goal, exhausted. Even more chilling to her was that the euphoria that she thought she'd feel upon reaching it wasn't there. Something wasn't right. Was this the only feeling she'd have for over five years of hard work?"); // adds to the bottom
		
		JScrollPane scroll = new JScrollPane(battleLog);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		/////////////////////////////////////////////////////////////// IMAGES
		
		
		background1v1 = new JLabel();                             //
		background1v1.setBounds(0, -147, 1280, 720);              //   --------- Background
		background1v1.setIcon(fightBackground);                   //
		
		
		fighter1Image = new JLabel();                    ///////////////////   Fighter 1 Image (you)
		fighter1Image.setIcon(characters[0].getImage());
		fighter1Image.setBounds(120, 300, 100, 100);
		
		fighter2Image = new JLabel();                    ///////////////////   Fighter 2 Image (enemy)
		fighter2Image.setIcon(characters[1].getImage());
		fighter2Image.setBounds(430, 110, 100, 100);
		System.out.println(oneVrsOne);
		
		if(!oneVrsOne) {
			fighter3Image = new JLabel();                /////////////////     Fighter 3 Image (teamate)
			fighter3Image.setIcon(characters[2].getImage());
			fighter3Image.setBounds(330, 300, 100, 100);
		
			fighter4Image = new JLabel();                /////////////////     Fighter 4 Image (enemy)
			fighter4Image.setIcon(characters[3].getImage());
			fighter4Image.setBounds(580, 115, 100, 100);
		}
		
		
		
		////////////////////////////////////////////////////////////////
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(776, 910);
		frame.setLayout(null);                 //     --------------------------------------------  Frame Building 
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		frame.add(fightButton);  
		frame.add(battleLog);
		frame.add(scroll);
		frame.add(attack1Button);
		frame.add(attack2Button);
		frame.add(fleeButton);                      //     --------------------------------------------  Component adding 
		frame.add(fighter1Image);
		frame.add(fighter2Image);
		if(!oneVrsOne) {
			frame.add(fighter3Image);
			frame.add(fighter4Image);
		}
		frame.add(target1Button);
		frame.add(target2Button);
		
		
		
		frame.add(background1v1);
	}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  // Battle LOGIC
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public static Random rand = new Random();
	    private static boolean isTurn;
	    static int damage;
	    

	    public static void fight() {
			isTurn = true;
			if (oneVrsOne) {
				target = true;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
				System.out.println("INTERUPTED DELAY");
			}
			System.out.println("TEST---------------------------------------------------");
			System.out.println("attack1 " + attack1);
			System.out.println("attack2 " + attack2);
			System.out.println("target " + target);
			
			if (characters[0].getHealth() > 0 && characters[1].getHealth() > 0) {
			if (isTurn && (attack1 == true || attack2 == true) && (target == true)) {
				if (attack1 == true) {
					damage = (int) (Math.random() * characters[0].getStrength()) + 10;
					System.out.println("attack one");
				} else if (attack2 == true) {
					damage = (int) (Math.random() * characters[0].getStrength()) + 5;
					System.out.println("attack two");
				}
				if (characters[1].getHealth() < 0) {
					outCome();
				}
				characters[1].hit(damage);
				System.out.println("\nYou hit" + characters[1].getName() + " for " + damage + " . He had " + characters[1].getHealth() + " health remaining.");
				battleLog.append("\nYou hit" + characters[1].getName() + " for " + damage + " . He had " + characters[1].getHealth() + " health remaining.");
				isTurn = false;
			}
			if (isTurn == false) {
				damage = (int) (Math.random() * characters[1].getStrength());
				characters[0].hit(damage);
				if (characters[1].getHealth() < 0) {
					outCome();
				}
				System.out.println("\nYour opponent hit you for  " + damage + ". You have " + characters[0].getHealth()+ " health remaining.");
				battleLog.append("\nYour opponent hit you for  " + damage + ". You have " + characters[0].getHealth()+ " health remaining.");
				isTurn = true;
	        }
			} else {
				outCome();
			}
	    }
	    /////////////////////////////////////////////////////////////////////////////////////////////
	    ///////////////////////////////////////////////////////////////////////////////////////////// 
	    /////////////////////////////////////////////////////////////////////////////////////////////
	    //2v2 Battle
	    
	    public static void fightTwo() {
	    	int roundCount = 0;
			isTurn = true;
			String attackSide;
			int attackWho;

			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
				System.out.println("INTERUPTED DELAY");
			}
			System.out.println("TEST");
			System.out.println("attack1 " + attack1);
			System.out.println("attack2 " + attack2);
			System.out.println("target " + target);
			
			if ((characters[0].getHealth() > 0 || characters[2].getHealth() > 0) && (characters[1].getHealth() > 0 || characters[3].getHealth() > 0)) {
				if (isTurn && (attack1 == true || attack2 == true) && (target == true)) {
					if (attack1 == true) {
						damage = (int) (Math.random() * characters[0].getStrength()) + 10;
						System.out.println("attack one");
					} else if (attack2 == true) {
						damage = (int) (Math.random() * characters[0].getStrength()) + 5;
						System.out.println("attack two");
					}
					if (attackRight == false) {
						characters[1].hit(damage);
						attackSide = "Attack 1";
						System.out.println("\nYou hit " + characters[1].getName() + " with " + attackSide + " for " + damage + " . He had " + characters[1].getHealth() + " health remaining.");
						battleLog.append("\nYou hit " + characters[1].getName() + " with " + attackSide + " for " + damage + " . He had " + characters[1].getHealth() + " health remaining.");
					} else {
						characters[3].hit(damage); 
						attackSide = "Attack 2";
						System.out.println("\n" + "You hit " + characters[3].getName() + " with " + attackSide + " for " + damage + " . He had " + characters[3].getHealth() + " health remaining.");
						battleLog.append("\n" + "You hit " + characters[3].getName() + " for " + damage + " . He had " + characters[3].getHealth() + " health remaining.");
					}

					isTurn = false;
					target = false;
					attack1 = false;
					attack2 = false;
				}
				if (isTurn == false) {
					if (characters[2].getHealth() > 0) {          ///////////////////////  character 3 (teamate) fight turn (1 is friendly)
						attackWho = (int)(Math.random()*3 + 1);
						System.out.println("Character 3 attackWho = " + attackWho);
						damage = (int) (Math.random() * characters[2].getStrength());
						if((attackWho == 1) || (attackWho == 2) ) {
							characters[1].hit(damage);
							System.out.println("\n" + characters[2].getName() + " hits " + characters[1].getName() + " for " + damage + " . He has " + characters[1].getHealth() + " health remaining.");
							battleLog.append("\n" + characters[2].getName() + " hits " + characters[1].getName() + " for " + damage + " . He has " + characters[1].getHealth() + " health remaining.");
						}else {
							characters[3].hit(damage);
							System.out.println("\n" + characters[2].getName() + "hits " + characters[3].getName() + " for " + damage + " . He has " + characters[3].getHealth() + " health remaining.");
							battleLog.append("\n" + characters[2].getName() + " hits" + characters[3].getName() + " for " + damage + " . He has " + characters[3].getHealth() + " health remaining.");
						}
					}
					if (characters[1].getHealth() > 0) {       ///////////////////////  character 2 (enemy) fight turn (4 is friendly)
						attackWho = (int)(Math.random()*3 + 1);
						System.out.println("Character 2 attackWho = " + attackWho);
						damage = (int) (Math.random() * characters[1].getStrength());
						if((attackWho == 1) || (attackWho == 2) ) {
							characters[0].hit(damage);
							System.out.println("\n" + characters[1].getName() + "hits " + characters[0].getName() + " for " + damage + " . He has " + characters[0].getHealth() + " health remaining.");
							battleLog.append("\n" + characters[1].getName() + " hits " + characters[0].getName() + " for " + damage + " . He has " + characters[0].getHealth() + " health remaining.");
						}else {
							characters[2].hit(damage);
							System.out.println("\n" + characters[1].getName() + "hits " + characters[2].getName() + " for " + damage + " . He has " + characters[2].getHealth() + " health remaining.");
							battleLog.append("\n" + characters[1].getName() + " hits " + characters[2].getName() + " for " + damage + " . He has " + characters[2].getHealth() + " health remaining.");
						}
					}
					if (characters[3].getHealth() > 0) {         ///////////////////////  character 4 (enemy) fight turn (2 if friendly)
						attackWho = (int)(Math.random()*3 + 1);
						System.out.println("Character 4 attackWho = " + attackWho);
						damage = (int) (Math.random() * characters[3].getStrength());
						if((attackWho == 1) || (attackWho == 2) ) {
							characters[0].hit(damage);
							System.out.println("\n" + characters[3].getName() + "hits " + characters[0].getName() + " for " + damage + " . He has " + characters[0].getHealth() + " health remaining.");
							battleLog.append("\n" + characters[3].getName() + " hits " + characters[0].getName() + " for " + damage + " . He has " + characters[0].getHealth() + " health remaining.");
						}else {
							characters[2].hit(damage);
							System.out.println("\n" + characters[3].getName() + "hits " + characters[2].getName() + " for " + damage + " . He has " + characters[2].getHealth() + " health remaining.");
							battleLog.append("\n" + characters[3].getName() + " hits " + characters[2].getName() + " for " + damage + " . He has " + characters[2].getHealth() + " health remaining.");
						}
					}
					
					isTurn = true;
				}
			} else {
				outCome();
			}
		}
	    

	    public static void outCome() {

	        if (characters[0].getHealth() > 0 || characters[2].getHealth() > 0) {
	            victory();
	        } else {
	            defeat();
	        }
	    }

	    private static void victory() {
	        System.out.println("Congradulations you have defeated " + characters[1].getName());
	        battleLog.append("Congradulations you have defeated " + characters[1].getName());
	        System.out.println(".............................................");
	        frame.dispose();
			new MainMenu();
			JOptionPane.showMessageDialog(null, "YOU ARE VICTORIUS \n MAKE A NEW BATTLE", "YOUVE WON", JOptionPane.ERROR_MESSAGE);
	    }

	    private static void defeat() {
	        System.out.println("You have been slain.");
	        battleLog.append("You have been slain.");
	        System.out.println("..............................................");
	        frame.dispose();
			new MainMenu();
			JOptionPane.showMessageDialog(null, "YOU HAVE BEEN DEFEATED \n MAKE A NEW BATTLE", "YOUVE LOST", JOptionPane.ERROR_MESSAGE);
	    }
		
	    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    // Battle Logic
	    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == fightButton) {
			System.out.println("player will attack");
			fightButton.setVisible(false);
			attack1Button.setVisible(true);
			attack2Button.setVisible(true);
			attack1 = false;
			attack2 = false;
			
		}
		if (e.getSource() == attack1Button) {
			attack1 = true;
			attack1Button.setVisible(false);
			attack2Button.setVisible(false);
			if(!oneVrsOne) {
				target1Button.setVisible(true);
				target2Button.setVisible(true);
			}else{
				fightButton.setVisible(true);
			}
			if(oneVrsOne == false) {
				fightTwo();
			}else {
				fight();
			}
		}
		if (e.getSource() == attack2Button) {
			attack2=true;
			attack1Button.setVisible(false);
			attack2Button.setVisible(false);
			if(!oneVrsOne) {
				target1Button.setVisible(true);
				target2Button.setVisible(true);
			}else{
				fightButton.setVisible(true);
			}
			if(oneVrsOne == false) {
				fightTwo();
			}else {
				fight();
			}
		}
		if (e.getSource() == target1Button) {
			target1Button.setVisible(false);
			target2Button.setVisible(false);
			fightButton.setVisible(true);
			attackRight = false;
			target = true;
			if(oneVrsOne == false) {
				fightTwo();
			}else {
				fight();
			}
		}
		if (e.getSource() == target2Button) {
			target1Button.setVisible(false);
			target2Button.setVisible(false);
			fightButton.setVisible(true);
			attackRight = false;
			target = true;
			if(oneVrsOne == false) {
				fightTwo();
			}else {
				fight();
			}
		}
		if (e.getSource() == fleeButton) {
			frame.dispose();
			new MainMenu();
			JOptionPane.showMessageDialog(null, "PICK A NEW BATTLE", "YOUVE FLED", JOptionPane.ERROR_MESSAGE);

		}

	}
} 	

