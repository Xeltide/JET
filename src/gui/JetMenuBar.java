package gui;

import javax.swing.JMenuBar;

/**
 * <p>JetMenuBar.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class JetMenuBar extends JMenuBar {

    private FileMenu fileMenu;
    private EditMenu editMenu;
    private ViewMenu viewMenu;
    private VObjectMenu vObjectMenu;
    private HelpMenu helpMenu;


    public JetMenuBar() {
        fileMenu = new FileMenu();
        this.add(fileMenu);

        editMenu = new EditMenu();
        this.add(editMenu);

        viewMenu = new ViewMenu();
        this.add(viewMenu);

        vObjectMenu = new VObjectMenu();
        this.add(vObjectMenu);

        helpMenu = new HelpMenu();
        this.add(helpMenu);


    }

    public void exit() {
        fileMenu.exit();
    }

}
