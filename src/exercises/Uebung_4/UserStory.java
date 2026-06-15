package exercises.Uebung_4;

public class UserStory extends StorageObject {
    public static final String[] priorities = {"Must Have", "Should Have", "Could Have", "Won't Have"};
    private static final long serialVersionUID = 2L;
    private int priority;
    public UserStory( String description, int priority) {
        super("UserStory", description);
        this.priority = priority;
    }

    @Override
    public String toString() {
        return String.format("%s %s \t|", super.toString(),UserStory.priorities[this.priority]);
    }

}