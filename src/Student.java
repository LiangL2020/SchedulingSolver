import java.util.ArrayList;
public class Student {
    private int id, grade;
    private ArrayList<Course> requests, names;
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

    public ArrayList<Course> getRequests() {
        return requests;
    }






    //    public void findName(){
////        String name = "";
////        for (iqant i = 0; i < students.size(); i++) {
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
//    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", requests=" + requests +
                '}';
    }


}
