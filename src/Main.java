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
//        assignPeriod(students);


        ArrayList<Course> courseName = new ArrayList<>();
        MasterSchedule ms = new MasterSchedule(courseName);


        //Makes an arraylist of coursenames without repeats
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.get(i).getRequests().size(); j++) {
                Course a = new Course(students.get(i).getRequests().get(j).getName());
                if (!courseName.contains(a)) {
                    if (!courseName.contains(a))
                        courseName.add(a);
                }
//
//                    if(j == 0 && i==0)
//                    courseName.add(a);
////                System.out.println(a.getName());
//                for (int k = 0; k < courseName.size(); k++) {
//                    if(courseName.get(k)==a){
//
//                    }
//                    else{
//                        courseName.add(a);
//                        System.out.println("happy1");
//                        System.out.println(courseName.size());
//                    }
//                }
//                System.out.println("happy2");
            }
        }
        for (int i = 0; i < courseName.size(); i++) {
            for (int j = i + 1; j < courseName.size(); j++) {
                if (courseName.get(i).equals(courseName.get(j))) {
                    courseName.remove(j);
                    j--;
                }

            }

        }
        //Makes an arraylist of coursenames without repeats ENDS

        for (int i = 0; i < students.size(); i++) {
            students.get(i).setId(i);
         //   System.out.println(a.getId());
        }

        System.out.println(students);
        System.out.println(courseName);

        ms.RandomizeClasses();
        ms.getCourseNames();
        System.out.println(ms);
        //        MasterSchedule ms = new MasterSchedule(courseName);

//        for (int i = 0; i < students.size(); i++) {
//            for (int j = 0; j < students.get(i).getRequests().size(); j++) {
//                ArrayList[] sch = ms.RandomizeClasses();
//                Object a = sch[i].get(j);
//
//            }
//        }
//
//        MasterSchedule masterSchedule = new MasterSchedule(courseName);
//
//        masterSchedule.RandomizeClasses();
//        MasterSchedule masterSchedule = new MasterSchedule(courseName);
//
//        masterSchedule.RandomizeClasses();
//        System.out.println(masterSchedule);

        //        for (int i = 0; i < students.size(); i++) {
//            students.get(i).makeStudentSchedule(masterSchedule);
//
//        }
//        System.out.println(students.get(0).makeStudentSchedule(masterSchedule));

    }

//        System.out.println();
//
//        MasterSchedule masterSchedule = new MasterSchedule(courseName);
//
//        masterSchedule.RandomizeClasses();
//        System.out.println(masterSchedule);



    }

//        ms.setPeriod();
//        System.out.println(ms);

//        for (int i = 0; i < ms.getPeriodsArr().length; i++) {
//            Course a = ms.getCourseNames().get(i);
//            a.setPeriod(ms.getPeriodsArr()[i]);
//        }
//
//        for (int i = 0; i < courseName.size(); i++) {
//            courseName.get(i).setPeriod((courseName.get(i).getPeriod()));
//        }
//        System.out.println(courseName);


//    public static void assignPeriod(ArrayList<Student> students){
//
//        //assign random periods to courses for the first student, and if the other students have the same course, then make it the same period
//        //randomly assign 1-8, instead of putting it into period arraylist
//        //check to see if course already have an assigned period, if does then assign it, if don't then random
//        //maybe an arraylist for all course that have a period, and loop for the period
//
//        ArrayList<Course> reff = new ArrayList<>();
//        for (int i = 0; i < students.size(); i++) {
//            for (int j = 0; j < students.get(i).getRequests().size(); j++) {
////                if(students.get(i).getRequests().get(j).getPeriod() != 0 ) //TODO: and if reff does not have this course yet
////                    reff.add(students.get(i).getRequests().get(j).getName());
//            }
//        }
//
//
//
////        for (int i = 0; i < students.size(); i++) {
////            System.out.println("Student ID: " + students.get(i).getId());
////            for (int j = 0; j < students.get(i).getRequests().size(); j++) {
////                System.out.println(students.get(i).getRequests().get(j).getName());
////                System.out.println("Period: " + students.get(i).getRequests().get(j).getPeriod());
////            }
////            System.out.println("");
////        }
//    }
