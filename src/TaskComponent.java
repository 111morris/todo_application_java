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
