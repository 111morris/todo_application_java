import javax.swing.*;

public class ToDoListGui extends JFrame {
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

  }
}
