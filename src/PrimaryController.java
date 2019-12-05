import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringWriter;
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
	}
	
	private class standListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Stand t;
			String name=e.getActionCommand();
			
			t=enc.findStand(name).get(0);
			System.out.println(enc.getMaster(t.getMasterReference()[0], t.getMasterReference()[1]).toString());
			stando=new StandController(name,t);
			img=new ImageView(name,t.getImage());
		}
		
	}
}
