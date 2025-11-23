import java.io.Serializable;


public class TaskBean implements Serializable{
    private static final long serialVersionUID = 1l;
    private String text;
    private boolean done;

    public TaskBean(String text, boolean done){
        this.text = text;
        this.done = done;
    }
    public String getText(){ return text; }
    public boolean isDone(){ return done; }

}

