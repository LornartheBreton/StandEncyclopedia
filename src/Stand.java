/*
 * Copyright Hector G. T. Torres	191589
 * 11/2019
 * A STAND
 */
public class Stand <T extends Comparable <T>>{
	private String name;
	private String masterName;
	private int[] masterReference=new int[2];
	private char[] stats=new char[6];
	private String type;
	private String ability;
	private String battleCry;
	private String namesake;//Most Stands are named after bands, songs or Tarot cards (i.e. Red Hot Chilli Peppers, Dirty Deeds Done Dirt Cheap, The World)
	private String image;
	//Two constructors because not all Stands have Battlecries (i.e. Love Deluxe)
	public Stand(String name, String master, char[] stats, String type, String ability, String namesake,
			String image,int x, int y) {
		this.name = name;
		masterName = master;
		this.stats = stats;
		this.type = type;
		this.ability = ability;
		this.namesake = namesake;
		this.image = image;
		masterReference[0]=x;
		masterReference[1]=y;
	}

	public Stand(String name, String master, char[] stats, String type, String ability, String namesake,
			String image,int x,int y,String battleCry) {
		this.name = name;
		masterName = master;
		this.stats = stats;
		this.type = type;
		this.ability = ability;
		this.namesake = namesake;
		this.image = image;
		masterReference[0]=x;
		masterReference[1]=y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String master) {
		masterName = master;
	}

	public char[] getStats() {
		return stats;
	}

	public void setStats(char[] stats) {
		this.stats = stats;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getBattleCty() {
		return battleCry;
	}

	public void setBattleCty(String battleCry) {
		this.battleCry = battleCry;
	}

	public String getNamesake() {
		return namesake;
	}

	public void setNamesake(String namesake) {
		this.namesake = namesake;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public char getDestructive() {
		return stats[0];
	}
	
	public void setDestructive(char a) {
		stats[0]=a;
	}
	
	public char getSpeed() {
		return stats[1];
	}
	
	public void setSpeed(char a) {
		stats[1]=a;
	}
	
	public char getRange() {
		return stats[2];
	}
	
	public void setRange(char a) {
		stats[2]=a;
	}
	
	public char getPersistence() {
		return stats[3];
	}
	
	public void setPersistence(char a) {
		stats[3]=a;
	}
	
	public char getPrecision() {
		return stats[4];
	}
	
	public void setPrecicison(char a) {
		stats[4]=a;
	}
	
	public char getDevelopment() {
		return stats[5];
	}
	
	public void setDevelopment(char a) {
		stats[5]=a;
	}
	//Name is my comparison criteria because every Stand has a unique name
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
		Stand other = (Stand) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public int compareTo(Stand comp) {
		return name.compareTo(comp.name);
	}
	
	public String toString() {
		StringBuilder build=new StringBuilder();
		
		build.append("\nStand");
		build.append("\n	Name: "+name);
		build.append("\n	Master: "+masterName);
		build.append("\n	Type: "+type);
		build.append("\n	Namesake: "+namesake);
		build.append("\n	Ability: "+ability);
		build.append("\n	Stats:");
		build.append("\n		Destructive Power: "+stats[0]);
		build.append("\n		Speed: "+stats[1]);
		build.append("\n		Range: "+stats[2]);
		build.append("\n		Persistence: "+stats[3]);
		build.append("\n		Precision: "+stats[4]);
		build.append("\n		Development Potential: "+stats[5]);
		
		return build.toString();
	}
}
