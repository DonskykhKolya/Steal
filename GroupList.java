package com.gmail.ndonskih63;

public class GroupList {

	public static void main(String[] args) throws DontMoreException {
		Student st1 = new Student("Marhotska", "Anastasia", 21, "female", 3, 108, 95);
		Student st2 = new Student("Yurchenko", "Anna", 20, "female", 3, 110, 63);
		Student st3 = new Student("Bashkatova", "Yana", 20, "female", 3, 101, 70);
		Student st4 = new Student("Kolmakova", "Inna", 20, "female", 3, 107, 82);
		Student st5 = new Student("Donskikh", "Nikolay", 20, "male", 3, 103, 88);
		Student st6 = new Student("Kapitanchuk", "Anastasia", 20, "female", 3, 106, 69);
		Student st7 = new Student("Gnilitskaya", "Darya", 20, "female", 3, 102, 85);
		Student st8 = new Student("Zherebylo", "Tatyana", 20, "female", 3, 105, 53);
		Student st9 = new Student("Shastina", "Anna", 20, "female", 3, 109, 65);
		Student st10 = new Student("Zhalkovskaya", "Alla", 21, "female", 3, 104, 63);
		Student st11 = new Student("Sheynoga", "Stanislav", 20, "male", 3, 111, 40);
		Group myGroup = new Group();

		myGroup.addStudent(st1);
		myGroup.addStudent(st2);
		myGroup.addStudent(st3);
		myGroup.addStudent(st4);
		myGroup.addStudent(st5);
		myGroup.addStudent(st6);
		myGroup.addStudent(st7);
		myGroup.addStudent(st8);
		myGroup.addStudent(st9);
		myGroup.addStudent(st10);
		System.out.println(myGroup);

		try {
			myGroup.addStudent(st11);
		} catch (DontMoreException e) {
			System.out.println(e.getMessage());
			;
		}
		System.out.println();

		System.out.println("Surname sorting:");
		myGroup.sortStudents(ItStudent.surname, true);
		System.out.println(myGroup);
		System.out.println();
		System.out.println("Age sorting:");
		myGroup.sortStudents(ItStudent.age, false);
		System.out.println(myGroup);
		System.out.println("AverageScore sorting:");
		myGroup.sortStudents(ItStudent.averageScore, true);
		System.out.println(myGroup);
		System.out.println();

		myGroup.deleteStudent("Zherebylo");
		myGroup.sortStudents(ItStudent.surname, true);
		System.out.println(myGroup);

		myGroup.addStudent2();
		myGroup.sortStudents(ItStudent.surname, true);
		System.out.println();
		System.out.println(myGroup);
		
		myGroup.saveToFile();
		System.out.println();
		
		ForVoenkom kom = new ForVoenkom();
		for (Student st : kom.recruits(myGroup)) {
			System.out.println(st);
			System.out.println("You are waiting for a Voenkom! \n");
		}
		myGroup.readFile("MyGroup.doc");

	}

}
