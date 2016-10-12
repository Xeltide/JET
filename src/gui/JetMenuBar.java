package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

/**
 * <p>JetMenuBar.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class JetMenuBar extends JMenuBar {

    private final JFileChooser openFile = new JFileChooser();
    private final JFileChooser saveFile = new JFileChooser();
    private final JFileChooser saveAsFile = new JFileChooser();
    private final JetFileFilter jetFileFilter = new JetFileFilter();

    private JMenu fileMenu;
    private FileMenuListener fListener;

    private JMenu editMenu;
    private EditMenuListener eListener;

    private JMenu helpMenu;
    private HelpMenuListener hListener;

    private JMenuItem newItem;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem saveAsItem;

    private JMenuItem undoItem;
    private JMenuItem redoItem;
    private JMenuItem cutItem;
    private JMenuItem copyItem;
    private JMenuItem pasteItem;

    private JMenuItem aboutItem;

    public JetMenuBar() {
        openFile.setFileFilter(jetFileFilter);
        saveFile.setFileFilter(jetFileFilter);
        saveAsFile.setFileFilter(jetFileFilter);

        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.getAccessibleContext().setAccessibleDescription("The file menu");
        fListener = new FileMenuListener();
        this.add(fileMenu);

        newItem = new JMenuItem("New");
        newItem.setMnemonic(KeyEvent.VK_N);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newItem.addActionListener(fListener);
        fileMenu.add(newItem);

        openItem = new JMenuItem("Open");
        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openItem.addActionListener(fListener);
        fileMenu.add(openItem);

        saveItem = new JMenuItem("Save");
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveItem.addActionListener(fListener);
        fileMenu.add(saveItem);

        saveAsItem = new JMenuItem("Save As");
        saveAsItem.setMnemonic(KeyEvent.VK_A);
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));
        saveAsItem.addActionListener(fListener);
        fileMenu.add(saveAsItem);


        editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        editMenu.getAccessibleContext().setAccessibleDescription("The edit menu");
        eListener = new EditMenuListener();
        this.add(editMenu);

        undoItem = new JMenuItem("Undo");
        undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        undoItem.addActionListener(eListener);
        editMenu.add(undoItem);

        redoItem = new JMenuItem("Redo");
        redoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        redoItem.addActionListener(eListener);
        editMenu.add(redoItem);

        editMenu.addSeparator();

        cutItem = new JMenuItem("Cut");
        cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cutItem.addActionListener(eListener);
        editMenu.add(cutItem);

        copyItem = new JMenuItem("Copy");
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copyItem.addActionListener(eListener);
        editMenu.add(copyItem);

        pasteItem = new JMenuItem("Paste");
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        pasteItem.addActionListener(eListener);
        editMenu.add(pasteItem);

        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.getAccessibleContext().setAccessibleDescription("The help menu");
        hListener = new HelpMenuListener();
        this.add(helpMenu);

        aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);
    }

    /**
     * <p>FileMenuListener.</p>
     * @author Stephen Cheng
     * @version 0.1a
     */
    private class FileMenuListener implements ActionListener {

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
            }
        }

        private void open() {
            int v = openFile.showOpenDialog(JetMenuBar.this);
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
            int v = saveAsFile.showSaveDialog(JetMenuBar.this);
            if (v == JFileChooser.APPROVE_OPTION) {
                File file = saveAsFile.getSelectedFile();
                saveFile.setSelectedFile(file);
                System.out.println("Save a new file");
            }
        }

    }

    /**
     * <p>EditMenuListener.</p>
     * @author Stephen Cheng
     * @version 0.1a
     */
    private class EditMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem src = (JMenuItem) e.getSource();
            if (src == undoItem) {

            } else if (src == redoItem) {

            } else if (src == cutItem) {

            } else if (src == copyItem) {

            } else if (src == pasteItem) {

            }
        }

    }

    /**
     * <p>HelpMenuListener.</p>
     * @author Stephen Cheng
     * @version 0.1a
     */
    private class HelpMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem src = (JMenuItem) e.getSource();
        }

    }

    /**
     * <p>JetFileFilter.</p>
     * @author Stephen Cheng
     * @version 0.1a
     */
    private class JetFileFilter extends FileFilter {

        public static final String JET = "jet";

        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return false;
            }
            String extension = getExtension(f);
            if (extension.equals(JET)) {
                return true;
            }
            return false;
        }


        @Override
        public String getDescription() {
            return "Jet project files (*.jet)";
        }

        /*
         * Get the extension of a file.
         * https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html#filters
         */
        public String getExtension(File f) {
            String ext = null;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 &&  i < s.length() - 1) {
                ext = s.substring(i+1).toLowerCase();
            }
            return ext;
        }

    }


}
