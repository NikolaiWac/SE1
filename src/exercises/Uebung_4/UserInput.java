
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {

    private String userIP;
    private Scanner scIn;
    private UserStoryManagement usm;

    //List für Tasks und UserStorys damit diese mit Load geladen und ohne zu speichern erstellt werden können.
    private List<Task> SessionTasks;
    private List<UserStory> SessionUserStorys;

    public static void main(String[] args) {
        UserInput ui = new UserInput();
        while(true)
            ui.processCommand();
    }

    public UserInput() {
        userIP = "";
        scIn = new Scanner(System.in);
    //    usm = UserStoryManagement.getInstance();
        SessionTasks = new ArrayList<>();
        SessionUserStorys = new ArrayList<>();
    }

    public void processCommand() {
        //Skip to front of scanner.in
        println("Enter command");
        print("> ");
        while(!scIn.hasNextLine());
        switch(scIn.next()) {
            case "help":
                println("Types of possible commands: \n story \n task \n assign \n stories \n tasks \n load \n save \n" +
                        "For further information please refer to Uebung4.pdf");
                break;

            case "story":
                this.story();
                break;

            case "task":
                this.task();
                break;

            case "assign":
                this.assign();
                break;

            case "stories":
                this.stories();
                break;

            case "tasks":
                this.tasks();
                break;

            case "load":
            //    this.load();
                break;

            case "save":
            //    this.save();
                break;
        }

    }

    private void tasks() {
        for (Task task : SessionTasks) {
            System.out.println(task);
        }
    }

    private void stories() {
        for (UserStory userstory : SessionUserStorys){      //für jede Story gehe jede ihrer taks durch und suche nach der id in allen Tasks und gebe diese zurück
            System.out.println(SessionUserStorys);          //könnte man auch einfacher regeln indem direkt die task übergeben wird allerdings würde dann bei einer enerdung
            int[] tasks = userstory.getTasks();             //der task nicht auch die task welche die Story hält geendert. (id system wäre sinnlos)
            for (int i = 0; i<tasks.length;i++){
                for (Task task : SessionTasks) {
                    if (task.getId() == tasks[i]) {
                        System.out.println(task);
                        break;
                    }
                }
            }
        }

    }

    private void assign() {
        scIn.nextLine();
        println("Please enter User Story ID:");
        int usID = scIn.nextInt();
        scIn.nextLine();
        println("Please enter Task ID:");
        int tID = scIn.nextInt();
        try {
            Task_assign(usID, tID);
        }catch(Exception e) {
            println("The was an error: "+ e.getMessage());
            return;
        }
        println(String.format("Assigned User Story %d to Task %d.",usID,tID));

    }

    private void task() {
        scIn.nextLine();
        println("Please write a task description:");
        String desc = scIn.nextLine();
        createTask(desc);
        println("Task created.");

    }

    private void story() {
        scIn.nextLine();
        println("Please write a task description:");
        String desc = scIn.nextLine();
        int prio = -1;
        while(true)
        {
            println("Please enter a priority(0=Must, 1=Should, 2=Could, 3=Won't Have)");
            prio = scIn.nextInt();
            if(0 <=prio && prio <= 3)
                break;
            scIn.nextLine();
        }
        createUserStory(desc,prio);
        println("Story created.");
    }

    /*public void save() {
        try {
            UserStoryManagement.save();
        }catch(Exception e) {
            println("An Exception occured: "+e.getMessage());
        }
        println("Save sucessfull.");
    }
    */

    /*public void load() {
        try {
            UserStoryManagement.load();
        }catch(Exception e) {
            println("Exception!"+e.getMessage());
        }
        println("Load successful.");
    }
    */

    private void println(String m) {
        System.out.println(m);
    }

    private void print(String m) {
        System.out.print(m);
    }
    public void createTask(String disc){
        Task task = new Task(disc);
        this.SessionTasks.add(task);
    }
    public void createUserStory(String disc,int prio){
        UserStory userstory = new UserStory(disc,prio);
        this.SessionUserStorys.add(userstory);
    }

    public void Task_assign(int usID, int tID) throws Exception {
        boolean foundsomething = false;
        for (Task task : SessionTasks){
            if(task.getId() == tID){
                foundsomething = true;
                break;
            }
        }
        if(!foundsomething) {
            throw new Exception("Task wurde nicht gefunden");
        }
        foundsomething = false;
        for(UserStory userstory : SessionUserStorys){
            if(userstory.getId() == usID){
                userstory.addTask(tID);
                foundsomething = true;
                break;
            }
        }
        if(!foundsomething) {
            throw new Exception("UserStory wurde nicht gefunden");
        }
    }
}
