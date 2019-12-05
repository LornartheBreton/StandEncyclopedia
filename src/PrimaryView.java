import javax.swing.*;
import javax.swing.border.Border;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;;

/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Primary Encyclopedia view
 */
public class PrimaryView extends JFrame{
	protected Encyclopedia enc=new Encyclopedia();
	protected ArrayList<JButton> buttons=new ArrayList<JButton>();
	protected JTextField search;
	protected JScrollBar s;  
	protected int size;
	
	public PrimaryView(String title) {
		super(title);
		JButton temp;
		String name;
		
		size=enc.returnAsList().size();
		s=new JScrollBar();
		s.setBounds(100,100, 50,100); 
		for(int i=0;i<size;i++) {
			//System.out.println(enc.returnAsList());
			name=enc.returnAsList().get(i).getName();
			temp=new JButton(name);
			buttons.add(temp);
			//System.out.println(buttons.get(i).getActionCommand());
		}
		search=new JTextField(12);
		
		JPanel p=new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		Border gap=BorderFactory.createEmptyBorder(5,5,5,5);
		p.setBorder(gap);
		
		c.ipadx=600;
		c.ipady=20;
		c.gridx=0;
		c.gridy=0;
		p.add(search,c);
		c.ipadx=600;
		c.ipady=10;
		for(int i=1;i<size;i++) {
			c.gridy=i;
			p.add(buttons.get(i-1),c);
		}
		c.gridx=1;
		p.add(s,c);
		this.add(p);
		this.setVisible(true);
		//this.pack();
		this.setBounds(50,50, 900, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
