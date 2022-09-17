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
    file = new File(getSelectedFilePath());
    String unchecked = "(\\[\\])";
    String checked = "(\\[\\w\\])";

    try {
      this.scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
        ListItem loadedItem = new ListItem();
        String innerText = "";
        if (scanner.hasNext(Pattern.compile(unchecked))) {
          loadedItem.setCheckedStatus(false);
          innerText = fetchInnerText(scanner.nextLine());
        } 
        else if (scanner.hasNext(Pattern.compile(checked))) {
          loadedItem.setCheckedStatus(true);
           innerText = fetchInnerText(scanner.nextLine());
        }
        else {
          innerText = scanner.nextLine();
        }
        
        loadedItem.setCheckBoxItem(innerText);
        loadedItems.add(loadedItem);
      }
      scanner.close();

    } catch (FileNotFoundException e) {
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
