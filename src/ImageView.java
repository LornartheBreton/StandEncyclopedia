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
	/*
	 * Chose these dimensions because I tried scaling both x and y
	 * proportionately by 0.7 and it would horribly distort all images.
	 * So, since most pictures are about 9:16, I figured this would not distort is as much 
	 */
	private final int MAX_RESOLUTION=900,H=500,W=700;
	
	public ImageView (String title, String imgPath) {
		super(title);
		
		icon=new ImageIcon(imgPath);
		x=icon.getIconHeight();
		y=icon.getIconWidth();
		//If above a threshhold, resizes the image
		if(x>MAX_RESOLUTION||y>MAX_RESOLUTION) {
			icon=new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance(H, W, Image.SCALE_DEFAULT));
		}
		img=new JLabel(icon);
		
		this.add(img);
		this.pack();
		this.setVisible(true);
	}
}
