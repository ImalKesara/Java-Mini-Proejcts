package Student_management_sys;

import Student_management_sys.models.Student;
import Student_management_sys.models.UndergraduateStudent;
import Student_management_sys.services.StudentManager;

import java.util.Scanner;

public class StudentMenu {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        System.out.println("=========================");
        System.out.println("Welcome to Student Management System");
        System.out.println("=========================");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student By Id");
            System.out.println("4. Remove Student By Id");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:

                    System.out.println("Enter student type");
                    String type = sc.next();

                    System.out.println("Enter Student ID");
                    int id = sc.nextInt();
                    System.out.println("Enter Student Name");
                    String name = sc.next();
                    System.out.println("Enter Student age");
                    int age = sc.nextInt();
                    System.out.println("Enter Student Gender");
                    String gender = sc.next();
                    System.out.println("Enter Student Course");
                    String course = sc.next();



                    if(type.equals("student")){
                        Student student = new  Student(id, name, age, gender, course);
                        studentManager.add(student);
                        System.out.println("✅ Student graduate added successfully!");
                        break;
                    }else{
                        System.out.println("Enter student year");
                        int year = sc.nextInt();
                        UndergraduateStudent undergraduateStudent = new UndergraduateStudent(id,name,age,gender,course,year);
                        studentManager.add(undergraduateStudent);
                        System.out.println("✅ Student un-graduate added successfully!");
                        break;
                    }


                case 2:
                    studentManager.displayAll();
                    break;
                case 3:
                    System.out.println("Enter Student ID");
                    int vid = sc.nextInt();
                    Student s = studentManager.get(vid);
                    s.displayDetails();
                    break;
                case 4:
                    System.out.println("Enter Student ID");
                    int rid = sc.nextInt();
                    String result = studentManager.remove(rid);
                    System.out.println(result);
                    break;
                case 5:
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
