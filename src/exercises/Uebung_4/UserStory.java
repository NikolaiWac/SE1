import java.util.ArrayList;
import java.util.List;

public class UserStory {
    private static int idcount = 0;
    private int id;
    private List<Integer> TaskIds;
    private String desc;
    private int prio;
    private final  String[] prios = {"Must","Should","Could","Won't Have"};


    public UserStory(String desc,int prio){
        this.desc = desc;
        this.prio = prio;
        this.id = idcount;
        idcount++;
        TaskIds = new ArrayList<>();
    }
    public UserStory(String desc,int prio,int id){  //Only use if Load data.
        this.desc = desc;
        this.prio = prio;
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public int[] getTasks(){
        int[] ret = new int[TaskIds.size()];
        int i = 0;
        for (int taskid : TaskIds){
            ret[i] = taskid;
            i++;
        }
        return ret;
    }
    public void addTask(int task){
        this.TaskIds.add(task);
    }

    @Override
    public String toString(){
        return id + " " + desc + " " + prios[prio];
    }
}
