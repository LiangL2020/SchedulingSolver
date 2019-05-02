 import java.util.*;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class Population {

    //genetic algorithm population
    //takes in masterschedule chromosomes adds them to population

    private ArrayList<MasterSchedule> members;
    private int goal, size, generationNumber;

    public Population(int goal, ArrayList<Course> courseName) {

        this.members = new ArrayList<>();

        this.goal = goal;


        this.size = 200;

        this.generationNumber = 0;

        while (members.size() < size) {

            MasterSchedule ms = new MasterSchedule(courseName);

            members.add(ms);

        }

    }

    public void sort(ArrayList<Student> stuList) {


        Collections.sort(members, new Comparator<MasterSchedule>() {

            public int compare(MasterSchedule o1, MasterSchedule o2) {

                return o1.getCost() - o2.getCost();

            }

        });

    }

    public void kill() {              //turns second half of sorted list into copy of first half

        for (int i = members.size() / 2; i < members.size(); i++) {

            MasterSchedule msCopy = new MasterSchedule(members.get(i-members.size()/2));
            members.set(i, msCopy); //good?

        }

    }

    public void CalcCosts(ArrayList<Student> students) {
        for (int i = 0; i < members.size(); i++) {
            members.get(i).calccost(students, members.get(i));
        }
    }

    public void mutate() {

        for (int i = members.size() / 2; i < members.size(); i++) { //Possibly mutates a member of second half of population

            int random = (int) (Math.random() * 2);

            while (i < random) {

                int randomPeriodFrom = (int) (Math.random() * 8);

                int randomPeriodTo = (int) (Math.random() * 8);

                while (randomPeriodTo == randomPeriodFrom) {
                    randomPeriodTo = (int) (Math.random() * 8);
                }

                int randomClassFrom = (int) (Math.random() * members.get(i).getScheduleReal()[randomPeriodFrom].size());

                int randomClassTo = (int) (Math.random() * members.get(i).getScheduleReal()[randomPeriodTo].size());

                while (randomClassTo == randomClassFrom) {
                    randomClassTo = (int) (Math.random() * members.get(i).getScheduleReal()[randomPeriodTo].size());
                }


                Course ClassFrom = members.get(i).getScheduleReal()[randomPeriodFrom].remove(randomClassFrom);

                Course ClassTo = members.get(i).getScheduleReal()[randomPeriodTo].remove(randomClassTo);

                members.get(i).getScheduleReal()[randomPeriodTo].add(ClassFrom);

                members.get(i).getScheduleReal()[randomPeriodFrom].add(ClassTo);

            }
        }

    }

    public Boolean reachedGoal() {
        if (members.get(0).getCost() > goal) {
            return false;
        } else {
            return true;
        }
    }


    public void display(ArrayList<Student> students) {

        for (int i = 0; i < members.size(); i++) {

            System.out.println("Member # " + (i + 1));

            System.out.println("Generation = " + generationNumber + ": ");

            members.get(i).display();
            //TODO: let it not print memory

            System.out.println();

            System.out.println();

        }


        generationNumber++;


    }

    public boolean nextGen(ArrayList<Student> students) {

        while (members.get(0).getCost() != 0) {  //This will likely be infinite
            //we'll need to store the best iteration of the schedule

            sort(students);

            kill();

            mutate();

            return false;

        }

        return true;
    }

    public ArrayList<MasterSchedule> getMembers() {
        return members;
    }
}
