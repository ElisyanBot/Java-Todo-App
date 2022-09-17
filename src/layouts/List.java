package layouts;

/*
 * Bullet List component
*/
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class List extends JPanel {

  private ArrayList<ListItem> currentListItems;

  public List(ArrayList<ListItem> itemsList) {
    this.currentListItems = itemsList;

    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.setBackground(new Color(214, 255, 246));
    this.setPreferredSize(new Dimension(300, 100));
    addItemsFromArray();
  }

  // ========== METHODS ===========

  void addSingleItem(String text) {
    ListItem item = new ListItem();
    item.setCheckBoxItem(text);
    currentListItems.add(item);
    setupItemBtns(item);
    
    this.revalidate();
    this.repaint();
    this.add(item);
  }

  void addItemsFromArray() {
    for (ListItem item : currentListItems) {
      setupItemBtns(item);

      if (item.getCheckedStatus() == true) {
        item.checkBoxItem.setSelected(true);
      }

      this.add(item);
      this.revalidate();
      this.repaint();
    }
  }

  private void setupItemBtns(ListItem item) {
    item.setEditBtn("edit");
    item.setDeleteBtn("x", e -> {
      currentListItems.remove(item);
      this.remove(item);
      this.revalidate();
      this.repaint();
    });
  }

  // ========= getter and setters ============

  ListItem getItems() {
    ListItem i = null;
    for (ListItem item : currentListItems) {
      i = item;
    }
    return i;
  }

  void setItems(ArrayList<ListItem> newListItems) {
    this.currentListItems = newListItems;
  }
}
