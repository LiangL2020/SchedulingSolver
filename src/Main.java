import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends JPanel{

//    private ArrayList<Student> students;
    private MasterSchedule ms;
    private ArrayList<Student> studentures = new ArrayList<>();
    private ArrayList<MasterSchedule> mass = new ArrayList<>();
    private String rob;

    public Main(int w, int h) {
        setSize(w, h);
   //     this.ms = ms;
        int score = 0;
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

            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Course> courseName = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.get(i).getRequests().size(); j++) {
                Course a = new Course(students.get(i).getRequests().get(j).getName());
                if (!courseName.contains(a)) {
                    if (!courseName.contains(a))
                        courseName.add(a);
                }
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
//        Makes an arraylist of coursenames without repeats ENDS





        Population population = new Population(0, courseName);



        //   while(1!=0) { //TODO: Make while loop great again.\
        int start=0;
        while(!population.reachedGoal() || start ==0) { //TODO: Make while loop great again.
            population.CalcCosts(students);
            population.sort(students);
            population.kill();
            population.mutate();
            population.CalcCosts(students);

            population.display(students);
            if (start==0)
                start++;

        }
        population.sort(students);
        population.kill();
        population.mutate();
        population.display(students);
//        rob = population.getMembers().get(0).display();



    }

//    public Main(MasterSchedule ms){
//        this.ms = ms;
//    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Arial", Font.BOLD, 8);
        g.setFont(font);
        String[] partsofrob = rob.split("PER");
        String rob1 = partsofrob[0];
        String rob2 = partsofrob[1];
        String rob3 = partsofrob[2];
        String rob4 = partsofrob[3];
        String rob5 = partsofrob[4];
        String rob6 = partsofrob[5];
        String rob7 = partsofrob[6];
        String rob8 = partsofrob[7];
        String rob9 = partsofrob[8];
       g2.drawString(rob1, 10, 10);
       g2.drawString(rob2, 10, 11);
       g2.drawString(rob3, 10,100);
       g2.drawString(rob4, 10,200);
       g2.drawString(rob5, 10, 300);
       g2.drawString(rob6, 10, 400);
       g2.drawString(rob7, 10, 500);
       g2.drawString(rob8, 10, 600);
       g2.drawString(rob9, 10, 700);

    }


    public static void main(String[] args) {



        //temporary place
            JFrame frame = new JFrame("Final Masterschedule");
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            int width = 1200;
            int height = 1200;
            frame.setPreferredSize(new Dimension(width, height + 24));


            JPanel panel = new Main(width, height);
            panel.setFocusable(true);
            panel.grabFocus();

            frame.add(panel);
            frame.pack();
            frame.setVisible(true);

     //   }
        //        MasterSchedule ms = new MasterSchedule(courseName);
//        //        for (int i = 0; i < ms.getStudents().size(); i++) {
////            ms.getStudents().get(i).makeStudentSchedule(masterSchedule);
////
////        }
////        System.out.println(students.get(0).makeStudentSchedule(masterSchedule));
//        for (int i = 0; i < students.size(); i++) {
//            students.get(i).resetPeriods(ms);
//        }
//        System.out.println(students);
//
////        for (int i = 0; i < ms.getStudents().size(); i++) {
////            ms.getStudents().get(i).resetPeriods(ms);
////        }
////        System.out.println(ms.getStudents());
//



    }

//    public void callStudentSch(){
//        for (int i = 0; i < students.size(); i++) {
////            students.get(i).makeStudentSchedule(ms);
//            System.out.println("student sch!!!!!!!!!!!!!!" + students.get(i).makeStudentSchedule(ms));
//        }
//    }

}
