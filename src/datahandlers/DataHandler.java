package datahandlers;

import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;

class DataHandler {
  Scanner scanner;
  File file;
  FileWriter writer;
  static String path;
  static String savedListsDir = System.getProperty("user.dir")
      + "\\src\\savedLists\\";

  public DataHandler() {

  }

  // todo: create exceptions/functions for when the user press cancel.
  static String getSelectedFilePath() {
    JFileChooser j = new JFileChooser(savedListsDir);
    j.showOpenDialog(null);

    path = j.getSelectedFile()
        .getAbsolutePath()
        .replace("\\", "/");
    return path + ".txt";
  }

  static String CreateNewFilePath() {
    int newFileNumber = getHighestFileNameNumber(savedListsDir);
    String newFilePath = String.format(savedListsDir + "myTodo%d.txt", newFileNumber);
    return newFilePath;
  }

  static Integer getHighestFileNameNumber(String folderPath) {
    int currentInt = 1;
    File dir = new File(folderPath);
    if (dir.isDirectory()) {
      for (String fileName : dir.list()) {
        if (fileName.contains("myTodo")) {

          int fileNr = Integer.parseInt(fileName
              .replace("myTodo", "") // removes word
              .replace(".txt", "")); // removes .ext

          if (fileNr >= currentInt) {
            currentInt = fileNr + 1;
          }
        }
      }
    }
    return currentInt ;
  }

  static String getCurrentPath() {
    return path;
  };

  void setPath(String newPath) {
    path = newPath;
  }
}
