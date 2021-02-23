package be.infernalwhale.view;

import be.infernalwhale.Launcher;
import be.infernalwhale.model.Beer;
import be.infernalwhale.service.BeerService;
import be.infernalwhale.service.ServiceFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Statement;

public class BeerBlackjackView extends GridPane {
    private final BeerService beerService = ServiceFactory.createBeerService();
    private Integer alcConsumed = 0;

    // layout elements
    private final TableView<Beer> table = new TableView<>();
    private final Label alcoholConsumed = new Label("0");

    public BeerBlackjackView() {
        this.setPadding(new Insets(10, 10, 10 , 10));
        this.setHgap(5);
        this.setVgap(4);

        this.table.setMinWidth(500);

        Label beerLabel = new Label("Beer Blackjack");
        beerLabel.setFont(Font.font(
                beerLabel.getFont().getName(),
                FontWeight.BOLD,
                beerLabel.getFont().getSize() + 4
        ));

        this.add(beerLabel, 0,0);

        TableColumn<Beer, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().add(idColumn);
        TableColumn<Beer, String> nameColumn = new TableColumn<>("name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        TableColumn<Beer, String> brewerName = new TableColumn<>("Brewer");
        brewerName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getBrewer().getName()));
        table.getColumns().add(brewerName);
        TableColumn<Beer, String> catName = new TableColumn<>("Category");
        catName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCategory().getCategoryName()));
        table.getColumns().add(catName);
        TableColumn<Beer, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.getColumns().add(priceCol);
        TableColumn<Beer, Integer> alcoholCol = new TableColumn<>("Alcohol");
        alcoholCol.setCellValueFactory(new PropertyValueFactory<>("alcohol"));
        table.getColumns().add(alcoholCol);

        this.add(table, 0, 1);

        Button readButton = new Button("Read beers");
        readButton.setOnAction(event -> readBeersFromDB());

        Button chugSelected = new Button("Drink Selected");
        chugSelected.setOnAction(event -> drinkSelectedBeer());

        alcoholConsumed.setFont(Font.font(
                beerLabel.getFont().getName(),
                FontWeight.BOLD,
                beerLabel.getFont().getSize() + 20
        ));

        HBox buttonGroup = new HBox(10, readButton, chugSelected, alcoholConsumed);
        this.add(buttonGroup, 0, 2);

    }

    private void drinkSelectedBeer() {
        this.alcConsumed = this.alcConsumed + this.table.getSelectionModel().getSelectedItem().getAlcohol();
        this.alcoholConsumed.setText(alcConsumed.toString());

        GaussianBlur blur = new GaussianBlur(alcConsumed / 2f);
        this.table.setEffect(blur);

        this.table.getItems().clear();
        this.table.getItems().addAll(beerService.getBeers(alcConsumed));

        if (alcConsumed > 21) {
            Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.setTitle("You lost!");

            ImageView image = new ImageView("tooDrunk.jpeg");
            FlowPane pane = new FlowPane(image);
            popup.setScene(new Scene(pane));
            popup.showAndWait();
        }

        if (alcConsumed == 21) {
            Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.setTitle("Winner Winner - Chicken Dinner!");

            ImageView image = new ImageView("winnerWinner.jpeg");
            FlowPane pane = new FlowPane(image);
            popup.setScene(new Scene(pane));
            popup.showAndWait();
        }
    }

    private void readBeersFromDB() {
        this.table.getItems().addAll(beerService.getBeers());
    }

}
