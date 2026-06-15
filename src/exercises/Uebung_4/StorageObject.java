package exercises.Uebung_4;

import java.io.Serializable;

//entspricht der AbstractPersonCard
public abstract class StorageObject implements Serializable {
    public static final long serialVersionUID = 0l;
    public static int idCounter = 0;
    public final int  id;
    public final String type;
    private String description;

    public StorageObject(String type, String description ) {
        this.id = idCounter;
        idCounter++;
        this.type = type;
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String getObjDescriptor() {
        return String.format("| %d \t| %-15s", this.id, this.type);
    }

    @Override
    public String toString() {
        return String.format("%s \t| %s \t|", this.getObjDescriptor(), this.description);
    }
}

