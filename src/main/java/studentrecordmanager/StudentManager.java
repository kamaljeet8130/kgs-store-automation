package studentrecordmanager;

import java.util.InputMismatchException;
import java.util.Scanner;

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

            int choice;
            try {
                choice=scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please Enter a number between 1 and 6");
                scanner.nextLine();
                continue;
            }


            switch (choice){
                case 1:
                    int id = readInt(scanner,"Enter Student Id");

                    scanner.nextLine();

                    System.out.println("Enter Student Name: ");
                    String name = scanner.nextLine();

                    int age = readInt(scanner,"Enter Student Age: ");


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
                    int searchId =readInt(scanner,"Enter student ID to find: ");
                    Student foundStudent = service.findStudentById(searchId);
                    if(foundStudent!=null){
                        System.out.println("Student found: " );
                        System.out.println(foundStudent);
                    }else {
                        System.out.println("Student not found with Id NO." + searchId+ " ID is invalid");
                        System.out.println(searchId);
                    }
                    break;
                case 4:
                    System.out.println("Enter student ID to update: ");
                    int updateId = readInt(scanner,"Enter Student ID to update: ");

                    Student studentToUpdate = service.findStudentById(updateId);
                    if(studentToUpdate==null){
                        System.out.println("Student not found");
                        break;
                    }
                    System.out.println("Enter new Name: ");
                    String newName = scanner.nextLine();

                    System.out.println("Enter new Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter new Course: ");
                    String newCourse = scanner.nextLine();

                    studentToUpdate.setName(newName);
                    studentToUpdate.setAge(newAge);
                    studentToUpdate.setCourse(newCourse);

                    boolean update = service.updateStudent(
                            updateId,
                            newName,
                            newAge,
                            newCourse
                    );
                    if(update){
                        System.out.println("Student update Successfully.\n "+studentToUpdate);
                    } else{
                        System.out.println("Student could not be updated.\n "+studentToUpdate);
                    }
                    break;
                case 5:
                    int deleteId = readInt(scanner,"Enter Student Id to delete: ");

                    boolean removed = service.removeStudent(deleteId);
                    if(removed){
                        System.out.println("Student deleted successfully.");
                    }else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Enter valid input!");

            }
        }
    }
    private static int readInt(Scanner scanner,String message){
        while (true){
            System.out.println(message);
            try {
                return scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid nunber.");
                scanner.nextLine();
            }
        }
    }


}
