public class Class {

    private int id, period, code; //id would be specifically for that one class
    //but the code is the number that tells you which course it is (number before the course names)
    private int level; //1:intro, 2:college, 3:honors, 4:AP, 5:standard (classes that don't have a level)
    private String courseName;
    //semester-based,full-year,quarter-long?;


    public Class(int code){
        this.code = code;
        this.id = id; //randomly generate an id for the class
        this.level = level; //the level and the courseName can derive from the code
        this.courseName = courseName;
        this.period = period; //assign a period to the class

    }


    //if a class have Prerequisite

}
