import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Primary view controller
 */
public class PrimaryController extends PrimaryView{
	StandController stando;
	ImageView img;
	
	public PrimaryController(String title) {
		super (title);
		
		for(int i=0; i<size;i++) {
			buttons.get(i).addActionListener(new standListener());
		}
		search.addActionListener(new searchListener());
		addStand.addActionListener(new addStandListener());
		update.addActionListener(new updateListener());
	}
	
	private class updateListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			ArrayList<Stand> list=new ArrayList<Stand>();
			
			removeScrollPane();
			enc.readStandFile();
			enc.readStandFile();
			list=enc.returnAsList();
			updateScrollPane(list);
		}
	}
	private class standListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Stand t;
			Master user;
			String name=e.getActionCommand(),master;
			
			t=enc.exactStandSearch(name);
			master=t.getMasterName();
			user=enc.exactMasterSearch(master);
			img=new ImageView(name,t.getImage());
			stando=new StandController(name,t,user);
		}
		
	}
	
	private class addStandListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			StandAddController add=new StandAddController("Add Stand");
		}
		
	}
	
	private void removeScrollPane(){
		remove(scrollPane);	
	}
	
	private void updateScrollPane(ArrayList<Stand> list) {
		JPanel p=new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		Border gap=BorderFactory.createEmptyBorder(5,5,5,5);
		p.setBorder(gap);
		scrollPane=new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
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
		c.ipadx=10;
		c.ipady=20;
		c.gridy=0;
		c.gridx=2;
		p.add(addStand,c);
		c.gridy=1;
		c.gridx=2;
		p.add(addMaster,c);
		c.gridx=0;
		c.gridy=0;
		p.add(removeStand,c);
		c.gridx=0;
		c.gridy=1;
		p.add(removeMaster,c);
		for(int i=0; i<size;i++) {
			buttons.get(i).addActionListener(new standListener());
		}
		search.addActionListener(new searchListener());
		addStand.addActionListener(new addStandListener());
		
		this.add(scrollPane);
		this.setVisible(true);
	}
	
	private class searchListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String search=e.getActionCommand();
			String name;
			JButton temp;
			
			buttons=new ArrayList<JButton>();
			list=enc.returnAsList(search);
			size=list.size();
			for(int i=0;i<list.size();i++) {
				name=list.get(i).getName();
				temp=new JButton(name);
				temp.setFont(font);
				buttons.add(temp);
			}
			removeScrollPane();
			updateScrollPane(list);
		}
		
	}
}
