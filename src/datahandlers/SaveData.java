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

  // todo: fix the problem with select file Path
  public void save(ArrayList<ListItem> items) {

    try {
      filePath = getCurrentFilePath();
      file = new File(filePath);
      this.writeToFile(items);

    } catch (NullPointerException e) {
      String errMsg = "There is no file select, please create or selected a file before Saving";
      JOptionPane.showMessageDialog(null, errMsg, "No selected file!", JOptionPane.PLAIN_MESSAGE);
      setSelectedFilePath();
    }

    
  }

  public void SaveAs(ArrayList<ListItem> items) {
    setSelectedFilePath();
    this.writeToFile(items);

  }

  void writeToFile(ArrayList<ListItem> items) {
    try {
      // todo: create a sepprate function "writeToFile"
      File file = new File(filePath);
      writer = new FileWriter(file);
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
    } catch (NullPointerException e) {
    }
  }

}
