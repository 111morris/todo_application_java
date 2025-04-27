import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGui extends JFrame implements ActionListener {
  // taskPanel will act as the container for the taskcomponentpanel
  // taskComponent will store all the taskcomponents


  private JPanel taskPanel, taskComponentPanel;
  public ToDoListGui(){
    super("To Do List Application");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setPreferredSize(CommonConstants.GUI_SIZE);
    pack();
    setLocationRelativeTo(null);
    setResizable(false);
    setLayout(null);
    addGuiComponent();
  }
  private void addGuiComponent() {
    //banner text
    JLabel bannerLabel = new JLabel("To Do List");
    bannerLabel.setBounds(
        (CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,
        15,
        CommonConstants.BANNER_SIZE.width,
        CommonConstants.BANNER_SIZE.height
    );

    // taskpanel
    taskPanel = new JPanel();

    // taskComponentPanel
    taskComponentPanel = new JPanel();
    taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
    taskPanel.add(taskComponentPanel);

    // add scrolling to teh task panel
    JScrollPane scrollpane = new JScrollPane(taskPanel);
    scrollpane.setBounds(8,78, CommonConstants.TASKPANEL_SIZE.width, CommonConstants.TASKPANEL_SIZE.height);
    scrollpane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
    scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    // add task button
    JButton addTaskButton = new JButton("Add Task");
    addTaskButton.setBounds(-5, CommonConstants.GUI_SIZE.height -88,
        CommonConstants.ADDTASK_BUTTON.width, CommonConstants.ADDTASK_BUTTON.height);
    addTaskButton.addActionListener(this);

    // add to frame
    this.getContentPane().add(bannerLabel);
    this.getContentPane().add(scrollpane);
    this.getContentPane().add(addTaskButton);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    if(command.equalsIgnoreCase("Add Task")){
      // create a task component
      TaskComponent taskComponent = new TaskComponent(taskComponentPanel);
      taskComponentPanel.add(taskComponent);

      // make the task field request focus after creation

      //continue from this error
      taskComponent.getTaskField().requestFocus();
      repaint();
      revalidate();
    }
  }
}
