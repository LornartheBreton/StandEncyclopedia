import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Main Encyclopedia class
 */
public class Encyclopedia {
	private Stand[][] stands;
	private Master[][] masters;
	private int[] standsCounter= {0,0,0};
	private int[] mastersCounter= {0,0,0};
	private final int PARTS=3;
	private final int MAX_STANDS=33;
	
	public Encyclopedia() {
		stands=new Stand[PARTS][MAX_STANDS];
		masters=new Master[PARTS][MAX_STANDS];
	}
	
	public boolean addMaster(String name, String namesake, double height, char sex, int yearOfBirth, String image,
			int debut) {
		boolean ans=false;
		Master add;
		
		if(mastersCounter[debut-3]<MAX_STANDS) {
			ans=true;
			if(height==0.0) {
				add= new Master(name,namesake,sex,debut);
			}else {
				add=new Master(name,namesake,height,sex,yearOfBirth,image,debut);
			}
			debut-=3;
			masters[debut][mastersCounter[debut]]=add;
			mastersCounter[debut]++;
		}
		return ans;
	}
	
	public void readMasterFile() {
		File master=new File("Data/standMasters.csv");
		Master add;
		String name,nameSake,image;
		double height;
		char sex;
		int yearOfBirth,debut;
		
		try (Scanner scn=new Scanner(master)){
			scn.nextLine();
			while(scn.hasNext()) {
				scn.useDelimiter(",|\\n");
				name=scn.next();
				//System.out.println(name);
				nameSake=scn.next();
				//System.out.println(nameSake);
				height=scn.nextDouble();
				//System.out.println(height);
				sex=scn.next().charAt(0);
				//System.out.println(sex);
				yearOfBirth=scn.nextInt();
				//System.out.println(yearOfBirth);
				image=scn.next();
				//System.out.println(image);
				debut=Integer.parseInt(String.valueOf(scn.next().charAt(0)));
				//System.out.println(debut);
				addMaster(name,nameSake,height,sex,yearOfBirth,image,debut);
				//System.out.println(yearOfBirth);
			}
			
			scn.close();
		}catch(FileNotFoundException fnfe) {
			System.err.println("Could not find standMaster file"+fnfe);
			System.exit(-1);
		}
	}
	
	public Master getMaster(int x, int y) {
		x-=3;
		return masters[x][y];
	}
}
