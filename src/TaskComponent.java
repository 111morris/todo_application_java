import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskComponent extends JPanel implements ActionListener {
  private JCheckBox checkBox;
  private JTextPane taskField;
  private JButton deleteButton;

  public JTextPane getTaskField(){
    return taskField;
  }
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
    checkBox.addActionListener(this);
    // delete button
    deleteButton = new JButton("X");
    deleteButton.setPreferredSize(CommonConstants.DELETE_BUTTON_SIZE);
    deleteButton.addActionListener(this);
    //add to this task component
    add(checkBox);
    add(taskField);
    add(deleteButton);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(checkBox.isSelected()){
      //replace all the html tags to empty string to grab the main text
      String taskText = taskField.getText().replaceAll("<[^>]*>","");
      //add strike though text
      taskField.setText("<html><s>" + taskText + "</s></html>");
    } else if (!checkBox.isSelected()){
      String taskText = taskField.getText().replaceAll("<[^>]*>","");
      taskField.setText(taskText);
    }
    if(e.getActionCommand().equalsIgnoreCase("X")){
      // delete this component from teh parent panel
      parentPanl.remove(this);
      parentPanl.repaint();
      parentPanl.revalidate();
    }
  }
}