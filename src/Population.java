import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Population {
    //genetic algorithm population
    //takes in masterschedule chromosomes adds them to population
    private ArrayList<MasterSchedule> members;
    //private String goal;
    private int size;
    private int generationNumber;

    public Population(int size, String goal){
        this.members = new ArrayList<MasterSchedule>();
     //   this.goal = goal;
        this.size = size;
        this.generationNumber = generationNumber;
        while(members.size()<size){
            MasterSchedule masterSchedule = new MasterSchedule();
            members.add(masterSchedule);
        }
    }

  /*  public void sort(){
       Collections.sort(members, new Comparator<MasterSchedule>() {
            @Override
            public int compare(MasterSchedule a, MasterSchedule b){

            }
        }

    }
    */

  /*public boolean generation() {
  }
  */

  }

