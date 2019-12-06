import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;;

/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Primary Encyclopedia view
 */
public class PrimaryView extends JFrame{
	protected Encyclopedia enc=new Encyclopedia();//the one and only Encyclopedia object
	protected ArrayList<JButton> buttons;//I dont kno how many buttons I need
	protected JButton addStand,removeStand,update;
	protected JTextField search;//My search bar
	protected int size;
	protected Font font;//In order for text to be readable
	protected ArrayList<Stand> list;
	protected JScrollPane scrollPane;//Need to scroll because unknown number of elements
	
	public PrimaryView(String title) {
		super(title);
		JButton temp;
		String name;
		list=new ArrayList<Stand>();
		font=new Font("Sans Serif",Font.PLAIN,18);//The perfect font size for this: clear and a decent size
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
		removeStand=new JButton("Remove Stand");
		removeStand.setFont(font);
		update=new JButton("Update");
		update.setFont(font);
		search=new JTextField(12);
		search.setFont(font);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(0,3));
		//GridBagConstraints c=new GridBagConstraints();
		Border gap=BorderFactory.createEmptyBorder(5,5,5,5);
		p.setBorder(gap);
		scrollPane=new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//Setting up the GUI layout
		p.add(removeStand);
		p.add(search);
		p.add(addStand);
		p.add(new JLabel());
		p.add(buttons.get(0));
		p.add(update);
		p.add(new JLabel());
		p.add(buttons.get(1));
		p.add(new JLabel());
		//adding countless buttons
		for(int i=2;i<size;i++) {
			p.add(new JLabel());
			p.add(buttons.get(i));
			p.add(new JLabel());
		}
		
		this.add(scrollPane);
		this.setVisible(true);
		this.pack();//done so the JFrame scales proportionately
		//this.setBounds(50,50, 900, 800); decided againts using this because what if 900X800 is too small/big?
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
