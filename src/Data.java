import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    private ArrayList<Integer> studentId = new ArrayList<Integer>();

    public Data() {

        this.studentId = studentId;

        try {
            Path path = Paths.get("./data.txt");
            Scanner scanner = new Scanner(path);
            System.out.println("Read text file using Scanner");
            //read line by line
            while (scanner.hasNextLine()) {
                //process each line
                String line = scanner.nextLine();
                if(line.contains(":")){
                    String IDString = line.substring(line.indexOf(":") + 2);
                    int IDNum = Integer.parseInt(IDString);
                    studentId.add(IDNum);
                }
            }
            scanner.close();
        }catch (Exception e){e.printStackTrace();}
//      Test test studentId
//      System.out.println(studentId);

    }

    public ArrayList<Integer> getId(){return studentId;}
}
