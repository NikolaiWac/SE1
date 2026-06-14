
import java.util.Scanner;

public class UserInput {

    private String userIP;
    private Scanner scIn;
    private UserStoryManagement usm;

    public static void main(String[] args) {
        UserInput ui = new UserInput();
        while(true)
            ui.processCommand();
    }

    public UserInput() {
        userIP = "";
        scIn = new Scanner(System.in);
        usm = UserStoryManagement.getInstance();
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
                this.load();
                break;

            case "save":
                this.save();
                break;
        }

    }

    private void tasks() {
        println(usm.getTasks());

    }

    private void stories() {
        println(usm.getUserStories());

    }

    private void assign() {
        scIn.nextLine();
        println("Please enter User Story ID:");
        int usID = scIn.nextInt();
        scIn.nextLine();
        println("Please enter Task ID:");
        int tID = scIn.nextInt();
        try {
            usm.assign(usID, tID);
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
        usm.createTask(desc);
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
        usm.createUserStory(desc,prio);
        println("Story created.");
    }

    public void save() {
        try {
            UserStoryManagement.save();
        }catch(Exception e) {
            println("An Exception occured: "+e.getMessage());
        }
        println("Save sucessfull.");
    }

    public void load() {
        try {
            UserStoryManagement.load();
        }catch(Exception e) {
            println("Exception!"+e.getMessage());
        }
        println("Load successful.");
    }


    private void println(String m) {
        System.out.println(m);
    }

    private void print(String m) {
        System.out.print(m);
    }
}
