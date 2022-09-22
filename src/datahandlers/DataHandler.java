package datahandlers;

import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import javax.swing.filechooser.FileNameExtensionFilter;

class DataHandler {
  Scanner scanner;
  static File file;
  FileWriter writer;
  static String filePath;
  static String savedListsDir = System.getProperty("user.dir") + "\\src\\savedLists\\";

  public DataHandler() {

  }

  static void getSelectedFilePath() {
    try {
      JFileChooser chooser = new JFileChooser(savedListsDir);
      int JFileChooserResult = chooser.showOpenDialog(null);

      if (JFileChooserResult == JFileChooser.APPROVE_OPTION) {
        filePath = chooser.getSelectedFile().toString().replace("\\", "/");
      } else if (JFileChooserResult == JFileChooser.CANCEL_OPTION) {
        System.out.println("Canceled");
      }
    } catch (NullPointerException e) {
    }
  }

  static void setSelectedFilePath() {
    try {
      JFileChooser chooser = new JFileChooser(savedListsDir);
      int JFileChooserResult = chooser.showSaveDialog(null);
      File file = chooser.getSelectedFile();
      chooser.setFileFilter(new FileNameExtensionFilter("txt file", "txt"));


      if (JFileChooserResult == JFileChooser.APPROVE_OPTION) {
        String fileName = file.toString();
        if (!fileName.endsWith(".txt")) {
          fileName += ".txt";
          setFilePath(fileName
              .replace("\\", "/"));
        }

      } else if (JFileChooserResult == JFileChooser.CANCEL_OPTION) {
        System.out.println("Canceled");
      }
    } catch (NullPointerException e) {

    }
  }

  static String createNewDefaultFileName() {
    int newFileNumber = getHighestFileNameNumber(savedListsDir);
    String newFileName = String.format(savedListsDir + "myTodo%d.txt", newFileNumber);
    return newFileName;
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
          } // todo: add exception handlning if there isnt any numbers in myTodo.txt
        }
      }
    }
    return currentInt;
  }

  static String getCurrentFilePath() {
    return filePath;
  };

  static void setFilePath(String newPath) {
    filePath = newPath;
  }
}
