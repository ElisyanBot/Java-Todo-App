package layouts;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.Color;

public class ListItem extends JPanel {
  private int id;
  private boolean checkedStatus = false;
  JPanel btnContainer = new JPanel();
  JCheckBox checkBoxItem;

  public ListItem() {
    this.setMaximumSize(new Dimension(350, 50));
    this.setLayout(new BorderLayout());
    this.setOpaque(false);

    this.btnContainer.setLayout(new GridBagLayout());
    this.btnContainer.setOpaque(false);
    this.add(btnContainer, BorderLayout.LINE_END);
  }

  // ========== methods ===========

  // edit btn
  public void setEditBtn(String innerText) {
    JButton editBtn = new JButton(innerText);
    editBtn.setBackground(new Color(255, 255, 130));
    editBtn.addActionListener(e -> {
      String newTask = JOptionPane.showInputDialog("edit you task");
      this.checkBoxItem.setText(newTask);
    });
    this.btnContainer.add(editBtn);
  }

  // Delete btn
  public void setDeleteBtn(String innerText, ActionListener func) {
    JButton deleteBtn = new JButton(innerText);
    deleteBtn.setBackground(new Color(255, 166, 134));
    deleteBtn.addActionListener(func);
    this.btnContainer.add(deleteBtn);
  }

  // text item
  public void setCheckBoxItem(String innerText) {
    this.checkBoxItem = new JCheckBox(innerText);
    this.checkBoxItem.setSize(new Dimension(350, 50));
    this.checkBoxItem.setFocusable(false);
    this.checkBoxItem.setOpaque(false);

    this.checkBoxItem.addActionListener(e -> {
      if (this.checkBoxItem.isSelected()) {
        setCheckedStatus(true);
      } else {
        setCheckedStatus(false);
      }
    });

    this.add(this.checkBoxItem, BorderLayout.LINE_START);
  }

  // ========= getter and setters ============

  public boolean getCheckedStatus() {
    return this.checkedStatus;
  }

  public void setCheckedStatus(boolean status) {
    this.checkedStatus = status;
  }

  public String getText() {
    return this.checkBoxItem.getText();
  }

  void setId(int id) {
    this.id = id;
  }

  int getId() {
    return this.id;
  }
}
