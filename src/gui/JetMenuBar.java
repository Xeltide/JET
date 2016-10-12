package gui;

import javax.swing.JMenuBar;

/**
 * <p>JetMenuBar.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class JetMenuBar extends JMenuBar {

    private Main main;
    private FileMenu fileMenu;
    private EditMenu editMenu;
    private ViewMenu viewMenu;
    private VObjectMenu vObjectMenu;
    private HelpMenu helpMenu;

    public JetMenuBar(Main main) {
        this.main = main;
        JetMenu.setMain(main);
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
