package be.infernalwhale.view;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * Do not change ANYTHING in this class
 */
public class MainView extends TabPane {
    public MainView() {
        Tab connectionTab = createTab("Connection", new ConnectionView());
        Tab categoriesTab = createTab("Categories", new CategoryView());
        Tab beersTab = createTab("Beers Blackjack", new BeerBlackjackView());
        Tab brewersTab = createTab("Brewers", new BrewersView());

        this.getTabs().addAll(connectionTab, categoriesTab, brewersTab, beersTab);
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
