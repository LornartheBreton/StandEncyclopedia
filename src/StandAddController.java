import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Controller to add stands
 */
public class StandAddController extends StandAddView{
	
	public StandAddController(String title) {
		super(title);
		
		addStand.addActionListener(new AddStandListener());
	}
	
	private class AddStandListener implements ActionListener{
		ArrayList<String> back=new ArrayList<String>();
		
		public void actionPerformed(ActionEvent e) {
			int dd=Integer.parseInt(debutT.getText());
			File stands=new File("Data/stands.csv");//Have to reRead and rewrite file
			String misc,m2;
			StringBuilder build=new StringBuilder();
			
			name=nameT.getText();
			image=imgT.getText();
			master=masterT.getText();
			debut=dd;
			type=typeT.getText();
			namesake=namesakeT.getText();
			d=dT.getText().charAt(0);
			s=sT.getText().charAt(0);
			r=rT.getText().charAt(0);
			pe=peT.getText().charAt(0);
			pr=prT.getText().charAt(0);
			dev=devT.getText().charAt(0);
			ability=abilityT.getText();
			if(!battlecryT.getText().isEmpty()) {
				battlecry=battlecryT.getText();
			}
			
			try(Scanner scn=new Scanner(stands,"UTF-8")){
				while(scn.hasNextLine()) {
					misc=scn.nextLine();
					back.add(misc);
				}
				dd=back.size();
				misc=back.get(dd-1);
				
				back.remove(dd-1);
				build.append(name+",");
				build.append(master+",");
				build.append(debut+",");
				build.append(d+",");
				build.append(s+",");
				build.append(r+",");
				build.append(pe+",");
				build.append(pr+",");
				build.append(dev+",");
				build.append(type+",");
				build.append(ability+",");
				build.append(image+",");
				if(battlecry==null) {
					build.append(",");
				}else {
					build.append(battlecry+",");
				}
				build.append(namesake);
				m2=build.toString();
				back.add(m2);
				back.add(misc);

				scn.close();
				
				try(FileWriter fileWriter = new FileWriter("Data/stands.csv")){
					 PrintWriter printWriter = new PrintWriter(fileWriter);
					 
					 printWriter.print("name,master,debut,destructive,speed,range,persistence,precision,development,type,ability,image,battleCry,namesake\n");
					 for(int i=1;i<dd;i++) {
						 misc=back.get(i);
						printWriter.print(misc+"\n"); 
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
	
	
}
