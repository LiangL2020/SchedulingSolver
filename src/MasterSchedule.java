import java.util.ArrayList;

public class MasterSchedule {

    private ArrayList<Course> AllCourses;

    private int[] Periods = new int [8];

    public MasterSchedule() {

        this.AllCourses = AllCourses;

        this.Periods = Periods;



    }

    public ArrayList[] RandomizeClasses() {

        ArrayList[] Schedule = new ArrayList[8];

        for (int i = 0; i < AllCourses.size(); i++) {

            int random = (int)(Math.random()*8+1);

            Schedule[random].add(AllCourses.get(i));

        }

        return Schedule;

    }

}
