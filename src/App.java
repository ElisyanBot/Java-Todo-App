
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import datahandlers.LoadData;
import datahandlers.SaveData;

import layouts.ListContainer;
import layouts.ListItem;

public class App {
  static ArrayList<ListItem> currentList = new ArrayList<>();
  static ListContainer container = new ListContainer(currentList);

  public static void main(String[] args) {

    JFrame frame = new JFrame();
    JMenuBar menuBar = new JMenuBar();
    JMenu filesMenuTab = new JMenu("files");
    JMenuItem save = new JMenuItem("save");
    JMenuItem saveFileAs = new JMenuItem("save as...");
    JMenuItem load = new JMenuItem("Open file...");

    SaveData saveData = new SaveData();
    save.addActionListener(e -> {
      saveData.save(currentList);
    });

    saveFileAs.addActionListener(e ->{
      saveData.SaveAs(currentList);
    });

    load.addActionListener(e -> {
      LoadData loadItems = new LoadData();
      frame.remove(container);
      currentList = loadItems.getLoadeditems();
      container = new ListContainer(currentList);
      frame.add(container, BorderLayout.CENTER);
      frame.validate();
      frame.repaint();
    });

    filesMenuTab.add(save);
    filesMenuTab.add(saveFileAs);
    filesMenuTab.add(load);
    menuBar.add(filesMenuTab);

    frame.setLayout(new BorderLayout());
    frame.add(menuBar, BorderLayout.NORTH);
    frame.add(container, BorderLayout.CENTER);

    frame.setTitle("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setMinimumSize(new Dimension(500, 800));
    frame.setVisible(true); // this must be last
  }
}
