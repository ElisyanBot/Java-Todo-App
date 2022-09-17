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

  public DataHandler() {

  }

  // todo: create exceptions/functions for when the user press cancel.
  static String getSelectedFilePath() {
    JFileChooser j = new JFileChooser(System.getProperty("user.dir") + "\\src\\savedLists\\");
    j.showOpenDialog(null);

    path = j.getSelectedFile()
        .getAbsolutePath()
        .replace("\\", "/");
    return path + ".txt";
  }

  static String getCurrentPath() {
    return path;
  };

  void setPath(String newPath) {
    path = newPath;
  }
}
