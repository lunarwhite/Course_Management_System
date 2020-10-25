package objects;

public class Student {

	// variebles
	private String idString;
	private String nameString;
	private String genderString;
	private int score;
	
	//constructors
	public Student() {
		
	}
	
	public Student(String id,String name,String gender,int score) {
		this.idString=id;
		this.nameString=name;
		this.genderString=gender;
		this.score=score;
	}

	//getter & setter
	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getGenderString() {
		return genderString;
	}

	public void setGenderString(String genderString) {
		this.genderString = genderString;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
