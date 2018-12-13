public class Course {

    private String name, courseNumber;

    public Course(String info){
        int indexOfDash = info.indexOf("-");
        courseNumber = info.substring(0, indexOfDash-1);
        name = info.substring(indexOfDash+2);



    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                '}';
    }
}



