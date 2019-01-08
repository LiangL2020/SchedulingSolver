import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//    private ArrayList<Student> students;

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        ArrayList<Integer> idPool = new ArrayList<>();
        for (int i = 0; i < 900; i++) {
            idPool.add(i);
        }

        try {
            Path path = Paths.get("./data2.txt");
            Scanner scanner = new Scanner(path);
            System.out.println("Read text file using Scanner");
            //read line by line
            while (scanner.hasNextLine()) {
                //process each line
                String line = scanner.nextLine();
                if (line.contains(":")) {
                    String IDString = ""+ idPool.remove((int)(Math.random()*idPool.size()));
                    int IDNum = Integer.parseInt(IDString); //this turns the String into integer
                    Student tempStudent = new Student();
                    tempStudent.setId(IDNum);

                    //add courses to student.

                    while((line = scanner.nextLine()).contains("-")){
                        tempStudent.addCourse(line);

                    }
                    students.add(tempStudent);





                }
//                if (line.contains("-")) {
//                    String requestStr = line.substring(0, line.indexOf("-") - 1);
//                    int requestNum = Integer.parseInt(requestStr);
//                    requests.add(requestNum);
//                }
            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

//        Data data = new Data();
//        System.out.println(students);
//        for (int i = 0; i < students.size(); i++) {
//            System.out.println("Student ID: " + students.get(i).getId());
//            for (int j = 0; j < students.get(i).getRequests().size(); j++) {
//                System.out.println(students.get(i).getRequests().get(j).getName());
//            }
//            System.out.println("");
//        }
//        students.get(1).printRequests1();

//        System.out.println(students);
        assignPeriod(students);


    }

    public static void assignPeriod(ArrayList<Student> students){

        //assign random periods to courses for the first student, and if the other students have the same course, then make it the same period
        //randomly assign 1-8, instead of putting it into period arraylist

        //TODO: check to see if course already have an assigned period, if does then assign it, if don't then random
        //TODO: maybe an arraylist for all course that have a period, and loop for the period

        ArrayList<String> reff = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.get(i).getRequests().size(); j++) {
                if(students.get(i).getRequests().get(j).getPeriod() != 0 ) //TODO: and if reff does not have this course yet
                    reff.add(students.get(i).getRequests().get(j).getName());
            }
        }


        for (int i = 0; i < students.size(); i++) {
            System.out.println("Student ID: " + students.get(i).getId());
            for (int j = 0; j < students.get(i).getRequests().size(); j++) {
                System.out.println(students.get(i).getRequests().get(j).getName());
                System.out.println("Period: " + students.get(i).getRequests().get(j).setPeriod((int)(Math.random()*8)+1));
            }
            System.out.println("");
        }
    }


}
