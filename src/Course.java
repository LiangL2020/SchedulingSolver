public class Course {

    /*
    Day 1 Notes
    private int id, period, code; //id would be specifically for that one class\
    //but the code is the number that tells you which course it is (number before the course names)
    private int level; //1:intro, 2:college, 3:honors, 4:AP, 5:standard (classes that don't have a level)
    private String courseName;
    //semester-based,full-year,quarter-long?;
    private boolean request;
    private ArrayList<Student> students;


    public Classes(int code, int meetreq){
        this.code = code;
        this.id = id; //randomly generate an id for the class
        this.level = level; //the level and the courseName can derive from the code
        this.courseName = courseName;
        this.period = period; //assign a period to the class
    }
     */

    private String name, courseNumber, level;
    //level: introductory, college, honors, advanced (placement)
    //if index 0 to indexOf first [space] = intro, coll, honors, advanced, then set level to that string (index 0 to indexOf first [space]).
    //else, set level to "standard"


    public Course(String info){
        int indexOfDash = info.indexOf("-");
        int indexOfFirstSpace = 0;

        courseNumber = info.substring(0, indexOfDash-1);
        name = info.substring(indexOfDash+2);

//        char ch = (char)(" ");
        boolean happy = false;
        if(!happy){
            for (int i = 0; i < name.length()-1; i++) {
                if(name.substring(i, i+1).equals(" ")){
                    indexOfFirstSpace = i;
                    happy = true;
                }
            }
        }

//        int indexOfFirstSpace2 = info.indexOf('\u00A0');

        if(info.substring(0, indexOfFirstSpace).contains("Introductory")){
            level = "introductory";
        }
        else if(info.substring(0, indexOfFirstSpace).contains("College")){
            level = "college";
        }
        else if(info.substring(0, indexOfFirstSpace).contains("Honors")){
            level = "honors";
        }
        else if(info.substring(0, indexOfFirstSpace).contains("Advanced")){
            level = "ap";
        }
        else{
           level = "standard";
        }

    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}


