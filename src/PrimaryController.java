import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	ImageView img;//Viewer for all images, no interaction, doesnt need a controller
	
	public PrimaryController(String title) {
		super (title);
		
		for(int i=0; i<size;i++) {
			buttons.get(i).addActionListener(new standListener());
		}
		search.addActionListener(new searchListener());
		addStand.addActionListener(new addStandListener());
		update.addActionListener(new updateListener());
		removeStand.addActionListener(new removeStandListener());
	}
	//Listener for the remove Stand button
	private class removeStandListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ArrayList<String> back=new ArrayList<String>();
			String n=search.getText(),misc;
			File stands=new File("Data/stands.csv");
			System.out.println(n);
			//Used UTF-8 because I used Excel to make the csvs and Excel encodes in UTF-8
			try(Scanner scn=new Scanner(stands,"UTF-8")){
				while(scn.hasNextLine()) {
					misc=scn.nextLine();
					//System.out.println(misc.contains(n));
					if(!misc.contains(n+",")) {
						back.add(misc);
					}
				}
				
				scn.close();
				
				try(FileWriter fileWriter = new FileWriter("Data/stands.csv")){
					 PrintWriter printWriter = new PrintWriter(fileWriter);
					 
					 printWriter.print("name,master,debut,destructive,speed,range,persistence,precision,development,type,ability,image,battleCry,namesake\n");
					 for(int i=1;i<back.size();i++) {
						misc=back.get(i);
						System.out.println(misc);
						printWriter.print(misc+"\n");//It would not work whitout the \n 
					 }
					 printWriter.close();
				} catch (IOException IOE) {
					PopUp p=new PopUp(IOE.getMessage());
				}
				
			} catch (FileNotFoundException fnfe) {
				PopUp p=new PopUp(fnfe.getMessage());
			}
		}
		
	}
	//Listener for the update button
	private class updateListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			ArrayList<Stand> list=new ArrayList<Stand>();
			
			removeScrollPane();
			enc.readStandFile();
			list=enc.returnAsList();
			//System.out.println(list);
			updateScrollPane(list);
		}
	}
	//Looks up master and Stand and lauches the windows
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
	//Stand listener. Just opens the window
	private class addStandListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			StandAddController add=new StandAddController("Add Stand");
		}
		
	}
	//This is needed for the updates 
	private void removeScrollPane(){
		remove(scrollPane);	
	}
	//Updates view after rereading files
	private void updateScrollPane(ArrayList<Stand> list) {
		String name;
		JButton temp;
		
		size=list.size();
		buttons=new ArrayList<JButton>();
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(0,3));
		Border gap=BorderFactory.createEmptyBorder(5,5,5,5);
		p.setBorder(gap);
		scrollPane=new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		for(int i=0;i<size;i++) {
			name=list.get(i).getName();
			temp=new JButton(name);
			temp.setFont(font);
			buttons.add(temp);
		}
		p.add(removeStand);
		p.add(search);
		p.add(addStand);
		p.add(new JLabel());
		p.add(buttons.get(0));
		p.add(update);
		p.add(new JLabel());
		p.add(buttons.get(1));
		p.add(new JLabel());
		
		for(int i=2;i<size;i++) {
			p.add(new JLabel());
			p.add(buttons.get(i));
			p.add(new JLabel());
		}
		
		this.add(scrollPane);
		this.setVisible(true);
		this.pack();
		//this.setBounds(50,50, 900, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		for(int i=0; i<size;i++) {
			buttons.get(i).addActionListener(new standListener());
		}
		search.addActionListener(new searchListener());
		addStand.addActionListener(new addStandListener());

		this.add(scrollPane);
		this.setBounds(50,50, 900, 800);//Didnt use pack here because it removes the scroll bar for some reason
		this.setVisible(true);
	}
	//Listener for search bar
	private class searchListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String search=e.getActionCommand();
			String name;
			JButton temp;
			
			//remakes the list
			buttons=new ArrayList<JButton>();
			list=enc.returnAsList(search);
			size=list.size();
			for(int i=0;i<list.size();i++) {
				name=list.get(i).getName();
				temp=new JButton(name);
				temp.setFont(font);
				buttons.add(temp);
			}
			//updates the JFrame
			updateScrollPane(list);
		}
		
	}
}
