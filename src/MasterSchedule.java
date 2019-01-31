import java.util.ArrayList;

public class MasterSchedule {

    private ArrayList<Course> courseNames;
    private ArrayList[] schedule = new ArrayList[8];

//    private int[] periods = new int [8];

    public MasterSchedule(ArrayList<Course> courseNames) {

        this.courseNames = courseNames;
//        for (int i = 0; i < periods.length; i++) {
//
//            periods[i] = 0;
//
//        }
        for (int i = 0; i < schedule.length; i++) {

            ArrayList courses = new ArrayList<Course>();

            schedule[i] = courses;

        }

    }

    public ArrayList[] RandomizeClasses() {

        //makes an array of 8 period, and adds course lists into the array

        ArrayList[] schedule = new ArrayList[8];
  /*      ArrayList[] schedule = new ArrayList[8];

        for (int i = 0; i < schedule.length; i++) {

            ArrayList courses = new ArrayList<Course>();

            schedule[i] = courses;

        }
        */

        //assign course names into randomized 1-8 period array array lists

        for (int i = 0; i < courseNames.size(); i++) {

            int periodNumber = (int)(Math.random()*8+1);

            schedule[periodNumber].add(courseNames.get(i));

        }
//        for (int i = 0; i < schedule.length; i++) {
//
////            System.out.println(schedule[i]);
//
//        }

/*        for (int i = 0; i < schedule.length; i++) {

       System.out.println(schedule[i]);

        }
        */

        return schedule;

    }

//    public int[] getPeriodsArr(){
//        return periods;
//    }

    public ArrayList<Course> getCourseNames(){
        return courseNames;
    }

    public ArrayList<Course>[] MutateClasses(ArrayList<Course>[] schedule) {

        int probability = (int)(Math.random()*100);

        if(probability < 20) {

            int periodA = (int) (Math.random() * schedule.length);  //rand period

            int periodB = (int) (Math.random() * schedule.length); //rand period

            int classAIndex = (int) (Math.random() * schedule[periodA].size());  //rand class from period

            int classBIndex = (int) (Math.random() * schedule[periodB].size());  //rand class from period

            Course classA = schedule[periodA].remove(classAIndex);

            Course classB = schedule[periodB].remove(classBIndex);

            schedule[periodA].add(classB);

            schedule[periodB].add(classA);

        }

        return schedule;


    }


    public int returnCost(int cost) {

        return cost;

    }

    }



