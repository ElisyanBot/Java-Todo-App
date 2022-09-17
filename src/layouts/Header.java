package layouts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;


import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

//214, 255, 246 -> white
//77, 204, 189 -> green
//35, 116, 171 -> blue

public class Header extends JPanel{

  JButton addBtn;
  JTextField textField;
  JPanel container = new JPanel();

  public Header(int width, int height){
    this.setBackground(new Color(77, 204, 189));
    this.setPreferredSize(new Dimension(width, height));
    this.setLayout(new GridBagLayout());
    //container for text + input field
    this.container.setOpaque(false);
    this.add(container);
  }

  //text
  void setTextField(JTextField Field, int width, int height){
    this.textField = Field;
    this.textField.setPreferredSize(new Dimension(width, height));
    this.container.add(this.textField);
  }

  //btns
  void setBtn(JButton btn, int width, int height){
    this.addBtn = btn;
    this.addBtn.setPreferredSize(new Dimension(width, height));
    this.container.add(this.addBtn);
  }

  //overload
  void setBtn(JButton btn, int width, int height, ActionListener func){
    this.addBtn = btn;
    this.addBtn.setPreferredSize(new Dimension(width, height));
    this.addBtn.addActionListener(func);
    this.container.add(this.addBtn);
  }
}
