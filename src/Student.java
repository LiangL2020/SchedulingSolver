import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private int id, grade;
    private ArrayList<Course> requests, names, students;
    ArrayList<Course>[] masterSchedule;
    private int cost;

    //draw physical  array for masterSchedule;
    //list of course reqs;
    public Student(){
        requests = new ArrayList();
        this.masterSchedule = null;
        this.cost = 0;

        ArrayList<Student> students = new ArrayList<>();

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

    public ArrayList<Course> getRequests() {
        return requests;
    }

    //    public void findName(){
////        String name = "";
////        for (int i = 0; i < students.size(); i++) {
////            int a = requests.toString().indexOf("'");
////            int b = requests.toString().indexOf(",") - 1;
////            name = requests.get(i).toString().substring(a,b);
////            System.out.println(name);
////            name = "";
////
//////            name.equals(substring(indexOf(students.get(i).requests.get(i));
////        }
//
//
//    }


//    public void printRequests1(){
//        System.out.println(requests.get(1));
//    }

//    public void addName(String name){
//        names.add(new Course(name));
//

    public void setMasterSchedule(ArrayList<Course>[] masterSchedule) {
        this.masterSchedule = masterSchedule;
    }

    public void studentSchedule(ArrayList<Course> requests){
        for(int i = 0; i<requests.size(); i++){
            int coursenumber = requests.get(i).getCourseNumber();
            for(int j = 0; j<masterSchedule.length; j++){
                for(int k = 0; k<masterSchedule[0].size(); k++)
                if(coursenumber == masterSchedule[j].get(k).getCourseNumber()){
                    System.out.println(masterSchedule[j].get(k).getPeriod());
                }
            }
        }
    }

    public int calcScoreStudents(){
        int score = 0;
        int conflicts = 0;
        int fitted = 0;
        for(int i = 0; i<requests.size(); i++){
            for(int j = 0; j<requests.size(); j++) {
                if (i != j && requests.get(i).getCourseNumber() == requests.get(j).getCourseNumber() && requests.get(i).getPeriod() == requests.get(j).getPeriod()) {
                    conflicts++;
                }
            }
        }
        score += conflicts * 100;

        this.cost = score;
        return cost;

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", requests=" + requests +
                '}';
    }

}
