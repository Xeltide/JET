package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

public class FileMenu extends JMenu implements ActionListener {

    private JFileChooser openFile = new JFileChooser();
    private JFileChooser saveFile = new JFileChooser();
    private JFileChooser saveAsFile = new JFileChooser();
    private final JetFileFilter jetFileFilter = new JetFileFilter();

    private JMenuItem newItem;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem saveAsItem;
    private JMenuItem exitItem;

    public FileMenu () {
        super("File");
        setMnemonic(KeyEvent.VK_F);
        getAccessibleContext().setAccessibleDescription("The file menu");
        openFile.setFileFilter(jetFileFilter);
        saveFile.setFileFilter(jetFileFilter);
        saveAsFile.setFileFilter(jetFileFilter);

        newItem = new JMenuItem("New");
        newItem.setMnemonic(KeyEvent.VK_N);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newItem.addActionListener(this);
        add(newItem);

        openItem = new JMenuItem("Open");
        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openItem.addActionListener(this);
        add(openItem);

        saveItem = new JMenuItem("Save");
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveItem.addActionListener(this);
        add(saveItem);

        saveAsItem = new JMenuItem("Save As");
        saveAsItem.setMnemonic(KeyEvent.VK_A);
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));
        saveAsItem.addActionListener(this);
        add(saveAsItem);

        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(this);
        add(exitItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem src = (JMenuItem) e.getSource();
        if (src == newItem) {
            // create a new project
            System.out.println("new item");
        } else if (src == openItem) {
            open();
        } else if (src == saveItem) {
            save();
        } else if (src == saveAsItem) {
            saveAs();
        } else if (src == exitItem) {
            exit();
        }
    }

    private void open() {
        int v = openFile.showOpenDialog(FileMenu.this);
        if (v == JFileChooser.APPROVE_OPTION) {
            File file = openFile.getSelectedFile();
            saveFile.setSelectedFile(file);
        }
    }

    private void save() {
        File file = saveFile.getSelectedFile();
        // If we aren't editing an existing project we save as
        if (file == null) {
            saveAs();
        } else {
            System.out.println("Overwrite file");
        }
    }

    private void saveAs() {
        int v = saveAsFile.showSaveDialog(FileMenu.this);
        if (v == JFileChooser.APPROVE_OPTION) {
            File file = saveAsFile.getSelectedFile();
            saveFile.setSelectedFile(file);
            System.out.println("Save a new file");
        }
    }

    public void exit() {
        int v = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit without saving?");
        switch (v) {
            case JOptionPane.YES_OPTION:
                System.exit(0);
                break;
            case JOptionPane.NO_OPTION:
                save();
                break;
            case JOptionPane.CANCEL_OPTION:
                break;
        }
    }

    /**
     * <p>JetFileFilter.</p>
     * @author Stephen Cheng
     * @version 0.1a
     */
    private class JetFileFilter extends FileFilter {

        public final Pattern r = Pattern.compile(".*\\.jet$");

        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            Matcher m = r.matcher(f.getName());
            if (m.find()) {
                    return true;
                }
            return false;
        }

        @Override
        public String getDescription() {
            return "Jet project files (*.jet)";
        }

    }

}
