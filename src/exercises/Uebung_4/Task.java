package exercises.Uebung_4;

public class Task extends StorageObject {
    public static final String type = "Task";
    private static final long serialVersionUID = 1L;

    public Task(String description) {
        super(Task.type, description);

    }



    @Override
    public String toString() {
        return super.toString();
    }


}
