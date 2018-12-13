public class Course {

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



