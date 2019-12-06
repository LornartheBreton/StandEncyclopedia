/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Clase que modela a un Stand User/Master
 */
public class Master <T extends Comparable<T>>{
	private String name;
	private String namesake;
	private double height;
	private char sex;
	private int yearOfBirth;
	private String image;
	private int debut;
	//Two constructors because we dont have all the info of all Stand users
	public Master(String name, String namesake, char sex, int debut,String image) {
		this.name = name;
		this.namesake = namesake;
		this.debut = debut;
		this.sex=sex;
		this.image=image;
	}

	public Master(String name, String namesake, double height, char sex, int yearOfBirth, String image,
			int debut) {
		this.name = name;
		this.namesake = namesake;
		this.height = height;
		this.sex = sex;
		this.yearOfBirth = yearOfBirth;
		this.image = image;
		this.debut = debut;
	}
	//Obligatory Search and default constructors
	public Master(String name) {
		this.name=name;
	}
	
	public Master() {

	}
	//getters & setters mostly (its the most basic class)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamesake() {
		return namesake;
	}

	public void setNamesake(String namesake) {
		this.namesake = namesake;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getImage() {
		//In case no image is found (done because some of the pics used to give me headaches)
		String ans="Data/NF.png";
		if(image!=null)
			ans="Data/Users/Pics/"+image;
		return ans;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getDebut() {
		return debut;
	}

	public void setDebut(int debut) {
		this.debut = debut;
	}
	//Name is my comparison criteria because no Stand Masters share the same name
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Master other = (Master) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public int compareTo(Master comp) {
		return name.compareTo(comp.name);
	}
	
	public String toString() {
		StringBuilder build=new StringBuilder();
		
		build.append("\nStand Master");
		build.append("\n	Name: "+name);
		build.append("\n	Namesake: "+namesake);
		build.append("\n	Sex: "+sex);
		if(yearOfBirth!=0) {
			build.append("\n	Height: "+height+" m.");
			build.append("\n	Year of Birth: "+yearOfBirth);
		}
		build.append("\n	Debut: Part "+debut);
		
		return build.toString();
	}
}
