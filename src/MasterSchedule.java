import java.util.ArrayList;

public class MasterSchedule {

    private ArrayList<Course> courseNames;

    private int[] periods = new int [8];

    public MasterSchedule(ArrayList<Course> courseNames) {

        this.courseNames = courseNames;

        for (int i = 0; i < periods.length; i++) {

            periods[i] = 0;

        }

    }

    public ArrayList[] RandomizeClasses() {

        ArrayList[] schedule = new ArrayList[8];

        for (int i = 0; i < schedule.length; i++) {

            ArrayList courses = new ArrayList();

            schedule[i] = courses;

        }

        for (int i = 0; i < courseNames.size(); i++) {

            int periodNumber = (int)(Math.random()*8);

            schedule[periodNumber].add(courseNames.get(i));

        }

        for (int i = 0; i < schedule.length; i++) {

            System.out.println(schedule[i]);



        }

        return schedule;

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
