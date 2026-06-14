public class Task {
    private static int idcount = 100;
    private int id;
    private String desc;

    public Task(String desc){
        this.desc = desc;
        this.id = idcount;
        idcount++;
    }
    public Task(String desc,int id){    // only use if load(); data.
        this.desc = desc;
        this.id = id;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return id + " " + desc;
    }
}
