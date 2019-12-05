import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.GridLayout;

/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Primary Encyclopedia view
 */
public class StandView extends JFrame{
	protected ImageIcon img;
	protected JLabel icon,nameL,debutL,masterL,typeL,namesakeL,abilityL,stats,dL,sL,rL,peL,prL,devL;
	protected String name,master,type,namesake,ability,battlecry;
	private Font labelFont;
	protected JButton checkAbility,playBattlecry,checkMaster;
	private int debut;
	private char d,s,r,pe,pr,dev;
	
	public StandView(String title, Stand stando) {
		super(title);
		
		debut=stando.getDebut();
		name=stando.getName();
		master=stando.getMasterName();
		type=stando.getType();
		namesake=stando.getNamesake();
		ability=stando.getAbility();
		d=stando.getDestructive();
		s=stando.getSpeed();
		r=stando.getRange();
		pe=stando.getPersistence();
		pr=stando.getDevelopment();
		dev=stando.getDevelopment();
		battlecry=stando.getBattleCry();
		
		labelFont=new Font("Sans Serif",Font.PLAIN,18);
		icon=new JLabel();
		icon.setIcon(img);
		nameL=new JLabel("Name: "+name);
		nameL.setFont(labelFont);
		debutL=new JLabel("Debut: Part "+debut);
		debutL.setFont(labelFont);
		masterL=new JLabel("Master: ");
		masterL.setFont(labelFont);
		typeL=new JLabel("Type: "+type);
		typeL.setFont(labelFont);
		namesakeL=new JLabel("Namesake: "+namesake);
		namesakeL.setFont(labelFont);
		abilityL=new JLabel("Ability:");
		abilityL.setFont(labelFont);
		stats=new JLabel("Stats:");
		stats.setFont(labelFont);
		dL=new JLabel("        Destructive Power: "+d);
		dL.setFont(labelFont);
		sL=new JLabel("        Speed: "+s);
		sL.setFont(labelFont);
		rL=new JLabel("        Range: "+r);
		rL.setFont(labelFont);
		peL=new JLabel("        Persistence: "+pe);
		peL.setFont(labelFont);
		prL=new JLabel("        Precision: "+pr);
		prL.setFont(labelFont);
		devL=new JLabel("        Development Potential: "+dev);
		devL.setFont(labelFont);
		checkAbility=new JButton("Read ability");
		checkAbility.setFont(labelFont);
		if(battlecry.length()!=28) {
			playBattlecry=new JButton("Play battlecry");
			playBattlecry.setFont(labelFont);
		}
		checkMaster=new JButton(master);
		checkMaster.setFont(labelFont);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(13,2));
		Border gap=BorderFactory.createEmptyBorder(5,5,5,5);
		p.setBorder(gap);
		
		p.add(nameL);
		if(playBattlecry!=null) {
			p.add(playBattlecry);
		}else {
			p.add(new JPanel());
		}
		p.add(debutL);
		p.add(new JLabel());
		p.add(masterL);
		p.add(checkMaster);
		p.add(typeL);
		p.add(new JLabel());
		p.add(namesakeL);
		p.add(new JLabel());
		p.add(stats);
		p.add(new JLabel());
		p.add(dL);
		p.add(new JLabel());
		p.add(sL);
		p.add(new JLabel());
		p.add(rL);
		p.add(new JLabel());
		p.add(peL);
		p.add(new JLabel());
		p.add(prL);
		p.add(new JLabel());
		p.add(devL);
		p.add(new JLabel());
		p.add(abilityL);
		p.add(checkAbility);
		
		this.add(p);
		this.setVisible(true);
		this.pack();
		//this.setBounds(50,50, 900, 600);
	}
}
