import java.util.*;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class Population {

    //genetic algorithm population
    //takes in masterschedule chromosomes adds them to population

    private ArrayList<MasterSchedule> members;
    private int goal, size, generationNumber;

    public Population(int goal, ArrayList<Course> courseName){

        this.members = new ArrayList<>();

        this.goal = goal;

        this.size = 20;

        this.generationNumber = 0;

        while(members.size()<size){

            MasterSchedule ms = new MasterSchedule(courseName);

            members.add(ms);

        }
    }

    public void sort(ArrayList<Student> stuList) {

        List list = Arrays.asList(members);
        Collections.sort(list, new Comparator<MasterSchedule>() {

            public int compare(MasterSchedule o1, MasterSchedule o2) {

                return o1.totalCost(stuList, o1)-o2.totalCost(stuList, o2);

            }

        });

    }

    public void kill() {

        for (int i = members.size()/2; i < members.size(); i++) {

            members.set(i, members.get(i-members.size()/2)); //turns second half of sorted list into copy of first half

        }

    }

    public void mutate() {

        for (int i=members.size()/2; i < members.size(); i++) { //Possibly mutates a member of second half of population

            int random = (int)(Math.random()*3);

            if(random < 4 ) {
                //TODO: This mutate doesn't work - Fails to change second half of list
                int randomPeriodFrom = (int)(Math.random()*8);

                int randomPeriodTo = (int)(Math.random()*8);

                while (randomPeriodTo==randomPeriodFrom){
                    randomPeriodTo = (int)(Math.random()*8);
                }

                int randomClassFrom = (int)(Math.random()*members.get(i).getScheduleReal()[randomPeriodFrom].size());

                int randomClassTo = (int)(Math.random()*members.get(i).getScheduleReal()[randomPeriodTo].size());

                while (randomClassTo==randomClassFrom){
                    randomClassTo = (int)(Math.random()*members.get(i).getScheduleReal()[randomPeriodTo].size());
                }


                Course ClassFrom = members.get(i).getScheduleReal()[randomPeriodFrom].get(randomClassFrom);

                Course ClassTo = members.get(i).getScheduleReal()[randomPeriodTo].get(randomClassTo);

                members.get(i).getScheduleReal()[randomPeriodTo].set(randomClassTo, ClassFrom); //I think this is where the issue is

                members.get(i).getScheduleReal()[randomPeriodFrom].set(randomClassFrom, ClassTo);

            }
        }
    }




    public void display(ArrayList<Student> students) {

        for (int i = 0; i < members.size(); i++) {

            System.out.println("Member # " + (i+1));

            System.out.println("Generation = "+ generationNumber + ": ");

            members.get(i).display(students);
            //TODO: let it not print memory

            System.out.println();

            System.out.println();

        }


        generationNumber ++;


    }

    public boolean nextGen(ArrayList<Student> students) {

        while(members.get(0).totalCost(students, members.get(0)) != 0) {  //This will likely be infinite
            //we'll need to store the best iteration of the schedule

            sort(students);

            kill();

            mutate();

            return false;

        }

        return true;
    }

}
