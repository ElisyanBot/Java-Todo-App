package datahandlers;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import layouts.ListItem;

public class LoadData extends DataHandler {

  private ArrayList<ListItem> loadedItems = new ArrayList<>();

  public LoadData() {
    loadItems();
  }

  void loadItems() {
    try {
      getSelectedFilePath();

      file = new File(filePath);
      this.scanner = new Scanner(file);
      String unchecked = "(\\[\\])";
      String checked = "(\\[\\w\\])";

      while (scanner.hasNextLine()) {
        ListItem item = new ListItem();
        String innerText = "";
        if (scanner.hasNext(Pattern.compile(unchecked))) {
          item.setCheckedStatus(false);
          innerText = fetchInnerText(scanner.nextLine());
        } 
        else if (scanner.hasNext(Pattern.compile(checked))) {
          item.setCheckedStatus(true);
           innerText = fetchInnerText(scanner.nextLine());
        }
        else {
          innerText = scanner.nextLine();
        }
        
        item.setCheckBoxItem(innerText);
        loadedItems.add(item);
      }
      scanner.close();

    } catch (FileNotFoundException e) {
      e.getStackTrace();
    } catch(NullPointerException e) {
      e.getStackTrace();
    }
  }

  String fetchInnerText(String task) {
    int startIndex = task.indexOf("]") + 2;
    int endIndex = task.length();
    return task.substring(startIndex, endIndex);
  }

  public ArrayList<ListItem> getLoadeditems() {
    return loadedItems;
  }
}
