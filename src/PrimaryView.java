import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Font;
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
	protected JButton addStand,addMaster,removeStand,removeMaster,update;
	protected JTextField search;
	protected int size;
	protected Font font;
	protected ArrayList<Stand> list;
	protected JScrollPane scrollPane;
	
	public PrimaryView(String title) {
		super(title);
		JButton temp;
		String name;
		list=new ArrayList<Stand>();
		font=new Font("Sans Serif",Font.PLAIN,18);
		list=enc.returnAsList();
		size=list.size();
		buttons= new ArrayList<JButton>();
		
		for(int i=0;i<size;i++) {
			name=list.get(i).getName();
			temp=new JButton(name);
			temp.setFont(font);
			buttons.add(temp);
		}
		addStand=new JButton("Add Stand");
		addStand.setFont(font);
		addMaster=new JButton("Add Master");
		addMaster.setFont(font);
		removeStand=new JButton("Remove Stand");
		removeStand.setFont(font);
		removeMaster=new JButton("Remove Master");
		removeMaster.setFont(font);
		update=new JButton("Update");
		update.setFont(font);
		search=new JTextField(12);
		search.setFont(font);
		
		JPanel p=new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		Border gap=BorderFactory.createEmptyBorder(5,5,5,5);
		p.setBorder(gap);
		scrollPane=new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		c.ipadx=300;
		c.ipady=20;
		c.gridx=1;
		c.gridy=0;
		p.add(search,c);
		c.ipadx=300;
		c.ipady=10;
		for(int i=1;i<=size;i++) {
			c.gridy=i;
			p.add(buttons.get(i-1),c);
		}
		c.ipadx=10;
		c.ipady=20;
		c.gridy=0;
		c.gridx=2;
		p.add(addStand,c);
		c.gridy=1;
		c.gridx=2;
		p.add(addMaster,c);
		c.gridy=2;
		c.gridx=2;
		p.add(update,c);
		c.gridx=0;
		c.gridy=0;
		p.add(removeStand,c);
		c.gridx=0;
		c.gridy=1;
		p.add(removeMaster,c);
		
		this.add(scrollPane);
		this.setVisible(true);
		//this.pack();
		this.setBounds(50,50, 900, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
