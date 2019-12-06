import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.GridLayout;

/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Primary view to add Stands, similar to the one to just view them
 */
public class StandAddView extends JFrame{
	protected ImageIcon img;
	protected JLabel icon,imgL,nameL,battlecryL,debutL,masterL,typeL,namesakeL,abilityL,stats,dL,sL,rL,peL,prL,devL;
	protected JTextField nameT,imgT,masterT,typeT,namesakeT,battlecryT,debutT,dT,sT,rT,peT,prT,devT;
	protected String name,image,master,type,namesake,ability,battlecry;
	private Font labelFont;
	protected JButton addStand;
	protected JTextArea abilityT; 
	protected int debut;
	protected char d,s,r,pe,pr,dev;
	
	public StandAddView(String title) {
		super(title);
		
		labelFont=new Font("Sans Serif",Font.PLAIN,18);
		icon=new JLabel();
		icon.setIcon(img);
		nameL=new JLabel("Name:");
		nameL.setFont(labelFont);
		imgL=new JLabel("Image File:");
		imgL.setFont(labelFont);
		battlecryL=new JLabel("Battlecry file:");
		battlecryL.setFont(labelFont);
		debutL=new JLabel("Debut:");
		debutL.setFont(labelFont);
		masterL=new JLabel("Master: ");
		masterL.setFont(labelFont);
		typeL=new JLabel("Type: ");
		typeL.setFont(labelFont);
		namesakeL=new JLabel("Namesake:");
		namesakeL.setFont(labelFont);
		abilityL=new JLabel("Ability:");
		abilityL.setFont(labelFont);
		stats=new JLabel("Stats:");
		stats.setFont(labelFont);
		dL=new JLabel("        Destructive Power:");
		dL.setFont(labelFont);
		sL=new JLabel("        Speed:");
		sL.setFont(labelFont);
		rL=new JLabel("        Range:");
		rL.setFont(labelFont);
		peL=new JLabel("        Persistence:");
		peL.setFont(labelFont);
		prL=new JLabel("        Precision:");
		prL.setFont(labelFont);
		devL=new JLabel("        Development Potential:");
		devL.setFont(labelFont);
		
		nameT=new JTextField();
		nameT.setFont(labelFont);
		imgT=new JTextField();
		imgT.setFont(labelFont);
		masterT=new JTextField();
		masterT.setFont(labelFont);
		typeT=new JTextField();
		typeT.setFont(labelFont);
		namesakeT=new JTextField();
		namesakeT.setFont(labelFont);
		battlecryT=new JTextField();
		battlecryT.setFont(labelFont);
		debutT=new JTextField();
		debutT.setFont(labelFont);
		dT=new JTextField();
		dT.setFont(labelFont);
		sT=new JTextField();
		sT.setFont(labelFont);
		rT=new JTextField();
		rT.setFont(labelFont);
		peT=new JTextField();
		peT.setFont(labelFont);
		prT=new JTextField();
		prT.setFont(labelFont);
		devT=new JTextField();
		devT.setFont(labelFont);
		abilityT=new JTextArea();
		
		addStand=new JButton("Add Stand");
		addStand.setFont(labelFont);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(18,2));
		Border gap=BorderFactory.createEmptyBorder(5,5,5,5);
		p.setBorder(gap);
		
		p.add(nameL);
		p.add(nameT);
		p.add(imgL);
		p.add(imgT);
		p.add(battlecryL);
		p.add(battlecryT);
		p.add(debutL);
		p.add(debutT);
		p.add(masterL);
		p.add(masterT);
		p.add(typeL);
		p.add(typeT);
		p.add(namesakeL);
		p.add(namesakeT);
		p.add(stats);
		p.add(new JLabel());
		p.add(dL);
		p.add(dT);
		p.add(sL);
		p.add(sT);
		p.add(rL);
		p.add(rT);
		p.add(peL);
		p.add(peT);
		p.add(prL);
		p.add(prT);
		p.add(devL);
		p.add(devT);
		p.add(abilityL);
		p.add(abilityT);
		p.add(addStand);
		
		this.add(p);
		this.setVisible(true);
		this.pack();
	}
}