package studentrecordmanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student){
        if(student.getId()<=0)return false;
        if(student.getName().isBlank())return false;
        if(student.getAge()<5 || student.getAge()>=30) return false;
        if(student.getCourse().isBlank())return false;
        if(findStudentById(student.getId())!=null){
            return false;
        }
        students.add(student);
        return true;
    }
    public void displayStudents(){
        if(students.isEmpty()){
            System.out.println("No Student Found.");
            return;
        }
        for (Student student:students){
            System.out.println(student);
        }
    }
    public Student findStudentById(int searchId){
        for(Student student :students){
            if(student.getId()==searchId){
                return student;
            }
        }
        return null;
    }
    public boolean updateStudent(
            int studentId,
            String name,
            int age,
            String course
    ) {
        for(Student student:students){
            if(student.getId()==studentId){
                student.setName(name);
                student.setAge(age);
                student.setCourse(course);
                return true;
            }
        }
        return false;
    }
    public boolean removeStudent(int studentId){
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.getId()==studentId){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
