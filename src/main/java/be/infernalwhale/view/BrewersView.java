package be.infernalwhale.view;

import be.infernalwhale.model.Brewer;
import be.infernalwhale.service.BrewersService;
import be.infernalwhale.service.ServiceFactory;
import be.infernalwhale.service.data.Valuta;
import be.infernalwhale.service.exception.ValidationException;
import be.infernalwhale.view.exceptions.FormReadException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Do not change ANYTHING in this class
 */
public class BrewersView extends GridPane {
    private final BrewersService service = ServiceFactory.createBrewersService();
    private Valuta currentValuta = Valuta.EURO;

    // Layout elements
    private final TableView<Brewer> table = new TableView<>();
    private final TextField idField = new TextField();
    private final TextField nameField = new TextField();
    private final TextField addressField = new TextField();
    private final TextField zipcodeField = new TextField();
    private final TextField cityField = new TextField();
    private final TextField turnoverField = new TextField();
    private final Label errorText = new Label("");

    public BrewersView() {
        this.setPadding(new Insets(10, 10, 10 , 10));
        this.setHgap(5);
        this.setVgap(4);

        createTableView();
//        table.getItems().addAll(service.getBrewers());
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> tableSelectionChanged(newValue));

        Label brewLabel = new Label("Brewers View");
        brewLabel.setFont(Font.font(
                brewLabel.getFont().getName(),
                FontWeight.BOLD,
                brewLabel.getFont().getSize() + 4
        ));

        this.add(brewLabel, 0,0);
        this.add(table, 0, 1);

        Button refreshButton = new Button("Read from DB");
        Button euroButton = new Button("Euro");
        Button dollarButton = new Button("USD");
        Button yenButton = new Button("Yen");

        refreshButton.setOnAction(event -> refresh());
        euroButton.setOnAction(event -> refreshInCurrency(Valuta.EURO));
        dollarButton.setOnAction(event -> refreshInCurrency(Valuta.USD));
        yenButton.setOnAction(event -> refreshInCurrency(Valuta.YEN));

        HBox buttonGroup = new HBox(5, refreshButton, euroButton, dollarButton, yenButton);
        this.add(buttonGroup, 0, 2);

        GridPane form = new GridPane();
        form.setPadding(new Insets(5, 5, 5, 5));
        form.add(new Label("ID: "), 0, 0);
        form.add(idField, 1, 0);
        form.add(new Label("Name: "), 0, 1);
        form.add(nameField, 1, 1);
        form.add(new Label("Address: "), 0, 2);
        form.add(addressField, 1, 2);
        form.add(new Label("Zipcode: "), 0, 3);
        form.add(zipcodeField, 1, 3);
        form.add(new Label("City: "), 0, 4);
        form.add(cityField, 1, 4);
        form.add(new Label("Turnover: "), 0, 5);
        form.add(turnoverField, 1, 5);

        Button clearButton = new Button("Clear");
        Button createButton = new Button("Create");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        HBox formButtons = new HBox(5, clearButton, createButton, updateButton, deleteButton);
        form.add(formButtons, 1, 6);
        form.add(errorText, 0, 7, 2, 1);

        clearButton.setOnAction(this::clearForm);
        createButton.setOnAction(this::createBrewer);
        updateButton.setOnAction(this::updateBrewer);

        this.add(form, 3, 1);
    }

    private void refresh() {
        this.table.getItems().clear();
        this.table.getItems().addAll(service.getBrewers());
    }

    private void updateBrewer(ActionEvent event) {
        try {
            Brewer toUpdateBrewer = readForm();
            Brewer saved = service.updateBrewer(toUpdateBrewer);

            this.table.getItems().stream()
                    .filter(brewer -> brewer.getId().equals(saved.getId()))
                    .findFirst()
                    .ifPresent(brewer -> this.table.getItems().remove(brewer));
            this.table.getItems().add(saved);
        } catch (FormReadException | ValidationException exception) {
            errorText.setText(exception.getMessage());
        }
    }

    private void createBrewer(ActionEvent event) {
        try {
            Brewer newBrewer = readForm();
            Brewer saved = service.createBrewer(newBrewer);
            this.table.getItems().add(saved);
        } catch (FormReadException | ValidationException e) {
            errorText.setText(e.getMessage());
        }
    }

    private Brewer readForm() throws FormReadException {
        try {
            return new Brewer(
                    (this.idField.getText().isEmpty()) ? null : Integer.parseInt(this.idField.getText()),
                    this.nameField.getText(),
                    this.addressField.getText(),
                    (this.zipcodeField.getText().isEmpty()) ? 0 : Integer.parseInt(this.zipcodeField.getText()),
                    this.cityField.getText(),
                    (this.turnoverField.getText().isEmpty()) ? 0 : Integer.parseInt(this.turnoverField.getText())
            );
        } catch (NullPointerException | NumberFormatException exception) {
            exception.printStackTrace();
            throw new FormReadException("Sometimes you need to check what you type...");
        }
    }

    private void clearForm(ActionEvent event) {
        this.idField.clear();
        this.nameField.clear();
        this.addressField.clear();
        this.zipcodeField.clear();
        this.cityField.clear();
        this.turnoverField.clear();
    }


    private void tableSelectionChanged(Brewer selected) {
        this.idField.setText(selected.getId().toString());
        this.nameField.setText(selected.getName());
        this.addressField.setText(selected.getAddress());
        this.zipcodeField.setText(selected.getZipcode().toString());
        this.cityField.setText(selected.getCity());
        this.turnoverField.setText(selected.getTurnover().toString());
    }

    private void refreshInCurrency(Valuta currency) {
        if (currency == this.currentValuta) return;

        this.currentValuta = currency;
        this.table.getItems().clear();
        this.table.getItems().addAll(service.getBrewers(currency));
    }


    private void createTableView() {
        TableColumn<Brewer, Integer> idCol = new TableColumn<>("id");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().add(idCol);
        TableColumn<Brewer, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameCol);
        TableColumn<Brewer, String> addressCol = new TableColumn<>("Address");
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        table.getColumns().add(addressCol);
        TableColumn<Brewer, Integer> zipcodeCol = new TableColumn<>("Zipcode");
        zipcodeCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        table.getColumns().add(zipcodeCol);
        TableColumn<Brewer, String> cityCol = new TableColumn<>("City");
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        table.getColumns().add(cityCol);
        TableColumn<Brewer, Integer> turnoverCol = new TableColumn<>("Turnover");
        turnoverCol.setCellValueFactory(new PropertyValueFactory<>("turnover"));
        table.getColumns().add(turnoverCol);

        table.setMinWidth(550);
    }

}
