package be.infernalwhale.view;

import be.infernalwhale.model.Brewer;
import be.infernalwhale.service.BrewersService;
import be.infernalwhale.service.ServiceFactory;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BrewersView extends GridPane {
    private BrewersService service = ServiceFactory.createBrewersService();

    // Layout elements
    private TableView<Brewer> table = new TableView<>();

    public BrewersView() {
        this.setPadding(new Insets(10, 10, 10 , 10));
        this.setHgap(5);
        this.setVgap(4);

        createTableView();
        table.getItems().addAll(service.getBrewers());

        Label brewLabel = new Label("Brewers View");
        brewLabel.setFont(Font.font(
                brewLabel.getFont().getName(),
                FontWeight.BOLD,
                brewLabel.getFont().getSize() + 4
        ));

        this.add(brewLabel, 0,0);
        this.add(table, 0, 1);

        Button b = new Button("Click me");
        b.setOnAction(event -> System.out.println(table.getWidth()));
        this.add(b, 0, 2);
    }


    private void createTableView() {
        TableColumn<Brewer, Integer> idCol = new TableColumn<>();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().add(idCol);
        TableColumn<Brewer, String> nameCol = new TableColumn<>();
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameCol);
        TableColumn<Brewer, String> addressCol = new TableColumn<>();
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        table.getColumns().add(addressCol);
        TableColumn<Brewer, Integer> zipcodeCol = new TableColumn<>();
        zipcodeCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        table.getColumns().add(zipcodeCol);
        TableColumn<Brewer, String> cityCol = new TableColumn<>();
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        table.getColumns().add(cityCol);
        TableColumn<Brewer, Integer> turnoverCol = new TableColumn<>();
        turnoverCol.setCellValueFactory(new PropertyValueFactory<>("turnover"));
        table.getColumns().add(turnoverCol);

        table.setMinWidth(550);
    }

}
