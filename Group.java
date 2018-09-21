package com.gmail.ndonskih63;

import java.util.Arrays;
import java.util.Scanner;

public class Group {

	private Student[] students = new Student[10];
	

	public Group() {
		super();
	}

	 public int groupSize(){
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

	    public void addStudent2() throws DontMoreException {
	        if (this.studentsAmount() >= students.length) {
	            throw new DontMoreException();
	        }
	        for (int i = 0; i < students.length; i++) {
	            if (students[i] == null) {
	                Scanner sc = new Scanner(System.in);
	                System.out.println("Input Student's surname");
	                String surname = sc.nextLine();
	                System.out.println("Input Student's name");
	                String name = sc.nextLine();
	                System.out.println("Input Student's age");
	                int age = sc.nextInt();
	                System.out.println("Input Student's sex(only male or female)");
	                String sex = sc.nextLine();
	                if (!sex.equals("male") && !sex.equals("female")) {
	                        sex = sc.nextLine();
	                    }
	                System.out.println("Insert Student's course");
	                int course = sc.nextInt();
	                System.out.println("Insert Student's recBookNum");
	                int recBookNum = sc.nextInt();
	                System.out.println("Insert Student's averageScore");
	                int averageScore = sc.nextInt();
	                Student student = new Student(surname, name, age, sex, 
	    					 course, recBookNum, averageScore);
	                students[i] = student;
	                break;
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
	        if(number-1 >= 0 && number < students.length) {
	            return students[number-1];
	        } else{
	            System.out.println("Wrong index");
	            return null;
	        }
	    }

	    public void deleteStudent(String surname) {
	        for (int i = 0; i < students.length; i++) {
	            if (students[i] != null && students[i].getSurname().equals(surname)) {
	                students[i] = null;
	                break;
	            }
	        }
	    }

	    public int studentsAmount() {
	        int counter = 0;
	        for (Student s : students
	                ) {
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
	                return place ? st1.getSurname().compareTo(st2.getSurname()) : -st1.getSurname().compareTo(st2.getSurname());
	            }
	            if (itStudent == ItStudent.age) {
	                return place ? st1.getAge() - st2.getAge() : st2.getAge() - st1.getAge();
	            }
	            if (itStudent == ItStudent.averageScore) {
	            	return place ? st1.getAverageScore() - st2.getAverageScore() : st2.getAverageScore() - st1.getAverageScore();
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
	}