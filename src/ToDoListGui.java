import netscape.javascript.JSObject;

import javax.swing.*;
import java.awt.*;

public class ToDoListGui extends JFrame {
  // taskPanel will act as the container for the taskcomponentpanel
  // taskComponent will store all of the taskcomponents


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

    // taskpnale
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


    // ad to frame
    this.getContentPane().add(bannerLabel);
    this.getContentPane().add(scrollpane);
  }
}
