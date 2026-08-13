package studentrecordmanager;

import java.util.*;

public class StudentManager {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println();
            System.out.println("================================");
            System.out.println("     STUDENT RECORD MANAGER");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Find Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Student Id: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Student age: ");
                    int age = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Enter student course: ");
                    String course = scanner.nextLine();

                    Student student = new Student(id,name,age,course);
                    boolean added = service.addStudent(student);
                    if(added){
                        System.out.println("Student added Successfully");
                        System.out.println(student);
                    }
                    else{
                        System.out.println("Student could not be added");
                        System.out.println(student);
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("================================");
                    System.out.println("        ALL STUDENTS");
                    System.out.println("================================");

                    service.displayStudents();
                    break;
                case 3:
                    System.out.println("Enter student ID to find: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = service.findStudentById(searchId);
                    if(foundStudent!=null){
                        System.out.println("Student found: " );
                        System.out.println(foundStudent);
                    }else {
                        System.out.println("Student not found Id is invalid");
                        System.out.println(searchId);
                    }
                    break;
                case 4:
                    System.out.println("update student selected");
                    break;
                case 5:
                    System.out.println("Delete Student selected");
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Enter valid input!");

            }
        }
    }

}
