import java.util.*;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class Population {

    //genetic algorithm population

    //takes in masterschedule chromosomes adds them to population

    private ArrayList<MasterSchedule> members;

    private int goal;

    private int size;

    private int generationNumber;

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

                return o1.returnCost(15)-o2.returnCost(15);

            }

        });

        members = (MasterSchedule<>)list.toArray();

    }

  }

