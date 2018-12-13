import java.util.ArrayList;
public class Student {
    private int id, grade;
    private ArrayList<Course> requests;
    ArrayList<Classes> schedule = new ArrayList<Classes>();

    //draw physical  array for schedule;
    //list of course reqs;
    public Student(){
        requests = new ArrayList();

    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int i) {
        grade = i;
    }

    //Todo: take the arraylist from the data class
    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    public void addCourse(String info) {

       requests.add(new Course(info));

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", requests=" + requests +
                '}';
    }
}
