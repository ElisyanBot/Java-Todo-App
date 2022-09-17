package datahandlers;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import layouts.ListItem;

public class SaveData extends DataHandler {

  public SaveData() {
  };

  public void save(ArrayList<ListItem> items) {
    try {
      String path = getCurrentPath();
      file = new File(path);

    } catch (NullPointerException e) {
      String errMsg = "there is no file selecet, please select or create a new file!";
      
      JOptionPane.showMessageDialog(null, errMsg,
          "No Selected File!", JOptionPane.PLAIN_MESSAGE);
      path = getSelectedFilePath();
      // path = String.format("/src/savedLists/%s.txt", )
    }

    try {
      writer = new FileWriter(path);
      file.delete();
      file.createNewFile();

      for (ListItem item : items) {
        if (item.getCheckedStatus() == false) {
          writer.append("[] " + item.getText() + "\n");
        } else {
          writer.append("[x] " + item.getText() + "\n");
        }
      }
      writer.close();

    } catch (IOException e) {
      e.getStackTrace();
    }
  }

  public void SaveAs(ArrayList<ListItem> items) {
    String path = getSelectedFilePath();
    file = new File(path);

    try {
      writer = new FileWriter(path);
      file.delete();
      file.createNewFile();

      for (ListItem item : items) {
        if (item.getCheckedStatus() == false) {
          writer.append("[] " + item.getText() + "\n");
        } else {
          writer.append("[x] " + item.getText() + "\n");
        }
      }
      writer.close();

    } catch (IOException e) {
      e.getStackTrace();
    }

  }
}
