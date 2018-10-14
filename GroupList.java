package com.gmail.ndonskih63;

import java.io.File;
import java.io.IOException;

public class GroupList {	

	public static void main(String[] args) throws DontMoreException {
		
		Student person = new Student("Sheynoga", "Stanislav", 20, "male", 3, 111, 40);
		Group myGroup = new Group();

		myGroup.addStudent(new Student("Marhotska", "Anastasia", 21, "female", 3, 108, 95));
		myGroup.addStudent(new Student("Yurchenko", "Anna", 20, "female", 3, 110, 63));
		myGroup.addStudent(new Student("Bashkatova", "Yana", 20, "female", 3, 101, 70));
		myGroup.addStudent(new Student("Kolmakova", "Inna", 20, "female", 3, 107, 82));
		myGroup.addStudent(new Student("Donskikh", "Nikolay", 20, "male", 3, 103, 88));
		myGroup.addStudent(new Student("Kapitanchuk", "Anastasia", 20, "female", 3, 106, 69));
		myGroup.addStudent(new Student("Gnilitskaya", "Darya", 20, "female", 3, 102, 85));
		myGroup.addStudent(new Student("Zherebylo", "Tatyana", 20, "female", 3, 105, 53));
		myGroup.addStudent(new Student("Shastina", "Anna", 20, "female", 3, 109, 65));
		myGroup.addStudent(new Student("Zhalkovskaya", "Alla", 21, "female", 3, 104, 63));
		System.out.println(myGroup);
		try {
			myGroup.addStudent(person);
		} catch (DontMoreException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		System.out.println("Surname sorting:");
		myGroup.sortStudents(ItStudent.surname, true);
		System.out.println(myGroup);
		System.out.println();

		myGroup.deleteStudent("Zherebylo");
		
		myGroup.addStudent(person);
		myGroup.sortStudents(ItStudent.surname, true);
		System.out.println(myGroup);
	
		
		ForVoenkom kom = new ForVoenkom();
		for (Student st : kom.recruits(myGroup)) {
			System.out.println(st);
			System.out.println("You are waiting for a Voenkom! \n");
		}
		
		File file = new File("MyGroup.txt");
		
		myGroup.addToDataBase(file);
		Group yourGroup = new Group();
		yourGroup.readFromDataBase(file);
		System.out.println(yourGroup.toString());
		
	}

}
