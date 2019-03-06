import java.util.ArrayList;

public class MasterSchedule {

    private ArrayList<Course> courseNames;
    private ArrayList<Course>[] schedule = new ArrayList[8];
    private ArrayList<Student> students = new ArrayList<>();


//    private int[] periods = new int [8];

    public MasterSchedule(ArrayList<Course> courseNames, ArrayList<Student> students) {

        this.courseNames = courseNames;
        this.students = students;
//        for (int i = 0; i < periods.length; i++) {
//
//            periods[i] = 0;
//
//
}
    public MasterSchedule(ArrayList<Course> courseNames) {

        this.courseNames = courseNames;
    }

    public ArrayList<Course>[] RandomizeClasses() {

        for (int i = 0; i < schedule.length; i++) {

            ArrayList<Course> courses = new ArrayList<Course>();

            schedule[i] = courses;
            for (int k = 0; k < courses.size(); k++) {

                int periodNumber = (int)(Math.random()*8+1);

                schedule[periodNumber].add(courses.get(k));

            }

        }

        //makes an array of 8 period, and adds course lists into the array

        ArrayList[] schedule = new ArrayList[8];

        for (int i = 0; i < schedule.length; i++) {

            ArrayList courses = new ArrayList<Course>();

            schedule[i] = courses;

        }

        //assign course names into randomized 1-8 period array array lists

        for (int i = 0; i < courseNames.size(); i++) {

            int periodNumber = (int)(Math.random()*8);

            schedule[periodNumber].add(courseNames.get(i));

            courseNames.get(i).setPeriod(periodNumber + 1);

        }

        return schedule;

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

    public int totalCost() {
        int cost = 0;
        for (Student s : students) {
            cost += s.calcScoreStudents();
        }
        //getters and setters
    }
    public int returnCost(int cost) {
        return cost;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourseNames(){
        return courseNames;
    }

    public Course getCourse(int i) {return courseNames.get(i);}

    public Course getPerCourse(Course courseName){
        int per = 0;
        int course = 0;
        for (int i = 0; i < schedule.length; i++) {
            for (int j = 0; j < schedule[i].size(); j++) {
                if(courseName.equals(schedule[i].get(j))){
                    per = i;
                    course = j;
                }
            }
        }
        return getSchedule(per, course);
    }

    public Course getSchedule(int per, int course) {
        return schedule[per].get(course);
    }

}



