import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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
        System.out.println(students);


    }


}
