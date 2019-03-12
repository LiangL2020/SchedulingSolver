import java.util.ArrayList;

public class MasterSchedule {

    private ArrayList<Course> courseList;
    private ArrayList<Course>[] schedule = new ArrayList[8];
    private ArrayList<Student> stuList = new ArrayList<>();

//    private int[] periods = new int [8];

    public MasterSchedule(ArrayList<Course> courseNames, ArrayList<Student> students) {

//        ArrayList<Course> temp1 = new ArrayList<>();  //So schedule isn't null (But it still is)
//        for (int i=0; i<8; i++){
//            temp1.add(new Course("Void"));
//        }
//        for (int i=0; i<schedule.length; i++){
//            schedule[i]=temp1;
//        }


        this.courseList = new ArrayList<>();

        for (int i = 0; i < courseNames.size(); i++) {

            courseList.add(new Course(courseNames.get(i)));

        }

        for (int i = 0; i < students.size(); i++) {

            stuList.add(new Student(students.get(i)));

        }

    }

    public MasterSchedule(ArrayList<Course> courseNames) {

        this.courseList = new ArrayList<>();

        for (int i = 0; i < courseNames.size(); i++) {

            courseList.add(new Course(courseNames.get(i)));

        }

    }

    public ArrayList<Course>[] RandomizeClasses() {

        for (int i = 0; i < schedule.length; i++) {

            ArrayList<Course> courses = new ArrayList<Course>();

            schedule[i] = courses;//FIX THIS. THE SCH IS EMPTY.

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

        for (int i = 0; i < courseList.size(); i++) {

            int periodNumber = (int)(Math.random()*8);

            schedule[periodNumber].add(courseList.get(i));

            courseList.get(i).setPeriod(periodNumber + 1);

        }
//        System.out.println("sch:" + schedule);
//        for (int i = 0; i < 8; i++) {

//            for (int j = 0; j < schedule[0].size(); j++) {
//                System.out.println("SCH:" + "i:" + 0 + "j:" + j + "sch" + schedule[0].get(j));
//            }
//
//        System.out.println("happy per 1class1:" + schedule[0].get(0));
//        System.out.println("happy per 1 class2" + schedule[0].get(1));


//        for (int i = 0; i < schedule.length; i++) {
//            for (int j = 0; j < schedule[i].size(); j++) {
//                System.out.println("happy per" + (i+1) + "class" + (j+1) + schedule[i].get(j));
//            }
//
//        }
//        System.out.println("happy per 1 class 1" + schedule[0].get(0));
//        System.out.println("happy per 1 class 2" + schedule[0].get(1));
//        }
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

        int cost=0;

        for (Student s : stuList) {

            cost += s.calcScoreStudents();

        }

        //getters and setters
        return cost;

    }

    public ArrayList<Student> getStudents() {
        return stuList;
    }

    public ArrayList<Course> getCourseNames(){
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

    public String display(){

        //Gonna change this later so that it isn't a return method, because that would print very weirdly

        String sched = "";
        for(int r=0; r<schedule.length; r++){
            sched+="    PER " + (r+1) + ":    ";
            if (schedule[r]!= null) {

                for(int c=0; c<schedule[r].size(); c++){
                    sched += schedule[r].get(c).getLevel() + schedule[r].get(c).getName() + ", CourseNo. " + schedule[r].get(c).getCourseNumber();
                }
            }
        }

        return sched;
    }
}



