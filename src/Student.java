import java.util.ArrayList;
public class Student {
    private int id, grade;
    ArrayList<Classes> requests = new ArrayList<Classes>();
    ArrayList<Classes> schedule = new ArrayList<Classes>();

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

    public ArrayList getRequests() {

        return requests;

    }

}
