import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    private ArrayList<Integer> studentId = new ArrayList<Integer>();
    private int[][] requestsTest = new int[studentId.size()][15];
    private ArrayList<String> requests = new ArrayList<String>();

    public Data() {

        this.studentId = studentId;

        try {
            Path path = Paths.get("./data2.txt");
            Scanner scanner = new Scanner(path);
            System.out.println("Read text file using Scanner");
            //read line by line
            while (scanner.hasNextLine()) {
                //process each line
                String line = scanner.nextLine();
                if(line.contains(":")){
                    String IDString = line.substring(line.indexOf(":") + 2);
                    int IDNum = Integer.parseInt(IDString); //this turns the String into integer
                    studentId.add(IDNum);
                }
//                if(line.contains("-")){
//                    String IDString = line.substring(line.indexOf("-") + 2);
//                    requests.add(IDString);
//                }

//                for (int r = 0; r < requestsTest.length; r++) {
//                    int c = 0;
//                    requestsTest[r][c] = studentId.get(r);
//                }
//
                int r = 0;
                for (int c = 1; c < requestsTest[0].length-1; c++) {
                    String requestStr = line.substring(0, line.indexOf("-") - 1);
                    int requestNum = Integer.parseInt(requestStr);
                    requestsTest[r][c] = requestNum;
                    //TODO: there are more coloums than needed, we need to fill them with 0s (before the next ID) because each student
                    //TODO: have different amount of request... unless we use arraylist which might be complicated
                    if(line.contains(":"))
                        r++;
                }

            }
            scanner.close();
        }catch (Exception e){e.printStackTrace();}
//      Test test studentId, requests
//        System.out.println(studentId);
//        System.out.println(requests);
        System.out.println(requestsTest);

    }

    public ArrayList<Integer> getId(){return studentId;} //returns an arraylist of Student ID #

    public int getStudentNum(){return studentId.size();} //returns number of students
}
