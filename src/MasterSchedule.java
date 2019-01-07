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

            int bruh = (int)(Math.random()*8+1);

            Schedule[bruh].add(AllCourses.get(i));

        }

        return Schedule;

    }

    public ArrayList<Course>[] MutateClasses(ArrayList<Course>[] Schedule) {

        int probability = (int)(Math.random()*100);

        if(probability < 20) {

            int periodA = (int) (Math.random() * Schedule.length);  //rand period

            int periodB = (int) (Math.random() * Schedule.length); //rand period

            int classAIndex = (int) (Math.random() * Schedule[periodA].size());  //rand class from period

            int classBIndex = (int) (Math.random() * Schedule[periodB].size());  //rand class from period

            Course classA = Schedule[periodA].remove(classAIndex);

            Course classB = Schedule[periodB].remove(classBIndex);

            Schedule[periodA].add(classB);

            Schedule[periodB].add(classA);

        }

        return Schedule;

    }

}
