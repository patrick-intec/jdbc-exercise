package be.infernalwhale.view;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainView extends TabPane {
    public MainView() {
        Tab connectionTab = createTab("Connection", new ConnectionView());
        Tab categoriesTab = createTab("Categories", new CategoryView());
        Tab beersTab = createTab("Beers");
        Tab brewersTab = createTab("Brewers");

        this.getTabs().addAll(connectionTab, categoriesTab, beersTab, brewersTab);
    }

    private Tab createTab(String name, Node node) {
        Tab tab = new Tab(name, node);
        tab.setClosable(false);
        return tab;
    }

    private Tab createTab(String name) {
        Tab tab = new Tab(name);

        tab.setClosable(false);

        return tab;
    }
}