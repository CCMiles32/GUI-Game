import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Toolkit;

import project3.characters.Fighter;
import project3.characters.Godzilla;
import project3.characters.Mecagodzilla;
import project3.characters.Monke;
import project3.characters.KingCaesar;

@SuppressWarnings("serial")
public class MainMenu extends JFrame implements ActionListener {

	JLabel title;
	JButton fightButton;
	JLabel background;
	JRadioButton oneVSone;
	JRadioButton twoVStwo;
	JComboBox fighter1;  
	JComboBox fighter2;  
	JComboBox fighter3;
	JComboBox fighter4;
	public static boolean oneVrsOne;
	
	public static Fighter[] characters;
	
	
	Fighter monke = new Monke("Monke");
	Fighter godzilla = new Godzilla("Godzilla");
	Fighter mecagodzilla = new Mecagodzilla("MecaGodzilla");
	Fighter KingCaesar = new KingCaesar("KingCaeser");
	

	
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	MainMenu() {

		ImageIcon mainMenuBackground = new ImageIcon("images/mainMenuBackground.jpg");
		Image MMBImg = mainMenuBackground.getImage();
		Image MMBImage = MMBImg.getScaledInstance(500, 400, java.awt.Image.SCALE_SMOOTH);
		mainMenuBackground = new ImageIcon(MMBImage);
		
		Border titleboarder = BorderFactory.createLineBorder(Color.black, 3);

		fightButton = new JButton();                              //
		fightButton.setBounds(150, 400, 200, 50);                 //
		fightButton.setText("FIGHT");                             //
		fightButton.setFont(new Font("Serif", Font.BOLD, 20));    //
		fightButton.setFocusable(false);                          //   ------ Fight button
		fightButton.addActionListener(this);                      // 
		fightButton.setHorizontalTextPosition(JButton.CENTER);    //
		fightButton.setVerticalTextPosition(JButton.CENTER);      //

		title = new JLabel();                                     //
		title.setText("PICK YOUR BATTLE");                        //
		title.setBounds(150, 25, 200, 50);                        //
		title.setBorder(titleboarder);                            //   ------- Title
		title.setVerticalAlignment(JLabel.CENTER);                //
		title.setHorizontalAlignment(JLabel.CENTER);              //

		background = new JLabel();                                //
		background.setBounds(0, 300, 500, 400);                   //   --------- Background
		background.setIcon(mainMenuBackground);                   //

		oneVSone = new JRadioButton("1 v 1");                     //
		twoVStwo = new JRadioButton("2 v 2");                     //
		ButtonGroup battleSize = new ButtonGroup();               //
		battleSize.add(oneVSone);                                 //  ------ Button for 
		battleSize.add(twoVStwo);                                 //         1v1 or 2v2  
		oneVSone.addActionListener(this);                         //         
		twoVStwo.addActionListener(this);                         //
		
		String[] characterList = {"Monke", "Godzilla", "MecaGodzilla", "KingCaesar"}; 
		fighter1 = new JComboBox(characterList);                  //
		fighter2 = new JComboBox(characterList);                  //
		fighter3 = new JComboBox(characterList);                  //   ------ Character List
		fighter4 = new JComboBox(characterList);                  //
		
		fighter1.addActionListener(this);
		fighter2.addActionListener(this);
		fighter3.addActionListener(this);
		fighter4.addActionListener(this);
		fighter1.disable();
		fighter2.disable();
		fighter3.disable();
		fighter4.disable();
		fightButton.disable();
		
//		characters[0] = new Godzilla("Godzilla");
//		characters[1] = new KingCaesar("King Caesar");
//		characters[2] = new Mecagodzilla("MecaGodzilla");
//		characters[3] = new Monke("Monke");
	
		
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.add(title);
		this.add(fightButton);

		this.add(oneVSone);
		this.add(twoVStwo);
		this.add(fighter1);
		this.add(fighter2);
		this.add(fighter3);
		this.add(fighter4);
		
		this.add(background);
		//this.pack();

	}


	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent input) {
		if (input.getSource() == fightButton) {
			System.out.println("Main " + characters);
			System.out.println("-------------------------------------");
			for (int i = 0; i < characters.length; i++) {
				System.out.println("Fighter " + i + " " + characters[i].getName());
			}
			System.out.println("-------------------------------------");
			this.dispose();
			new FightWindow();
			
		}
		if (input.getSource() == oneVSone) {
			fighter1.enable();
			fighter2.enable();
			fighter3.disable();
			fighter4.disable();
			characters = new Fighter[2];
			oneVrsOne = true;
			System.out.println("one" + oneVrsOne);
		}
		if (input.getSource() == twoVStwo) {
			fighter1.enable();
			fighter2.enable();
			fighter3.enable();
			fighter4.enable();
			characters = new Fighter[4];
			oneVrsOne = false;
			System.out.println("two" + oneVrsOne);
		}
		if (input.getSource() == fighter1) {                          //
			if (fighter1.getSelectedIndex() == 0) {                   //
				characters[0] = new Monke("Monke");                   //
			} else if (fighter1.getSelectedIndex() == 1) {            //
				characters[0] = new Godzilla("Godzilla");             //
			} else if (fighter1.getSelectedIndex() == 2) {            // --------------- Fills character based on checkbox
				characters[0] = new Mecagodzilla("MecaGodzilla");     //
			} else if (fighter1.getSelectedIndex() == 3) {            //
				characters[0] = new KingCaesar("King Caesar");        //
			}
			System.out.println(characters[0]);
		}
		if (input.getSource() == fighter2) {
			if (fighter2.getSelectedIndex() == 0) {
				characters[1] = new Monke("Monke");
			} else if (fighter2.getSelectedIndex() == 1) {
				characters[1] = new Godzilla("Godzilla");
			} else if (fighter2.getSelectedIndex() == 2) {
				characters[1] = new Mecagodzilla("MecaGodzilla");
			} else if (fighter2.getSelectedIndex() == 3) {
				characters[1] = new KingCaesar("King Caesar");
			}
			System.out.println(characters[1]);
		}
		if (input.getSource() == fighter3) {
			if (fighter3.getSelectedIndex() == 0) {
				characters[2] = new Monke("Monke");
			} else if (fighter3.getSelectedIndex() == 1) {
				characters[2] = new Godzilla("Godzilla");
			} else if (fighter3.getSelectedIndex() == 2) {
				characters[2] = new Mecagodzilla("MecaGodzilla");
			} else if (fighter3.getSelectedIndex() == 3) {
				characters[2] = new KingCaesar("King Caesar");
			}
			System.out.println(characters[2]);
		}
		if (input.getSource() == fighter4) {
			if (fighter4.getSelectedIndex() == 0) {
				characters[3] = new Monke("Monke");
			} else if (fighter4.getSelectedIndex() == 1) {
				characters[3] = new Godzilla("Godzilla");
			} else if (fighter4.getSelectedIndex() == 2) {
				characters[3] = new Mecagodzilla("MecaGodzilla");
			} else if (fighter4.getSelectedIndex() == 3) {
				characters[3] = new KingCaesar("King Caesar");
			}
			System.out.println(characters[3]);
		}

	}

}

// action listener to see if 1v1 / 2v2 hide boxes if false 
// combo boxes to get fighters
// open new window with selected fighters
// Button for specific attack, another button for specific opponent
// figure out how to get Ai to attack target
// after battle new page with logs and Victor, "finish - close" play again main window
