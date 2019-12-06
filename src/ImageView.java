import javax.swing.JFrame;

import java.awt.Image;

import javax.swing.*;
/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Class to view an image
 */
public class ImageView extends JFrame{
	private ImageIcon icon;
	private JLabel img;
	private int x,y;
	private final int MAX_RESOLUTION=900,H=500,W=700;
	
	public ImageView (String title, String imgPath) {
		super(title);
		
		System.out.println(imgPath);
		icon=new ImageIcon(imgPath);
		x=icon.getIconHeight();
		y=icon.getIconWidth();
		//System.out.println(x+" "+y);
		if(x>MAX_RESOLUTION||y>MAX_RESOLUTION) {
			icon=new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance(H, W, Image.SCALE_DEFAULT));
			//System.out.println(x+" "+y);
		}
		img=new JLabel(icon);
		
		this.add(img);
		this.pack();
		this.setVisible(true);
	}
}
