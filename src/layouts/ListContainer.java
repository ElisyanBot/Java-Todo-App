package layouts;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
/*
 * prgram frame
 */
import java.util.ArrayList;



public class ListContainer extends JPanel{
  Header head ;
  List list;

  public ListContainer(ArrayList<ListItem> items){
    this.list = new List(items);
    this.head = new Header(100, 100);

    head.setTextField(new JTextField(), 250,40);
    head.setBtn(
      new JButton("add"), 80, 40, e -> {
        if(head.textField.getText().isEmpty()) {
          System.out.println("obs! Empty input");
        } 
        else {
          list.addSingleItem(head.textField.getText());
          head.textField.setText(null);
        }
    });
    this.style();
  }

  // getter and setters
  public void setList(ArrayList<ListItem> items) {
    this.list = new List(items);
  }

  //styling

  void style(){
    this.setLayout(new BorderLayout());
    this.setMinimumSize(new Dimension(500, 800));
    this.setBackground(new Color(214, 255, 246));    
    this.add(this.head, BorderLayout.NORTH);
    this.add(this.list, BorderLayout.CENTER);
    this.setVisible(true); //this must be last
  }



}
