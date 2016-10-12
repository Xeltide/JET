package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class HelpMenu extends JMenu implements ActionListener {

    private JMenuItem helpItem;
    private JMenuItem aboutItem;

    public HelpMenu() {
        super("Help");
        setMnemonic(KeyEvent.VK_H);
        getAccessibleContext().setAccessibleDescription("The help menu");

        aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(this);
        add(aboutItem);

        helpItem = new JMenuItem("Help");
        helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        helpItem.addActionListener(this);
        add(helpItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem src = (JMenuItem) e.getSource();
        if (src == aboutItem) {
            About about = new About();
            about.pack();
            about.setVisible(true);
        } else if (src == helpItem) {
            Help help = new Help();
            help.pack();
            help.setVisible(true);
        }
    }

}
