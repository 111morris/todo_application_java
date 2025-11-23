import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text;
import java.awt;
import java.awt.event;

public class TaskComponent extends JPanel implements ActionListener {
  private JCheckBox checkBox;
  private JTextPane taskField;
  private JButton deleteButton;
  private static final long serialVersionUID = 1L;

    private final JTextField field;
    private final JCheckBox  check;
    private final JButton    delete;
    private final JPanel     parentPanel;
    private final Runnable   onChange;        // callback to save

    public TaskComponent(JPanel parentPanel, TaskBean bean, Runnable onChange){
        this.parentPanel = parentPanel;
        this.onChange    = onChange;
        setLayout(new BorderLayout(5,5));
        setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // force height

        check = new JCheckBox();
        check.setSelected(bean.isDone());
        check.addActionListener(e -> toggleStyle());
        check.setFocusable(false);

        field = new JTextField(bean.getText());
        field.getDocument().addDocumentListener((SimpleDocumentListener) e -> onChange.run());
        field.addActionListener(e -> {          // Enter = create next task
            if(!field.getText().trim().isEmpty())
                SwingUtilities.getWindowAncestor(this).dispatchEvent(
                        new WindowEvent(SwingUtilities.getWindowAncestor(this), WindowEvent.WINDOW_GAINED_FOCUS));
        });
        toggleStyle(); // apply strike-through if loaded done

        delete = new JButton("×");
        delete.setFont(delete.getFont().deriveFont(18f));
        delete.setToolTipText("Delete task");
        delete.setContentAreaFilled(false);
        delete.setBorderPainted(false);
        delete.setForeground(CommonConstants.ERROR_RED);
        delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        delete.addActionListener(e -> removeSelf());

        JPanel left = new JPanel(new BorderLayout());
        left.add(check, BorderLayout.WEST);
        left.add(field, BorderLayout.CENTER);

        add(left, BorderLayout.CENTER);
        add(delete, BorderLayout.EAST);
    }

    private void toggleStyle(){
        StyledDocument doc = (StyledDocument) field.getDocument();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setStrikeThrough(attr, check.isSelected());
        StyleConstants.setForeground(attr, check.isSelected() ? CommonConstants.DONE_GRAY : Color.BLACK);
        doc.setCharacterAttributes(0, doc.getLength(), attr, true);
        onChange.run();
    }

    private void removeSelf(){
        parentPanel.remove(this);
        parentPanel.revalidate();
        parentPanel.repaint();
        onChange.run();
    }

    public String getTaskText(){
        return field.getText().trim();
    }
    public boolean isDone(){
        return check.isSelected();
    }

    /* helper to avoid 3 empty methods */
    @FunctionalInterface
    interface SimpleDocumentListener extends javax.swing.event.DocumentListener {
        void update(javax.swing.event.DocumentEvent e);
        default void insertUpdate(javax.swing.event.DocumentEvent e){ update(e); }
        default void removeUpdate(javax.swing.event.DocumentEvent e){ update(e); }
        default void changedUpdate(javax.swing.event.DocumentEvent e){ update(e); }
    }



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
