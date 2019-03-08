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

    public void sort() {

        List list = Arrays.asList(members);

        Collections.sort(members, new Comparator<MasterSchedule>() {

            public int compare(MasterSchedule o1, MasterSchedule o2) {

                return o1.totalCost()-o2.totalCost();

            }

        });

    }

    public void kill() {

        for (int i = members.size()/2; i < members.size(); i++) {

            members.set(i, members.get(0));

        }

    }

    public void mutate() {

        for (int i = 0; i < members.size(); i++) {

            int random = (int)(Math.random()*5+1);

            if(random == 4) {

                int randomPeriodFrom = (int)(Math.random()*8);

                int randomClassFrom = (int)(Math.random()*members.get(i).getScheduleReal()[randomPeriodFrom].size());

                int randomPeriodTo = (int)(Math.random()*8);

                int randomClassTo = (int)(Math.random()*members.get(i).getScheduleReal()[randomPeriodTo].size());

                Course ClassFrom = members.get(i).getScheduleReal()[randomPeriodFrom].get(randomClassFrom);

                Course ClassTo = members.get(i).getScheduleReal()[randomPeriodTo].get(randomClassTo);

                members.get(i).getScheduleReal()[randomPeriodTo].set(randomClassTo, ClassFrom);

                members.get(i).getScheduleReal()[randomPeriodFrom].set(randomClassFrom, ClassTo);

            }

        }

    }

    public void display() {

        for (int i = 0; i < members.size(); i++) {

            int a = i+1;

            System.out.println(a + ": " + members.get(i)); //TODO: let it not print memory

            System.out.println();

            System.out.println();

        }

    }

    public boolean nextGen() {

        while(members.get(0).totalCost() != 0) {

            sort();

            kill();

            mutate();

            return false;

        }

        return true;
    }

}
