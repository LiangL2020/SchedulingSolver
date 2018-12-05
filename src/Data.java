import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Data {


    public Data() {

        try {
            Path path = Paths.get("./data.txt");
            Scanner scanner = new Scanner(path);
            System.out.println("Read text file using Scanner");
            //read line by line
            while (scanner.hasNextLine()) {
                //process each line
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        }catch (Exception e){e.printStackTrace();}

    }
}
