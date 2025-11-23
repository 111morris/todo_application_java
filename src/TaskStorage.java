import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class TaskStorage {
    private TaskStorage(){}

    public static void save(List<TaskBean> list){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CommonConstants.STORAGE_FILE))){
            oos.writeObject(list);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<TaskBean> load(){
        File f = new File(CommonConstants.STORAGE_FILE);
        if(!f.exists()) return new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
            return (List<TaskBean>) ois.readObject();
        }catch(Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

}