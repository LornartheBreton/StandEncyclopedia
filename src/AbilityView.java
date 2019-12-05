import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Class to see stand abilities in detail (because they're long)
 */
public class AbilityView extends JFrame{
	JTextArea ability;
	Font font=new Font("Sans Serif",Font.PLAIN,18);
	
	public AbilityView(String title,String ability) {
		super(title);
		
		this.ability=new JTextArea(ability);
		this.ability.setFont(font);
		this.ability.setLineWrap(true);
		this.ability.setWrapStyleWord(true);
		this.add(this.ability);
		this.setBounds(50,50, 300, 400);
		this.setVisible(true);
	}
}
