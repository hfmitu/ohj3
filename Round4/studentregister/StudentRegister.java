import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRegister {
    

    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Attainment> attainments = new ArrayList<Attainment>();

    public StudentRegister(){

    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void addStudent(Student student){
        students.add(student);
        Collections.sort(students, (o1, o2) -> (o1.getName().compareTo(o2.getName())));
    }

    public void addCourse(Course course){
        courses.add(course);
        Collections.sort(courses, (o1, o2) -> (o1.getName().compareTo(o2.getName())));
    }

    public void addAttainment(Attainment attainment){
        attainments.add(attainment);

    }

    public void printStudentAttainments(String studentNumber, String order){
    
        ArrayList<Attainment> toprint = new ArrayList<Attainment>();
        for (Attainment a : attainments){
            if (a.getStudentNumber().equals(studentNumber)) toprint.add(a);
        }

        if (toprint.size()==0){
            System.out.println("Unknown student number: " + studentNumber);
            return;
        }
        
        if (order.equals("by code")){
            Collections.sort(toprint, (o1,o2)->(o1.getCourseCode().compareTo(o2.getCourseCode())));
            for (Attainment a : toprint) {
                String coursename = "";
                for(Course c : courses){
                    if (a.getCourseCode().equals(c.getCode())) coursename=c.getName();
                }
                System.out.println("  " + a.getCourseCode() + " " + coursename + ": " + a.getGrade());
            }
            return;
        }
        
        
        if (order.equals("by name")){
            ArrayList<Course> coursenames = new ArrayList<Course>();
            for (Attainment a : toprint) {
                for (Course c : courses){
                    if (c.getCode().equals(a.getCourseCode())) coursenames.add(c);
                }
            }
            Collections.sort(coursenames, (o1,o2)->(o1.getName().compareTo(o2.getName())));
            for (Course s : coursenames){
                for (Attainment a : toprint){
                    if (a.getCourseCode() == s.getCode()) System.out.println("  " + a.getCourseCode() + " " + s.getName() + ": " + a.getGrade());
                }
            }
        }

        else printStudentAttainments(studentNumber);
    }

    public void printStudentAttainments(String studentNumber){

        boolean flag = false;

        for (Attainment a : attainments){
            if (a.getStudentNumber().equals(studentNumber)){
                flag = true;
            }
        }

        if (flag == false){
            System.out.println("Unknown student number: " + studentNumber);
        }

        String courseName = "";
        for (Attainment a : attainments){
            if (a.getStudentNumber().equals(studentNumber)){
                for (Course c : courses){
                    if (a.getCourseCode().equals(c.getCode())) courseName=c.getName();
                }
                System.out.println("  " + a.getCourseCode() + " " + courseName + ": " + a.getGrade());
            };
        }
    }
}
