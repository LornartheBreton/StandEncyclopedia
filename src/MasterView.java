import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.GridLayout;
/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * View for the Master class
 */
public class MasterView extends JFrame{
	protected JLabel nameL,namesakeL,sexL,yOBL,debutL,heightL;
	String name,namesake;
	protected int debut, yearOfBirth;
	protected double height;
	protected char sex;
	private Font font=new Font("Sans Serif",Font.PLAIN,18);
	
	public MasterView(String title, Master user) {
		super(title);
		
		namesake=user.getNamesake();
		name=user.getName();
		debut=user.getDebut();
		yearOfBirth=user.getYearOfBirth();
		sex=user.getSex();
		height=user.getHeight();
		
		nameL=new JLabel("Name: "+name);
		nameL.setFont(font);
		namesakeL=new JLabel("Namesake: "+namesake);
		namesakeL.setFont(font);
		sexL=new JLabel("Sex: "+sex);
		sexL.setFont(font);
		if(yearOfBirth!=0) {
			heightL=new JLabel("Height: "+height+" m.");
			heightL.setFont(font);
			yOBL=new JLabel("Year of Birth: "+yearOfBirth);
			yOBL.setFont(font);
		}
		debutL=new JLabel("Debut: Part "+debut);
		debutL.setFont(font);
		
		JPanel p=new JPanel();
		if(yearOfBirth==0) {
			p.setLayout(new GridLayout(4,1));
		}else {
			p.setLayout(new GridLayout(6,1));
		}
		Border gap=BorderFactory.createEmptyBorder(5,5,5,5);
		p.setBorder(gap);
		
		p.add(nameL);
		p.add(namesakeL);
		p.add(sexL);
		if(yearOfBirth!=0) {
			p.add(yOBL);
			p.add(heightL);
		}
		p.add(debutL);
		
		this.add(p);
		this.setVisible(true);
		this.pack();
	}
}
