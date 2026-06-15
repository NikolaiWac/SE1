package exercises.Uebung_4;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

//import exercises.Uebung3.CardBox;
//import exercises.Uebung3.CardboxStorageException;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserStoryManagement implements Serializable{
    private static final long serialVersionUID = 1L;
    private static UserStoryManagement instance = null;


    private TreeMap<Integer, UserStory> userStories;
    private TreeMap<Integer, Task> tasks;
    //Maps a UserStory to a Task, key = UsersStory.id, value = Task.id
    private TreeMap<Integer, LinkedList<Integer>> assignUStoT;
    private int assignCount;
    private transient String out;

    public static UserStoryManagement getInstance() {
        if(UserStoryManagement.instance == null)
            UserStoryManagement.instance = new UserStoryManagement();
        return UserStoryManagement.instance;
    }

    private UserStoryManagement(){
        this.userStories = new TreeMap<Integer, UserStory>();
        this.tasks = new TreeMap<Integer, Task>();
        this.assignUStoT = new TreeMap<Integer, LinkedList<Integer>>();
        assignCount = 0;
    }

    public int createUserStory(String description, int priority) {
        UserStory us = new UserStory(description, priority);
        userStories.put(us.id, us);
        return us.id;
    }

    public int createTask(String description) {
        Task t = new Task(description);
        tasks.put(t.id,t);
        return t.id;
    }

    public void assign(int usID, int tID) throws Exception{
        if(!this.userStories.containsKey(usID))
            throw new Exception("User Story ID is not available.");
        if(!this.tasks.containsKey(tID))
            throw new Exception("Task ID is not available.");
        if(this.assignUStoT.get(usID) != null && this.assignUStoT.get(usID).contains(tID))
            throw new Exception("Task has already been assigned to this User Story.");

        if(this.assignUStoT.containsKey(usID)) {
            this.assignUStoT.get(usID).add(tID);
        }else {
            LinkedList<Integer> l = new LinkedList<Integer>();
            l.add(tID);
            this.assignUStoT.put(usID,l);
        }
        assignCount++;
    }

    public String getUserStories() {
        this.out = "User Stories:\n| ID \t| Type \t\t\t\t| Description \t\t| Priority \t|";
        Consumer<Integer> printT = (tID) ->{
            this.out = String.format("%s\n%s", this.out, this.tasks.get(tID).toString());
        };
        BiConsumer<Integer, UserStory> printUS = (uID, uS) -> {
            this.out = String.format("%s\n%s", this.out, uS.toString());
            if(this.assignUStoT.containsKey(uID)) {
                this.assignUStoT.get(uID).forEach(printT);
            }
        };
        this.userStories.forEach(printUS);

        return this.out;
    }

    public String getTasks() {
        this.out = "Tasks:\n| ID \t| Type \t\t\t\t| Description \t\t|";
        BiConsumer<Integer, Task> printT = (tID, t) -> {
            this.out = String.format("%s\n%s", this.out, t.toString());
        };
        this.tasks.forEach(printT);;

        return this.out;
    }

    public static void save() throws FileNotFoundException, IOException{
        FileOutputStream fOut = new FileOutputStream("UserStoryManagement.obj");
        ObjectOutputStream oOut = new ObjectOutputStream(fOut);
        oOut.writeObject(UserStoryManagement.instance);
        oOut.flush();
        oOut.close();
    }

    public static void load() throws IOException, FileNotFoundException, ClassNotFoundException{
        FileInputStream fIn = new FileInputStream("UserStoryManagement.obj");
        ObjectInputStream oIn = new ObjectInputStream(fIn);
        UserStoryManagement.instance = (UserStoryManagement) oIn.readObject();
        oIn.close();
    }

    // returns the actual number of StorageObject instances(Userstorys+Tasks).
    public int getSize() {
        return this.userStories.size() + this.tasks.size();
    }

    public int getUSSize() {
        return this.userStories.size();
    }

    public int getTSize() {
        return this.tasks.size();
    }

    public int getAssignCount() {
        return this.assignCount;
    }

}
