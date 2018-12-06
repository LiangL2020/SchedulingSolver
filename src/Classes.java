import java.util.ArrayList;

public class Classes {

    private int id, period, code, maxStudents; //id would be specifically for that one class
    //but the code is the number that tells you which course it is (number before the course names)
    private int level; //1:intro, 2:college, 3:honors, 4:AP, 5:standard (classes that don't have a level)
    private String courseName;
    private boolean open;
    //semester-based,full-year,quarter-long?;
    private ArrayList<Student> students;


    public Classes(int code){
        this.code = code;
        this.id = id; //randomly generate an id for the class
        this.level = level; //the level and the courseName can derive from the code
        this.courseName = courseName;
        this.period = period; //assign a period to the class
    }

    public void addStudent(ArrayList<Student> a){
//        if(a.requestwhatever)
//            students.add(whatever);
    }

    public int numStudents(){
        int students = 0;

//add students
        return students;

    }


    public boolean isOpen(){
        if(numStudents() >= maxStudents){
            open = false;
        }
        return open;
    }

    //if a class have Prerequisite

}
