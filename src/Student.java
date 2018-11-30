import java.util.ArrayList;
public class Student {
    private int id, grade;
    ArrayList<Class> requests = new ArrayList<Class>();
    ArrayList<Class> schedule = new ArrayList<Class>();

    //draw physical  array for schedule;
    //list of course reqs;
    public Student(){
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int i) {
        grade = i;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }



}
