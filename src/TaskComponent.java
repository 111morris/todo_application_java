import javax.swing.*;

public class TaskComponent extends JPanel {
  private JCheckBox checkBox;
  private JTextPane taskField;
  private JButton deleteButton;

  // this panel is used so that we can make updates to the task component panel when deleting tasks
  private JPanel parentPanl;
  public TaskComponent(JPanel parentPanl){
    this.parentPanl = parentPanl;


    // task field
    taskField = new JTextPane();
    taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
    taskField.setContentType("text/html");

    // checkbox
    checkBox = new JCheckBox();
    checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);

    // delete button
    deleteButton = new JButton("X");
//    deleteButton.setPreferredSize();


    //add to this taskcomponent
    add(taskField);
    add(checkBox);
    add(deleteButton);
  }
}
