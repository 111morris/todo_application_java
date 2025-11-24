import java.awt.*;

public class CommonConstants {
    // frame config
  public static final Dimension GUI_SIZE = new Dimension(540,760);

  //banner config
  public static final Dimension BANNER_SIZE = new Dimension(GUI_SIZE.width, 50);

  // task panel config
  public static final Dimension TASKPANEL_SIZE = new Dimension(GUI_SIZE.width -30,GUI_SIZE.height - 175 );

  // add task button config
  public static final Dimension ADDTASK_BUTTON_SIZE = new Dimension(GUI_SIZE.width, 50);

  // taskcomponent config
  public static final Dimension TASKFIELD_SIZE = new Dimension((int)(TASKPANEL_SIZE.width * 0.85), 50);
  public static final Dimension CHECKBOX_SIZE  = new Dimension((int)(TASKPANEL_SIZE.width * 0.05), 50);
  public static final Dimension DELETE_BUTTON_SIZE =new Dimension((int)(TASKPANEL_SIZE.width * 0.18),50);

  // colors (Nimbus friendly)
  public static final Color PRIMARY     = new Color(0x2196F3);
    public static final Color PRIMARY_DARK= new Color(0x1976D2);
    public static final Color DONE_GRAY   = new Color(0x9E9E9E);
    public static final Color ERROR_RED   = new Color(0xF44336);

    // font
    public static final Font  FONT_BIG  = new Font("Segoe UI", Font.PLAIN, 26);
    public static final Font  FONT_REG  = new Font("Segoe UI", Font.PLAIN, 14);

    // serial file
    public static final String STORAGE_FILE = "todo.ser";
}
