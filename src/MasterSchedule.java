import java.util.ArrayList;

public class MasterSchedule {

    private ArrayList<Course> courseList;
    private ArrayList<Course>[] schedule;
    private int cost=(int)(Math.random()*1000);
    ;

    public MasterSchedule(ArrayList<Course> courseNames) {
        this.schedule = new ArrayList[8];
        this.courseList = new ArrayList<>();


        for (int i = 0; i < courseNames.size(); i++) {

            courseList.add(new Course(courseNames.get(i)));

        }


        for (int i = 0; i < schedule.length; i++) {

            ArrayList<Course> courses = new ArrayList<Course>();//THIS IS EMPTY

            schedule[i] = courses;//FIX THIS. THE SCH IS EMPTY.

        }

        //makes an array of 8 period, and adds course lists into the array
        //assign course names into randomized 1-8 period array array lists

        for (int k = 0; k < courseList.size(); k++) {

            int periodNumber = (int)(Math.random()*8 + 1);

            schedule[periodNumber-1].add(courseList.get(k));//COURSES WAS EMPTY
            courseList.get(k).setPeriod(periodNumber + 1);

        }

    }

    //mutate of genetic algorithm
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

    public int getCost(){
        return cost;
    }

    public void calccost(ArrayList<Student> students, MasterSchedule ms) {

//        cost=(int)(Math.random()*1000);

         for(int i = 0; i<students.size(); i++) {

            cost += students.get(i).calcScoreStudent(ms);

        }

    }

    public ArrayList<Course> getCourseNames() {
        return courseList;
    }

    public Course getPerCourse(Course course){

        int per = 0;

        int courseN = 0;

        for (int i = 0; i < schedule.length; i++) {

            for (int j = 0; j < schedule[i].size(); j++) {

                if(course.equals(schedule[i].get(j))){

                    per = i;

                    courseN = j;

                }

            }

        }

        return getSchedule(per, courseN);

    }

    public Course getSchedule(int per, int course) {
        return schedule[per].get(course);
    }

    public ArrayList<Course>[] getScheduleReal() {return schedule;}

    public void display(){
        System.out.println("Score:  " + getCost());
        for (int i=0; i<schedule.length; i++){
            System.out.println();
            System.out.print("PER " + (i+1) + " ");
            for (int j=0; j<schedule[i].size(); j++){
                System.out.print(schedule[i].get(j).getName() + " - " + schedule[i].get(j).getCourseNumber() + ",  " );
            }

        }
    }
}



