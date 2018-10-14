package com.gmail.ndonskih63;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class Group implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Student[] students = new Student[10];

	public Group(Student[] students) {
		super();
		this.students = students;
	}

	public Group() {
		super();
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}


	public int groupSize() {
		return students.length;
	}

	public void addStudent(Student student) throws DontMoreException {
		for (int i = 0; i < students.length; i++) {
			if (this.studentsAmount() >= students.length) {
				throw new DontMoreException();
			} else {
				if (students[i] == null) {
					students[i] = student;
					break;
				}
			}
		}
}

	public Student searchStudent(String surname) {
		for (Student s : students) {
			if (s != null && s.getSurname().equals(surname)) {
				return s;
			}
		}
		System.out.println("There is no such student in group");
		return null;
	}

	public Student searchStudent(int number) {
		if (number - 1 >= 0 && number < students.length) {
			return students[number - 1];
		} else {
			System.out.println("Wrong index");
			return null;
		}
	}

	public void deleteStudent(String name) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getSurname().equalsIgnoreCase(name)) {
				System.out.format("%s was deleted from the group\n\n",
						students[i].getSurname() + " " + students[i].getName());
				students[i] = null;
				return;
			}
		}
		System.out.format("\nThere is no %s in the group, that's why he wasn't deleted", name);
	}

	public int studentsAmount() {
		int counter = 0;
		for (Student s : students) {
			if (s != null) {
				counter++;
			}
		}
		return counter;
	}

	public void sortStudents(ItStudent itStudent, boolean place) {
		int myPlace = place ? 1 : -1;
		Arrays.sort(this.students, (st1, st2) -> {
			if (st1 == null && st2 != null) {
				return -myPlace;
			}
			if (st1 != null && st2 == null) {
				return myPlace;
			}
			if (st1 != null && st2 == null) {
				return 0;
			}
			if (itStudent == ItStudent.surname) {
				return place ? st1.getSurname().compareTo(st2.getSurname())
						: -st1.getSurname().compareTo(st2.getSurname());
			}
			if (itStudent == ItStudent.age) {
				return place ? st1.getAge() - st2.getAge() : st2.getAge() - st1.getAge();
			}
			if (itStudent == ItStudent.averageScore) {
				return place ? st1.getAverageScore() - st2.getAverageScore()
						: st2.getAverageScore() - st1.getAverageScore();
			}
			return 0;
		});
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Student s : students) {
			if (s != null) {
				sb.append(s);
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}
	public void addToDataBase(File file) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(this);
			System.out.println("Group was saved!\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFromDataBase(File file) {
		Group disable = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			disable = (Group) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.students = disable.students;
		System.out.println("Group was loaded!\n ||\n VV\n");
	}
}

