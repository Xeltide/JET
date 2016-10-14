package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import objects.Block;
import objects.BlockType;
import objects.VObject;

/**
 * <p>FileMenu.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class FileMenu extends JetMenu {

    private JFileChooser openProject = new JFileChooser();
    private JFileChooser saveProject = new JFileChooser();
    private JFileChooser saveAsProject = new JFileChooser();
    private JFileChooser openRoom = new JFileChooser();
    private JFileChooser saveRoom = new JFileChooser();
    private JFileChooser saveAsRoom = new JFileChooser();
    private final JetFileFilter jetFileFilter = new JetFileFilter();
    private final RoomFileFilter roomFileFilter = new RoomFileFilter();

    private JMenuItem newItem;
    private JMenuItem openProjectItem;
    private JMenuItem saveProjectItem;
    private JMenuItem saveProjectAsItem;

    private JMenuItem openRoomItem;
    private JMenuItem saveRoomItem;
    private JMenuItem saveRoomAsItem;

    private JMenuItem exitItem;

    public FileMenu() {
        super("File");
        setMnemonic(KeyEvent.VK_F);
        getAccessibleContext().setAccessibleDescription("The file menu");
        openProject.setFileFilter(jetFileFilter);
        saveProject.setFileFilter(jetFileFilter);
        saveAsProject.setFileFilter(jetFileFilter);

        openRoom.setFileFilter(roomFileFilter);
        saveRoom.setFileFilter(roomFileFilter);
        saveAsRoom.setFileFilter(roomFileFilter);


        newItem = new JMenuItem("New");
        newItem.setMnemonic(KeyEvent.VK_N);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newItem.addActionListener(this);
        add(newItem);

        openProjectItem = new JMenuItem("Open");
        openProjectItem.setMnemonic(KeyEvent.VK_O);
        openProjectItem.addActionListener(this);
        add(openProjectItem);

        saveProjectItem = new JMenuItem("Save");
        saveProjectItem.setMnemonic(KeyEvent.VK_S);
        saveProjectItem.addActionListener(this);
        add(saveProjectItem);

        saveProjectAsItem = new JMenuItem("Save As");
        saveProjectAsItem.setMnemonic(KeyEvent.VK_A);
        saveProjectAsItem.addActionListener(this);
        add(saveProjectAsItem);

        addSeparator();

        openRoomItem = new JMenuItem("Open Room");
        openRoomItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openRoomItem.addActionListener(this);
        add(openRoomItem);

        saveRoomItem = new JMenuItem("Save Room");
        saveRoomItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveRoomItem.addActionListener(this);
        add(saveRoomItem);

        saveRoomAsItem = new JMenuItem("Save Room As");
        saveRoomAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK));
        saveRoomAsItem.addActionListener(this);
        add(saveRoomAsItem);

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
        } else if (src == openProjectItem) {
            openProject();
        } else if (src == saveProjectItem) {
            saveProject();
        } else if (src == saveProjectAsItem) {
            saveProjectAs();
        } else if (src == openRoomItem) {
            openRoom();
        } else if (src == saveRoomItem) {
            saveRoom();
        } else if (src == saveRoomAsItem) {
            saveRoomAs();
        } else if (src == exitItem) {
            exit();
        }
    }

    private void openProject() {
        int v = openProject.showOpenDialog(FileMenu.this);
        if (v == JFileChooser.APPROVE_OPTION) {
            File file = openProject.getSelectedFile();
            saveProject.setSelectedFile(file);
        }
    }

    private void saveProject() {
        File file = saveProject.getSelectedFile();
        // If we aren't editing an existing project we save as
        if (file == null) {
            saveProjectAs();
        } else {
            System.out.println("Overwrite file");
        }
    }

    private void saveProjectAs() {
        int v = saveAsProject.showSaveDialog(FileMenu.this);
        if (v == JFileChooser.APPROVE_OPTION) {
            File file = saveAsProject.getSelectedFile();
            saveProject.setSelectedFile(file);
        }
    }

    private void openRoom() {
        int v = openRoom.showOpenDialog(FileMenu.this);
        if (v == JFileChooser.APPROVE_OPTION) {
            File file = openRoom.getSelectedFile();
            saveRoom.setSelectedFile(file);
            readRoomXml();
        }
    }

    private void saveRoom() {
        File file = saveRoom.getSelectedFile();
        // If we aren't editing an existing project we save as
        if (file == null) {
            saveRoomAs();
        } else {
            System.out.println("Overwrite room");
        }
    }

    private void saveRoomAs() {
        int v = saveAsRoom.showSaveDialog(FileMenu.this);
        if (v == JFileChooser.APPROVE_OPTION) {
            File file = saveAsRoom.getSelectedFile();
            saveRoom.setSelectedFile(file);
            System.out.println("Save a new room");
            createRoomXml(file);
        }
    }

    private void createRoomXml(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Project");
        doc.appendChild(rootElement);

        for (VObject vObj : Main.main.objH.getVObjects()) {
            Element vObjElement = doc.createElement("VObject");
            Element nameElement = doc.createElement("Name");
            nameElement.setTextContent(vObj.getName());
            rootElement.appendChild(vObjElement);
            vObjElement.appendChild(nameElement);

            for (Block block : vObj.getObjBlk()) {
                block.writeXml(doc, vObjElement);
            }
        }
        writeXml(doc, file);
    }

    private void readRoomXml() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = builder.parse(openRoom.getSelectedFile());
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        NodeList nl = doc.getElementsByTagName("VObject");
        for (int i = 0; i < nl.getLength(); i++) {
            Element vObjEle = (Element) nl.item(i);
            Element nameEle = (Element) vObjEle.getElementsByTagName("Name").item(0);
            String name = nameEle.getTextContent();
            VObject vObj = Main.main.objH.loadObject(name);
            NodeList blockList = vObjEle.getElementsByTagName("Block");
            for (int j = 0; j < blockList.getLength(); j++) {
                Element blkElement = (Element) blockList.item(j);
                String typeS = blkElement.getAttributes().getNamedItem("type").getTextContent();
                BlockType type = BlockType.getTypeFromString(typeS);
                Block block = type.getNewInstance();
                vObj.addBlock(block);
                block.readXml(doc, blkElement);
            }
        }
        revalidate();
        Main.main.repaint();
    }

    private void writeXml(Document doc, File file) {
        // write the content into xml file
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = null;
           try {
               transformer = transformerFactory.newTransformer();
           } catch (TransformerConfigurationException e1) {
               e1.printStackTrace();
           }
           DOMSource source = new DOMSource(doc);
           StreamResult result = new StreamResult(file);

           // Output to console for testing
           // StreamResult result = new StreamResult(System.out);

           try {
               transformer.transform(source, result);
           } catch (TransformerException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           System.out.println("File saved!");
       }

    public void exit() {
        int v = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit without saving?");
        switch (v) {
            case JOptionPane.YES_OPTION:
                System.exit(0);
                break;
            case JOptionPane.NO_OPTION:
                saveProject();
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

    private class RoomFileFilter extends FileFilter {

        public final Pattern r = Pattern.compile(".*\\.room$");

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
            return "Jet room files (*.room)";
        }

    }

}
