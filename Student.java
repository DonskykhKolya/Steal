package com.gmail.ndonskih63;

public class Student extends Human implements Serializable{

	private int course;
	private int recBookNum;
	private int averageScore;
	
	public Student(String surname, String name, int age, String sex, 
					int course, int recBookNum, int averageScore) {
		super(surname, name, age, sex);
		this.course = course;
		this.recBookNum = recBookNum;
		this.averageScore = averageScore;
	}
	public Student() {
		super();
	}
	public int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		this.course = course;
	}
	public int getRecBookNum() {
		return recBookNum;
	}
	public void setRecBookNum(int recBookNum) {
		this.recBookNum = recBookNum;
	}
	public int getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}
	@Override
	public String toString() {
		return super.toString() + ", course: " + course + ", recBookNum: " + recBookNum + ", averageScore: " + averageScore;
	}
	
}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

