package com.gmail.ndonskih63;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Group {

	private Student[] students = new Student[10];
	private File group = new File("MyGroup.doc");
	private static Scanner sc = new Scanner(System.in);
	
	public Group() {
		super();
	}
	
	 public void saveToFile() {
	        try (PrintWriter pw = new PrintWriter(group)) {
	            group.createNewFile();
	            for (Student person : students) {
	                if (person != null)
	                    pw.println(person.getSurname() + " " + person.getName() + " | age: " + person.getAge() + 
	                    		" | sex: " + person.getSex() + " | course: " + person.getCourse() + 
	                    		" | RecBook number:" + person.getRecBookNum() + " | Average score: " + person.getAverageScore());
	            }
	        } catch (IOException e) {
	            System.out.println("Error!");
	        }
	        System.out.println("All students were saved to the file ");
	    }
	 
	 public void readFile(String gr) {
		 try(BufferedReader br =new BufferedReader(new FileReader(group))){
			 for(;(gr = br.readLine())!=null;)
			 System.out.println(gr);
			 }catch(IOException e){
			 System.out.println("ERROR");
			 }
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
	    public void addStudent2() throws DontMoreException{
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Input Surname");
	        String sn = sc.nextLine();
	        System.out.println("Input Name");
	        String n = sc.nextLine();
	        System.out.println("Input sex");
	        String sx = sc.nextLine();
	        System.out.println("Input age");
	        int ag = sc.nextInt();
	        System.out.println("Input course");
	        int cr = sc.nextInt();
	        System.out.println("Input RecBook number");
	        int rbn = sc.nextInt();
	        System.out.println("Input average score");
	        int as = sc.nextInt();
	        addStudent(new Student(sn, n, ag, sx, cr, rbn, as));
	        sc.close();
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
