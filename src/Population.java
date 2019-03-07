//import java.util.*;
//import java.util.List;
//import java.util.Comparator;
//import java.util.Collections;
//
//public class Population {
//
//    //genetic algorithm population
//
//    //takes in masterschedule chromosomes adds them to population
//
//
//
//    private ArrayList<MasterSchedule> members;
//    private int goal;
//    private int size;
//    private int generationNumber;
//
//    public void MakePopulation(int goal, ArrayList<Course> courseName, ArrayList<Student> students){
//
//        this.members = new ArrayList<MasterSchedule>();
//
//        this.goal = goal;
//
//        this.size = size;
//
//        this.generationNumber = generationNumber;
//
//        while(members.size()<size){
//
//            MasterSchedule masterSchedule = new MasterSchedule(courseName, students);
//
//            members.add(masterSchedule);
//
//        }
//
//    }
//
//    public void sortPopulation() {
//
//        List list = Arrays.asList(members);
//
//        Collections.sort(list, new Comparator<MasterSchedule>() {
//
//            public int compare(MasterSchedule o1, MasterSchedule o2) {
//
//                return o1.totalCost()-o2.totalCost();
//
//            }
//
//        });
//
////        members = (MasterSchedule<>)list.toArray();
//
//    }
//
//  }
//
import java.util.*;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class Population {

    //genetic algorithm population

    //takes in masterschedule chromosomes adds them to population

    private ArrayList<MasterSchedule> members;
    private int goal, size, generationNumber;

    public void MakePopulation(int goal, ArrayList<Course> courseName){

        this.members = new ArrayList<MasterSchedule>();

        this.goal = goal;

        this.size = size;

        this.generationNumber = generationNumber;

        while(members.size()<size){

            MasterSchedule masterSchedule = new MasterSchedule(courseName);

            members.add(masterSchedule);

        }

    }

    public void sortPopulation() {

        List list = Arrays.asList(members);

        Collections.sort(list, new Comparator<MasterSchedule>() {

            public int compare(MasterSchedule o1, MasterSchedule o2) {

                return o1.totalCost()-o2.totalCost();

            }

        });

//        members = (MasterSchedule<MasterSchedule>)list.toArray();

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

}
