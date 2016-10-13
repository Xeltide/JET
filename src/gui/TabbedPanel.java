package gui;

import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;

public class TabbedPanel extends JTabbedPane {

    Console console;
    AssetPanel asset;
    
    TabbedPanel() {
        console = new Console();
        asset = new AssetPanel();
        addTab("Assets", asset);
        addTab("Console", console);
    }
}
