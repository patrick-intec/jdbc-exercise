package be.infernalwhale.view;

import be.infernalwhale.model.Category;
import be.infernalwhale.service.CategoryService;
import be.infernalwhale.service.ServiceFactory;
import be.infernalwhale.service.exception.ValidationException;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Do not change ANYTHING in this class
 */
public class CategoryView extends GridPane {
    private final CategoryService service = ServiceFactory.createCategoryService();

    // View elements
    private final TableView<Category> table = new TableView<>();
    private final TextField categoryID = new TextField();
    private final TextField categoryName = new TextField();
    private final Label errorText = new Label();

    public CategoryView() {
        this.setPadding(new Insets(10, 10, 10 , 10));
        this.setHgap(5);
        this.setVgap(4);

        Label catLabel = new Label("Category View");
        catLabel.setFont(Font.font(
                catLabel.getFont().getName(),
                FontWeight.BOLD,
                catLabel.getFont().getSize() + 4
        ));


        TableColumn<Category, Integer> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Category, String> col2 = new TableColumn<>("Category");
        col2.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

        table.getColumns().add(col1);
        table.getColumns().add(col2);
        table.getSelectionModel().selectedItemProperty().addListener(this::itemSelected);

        this.add(catLabel, 0, 0);
        this.add(table, 0, 1);

        Button readCats = new Button("Read Cats ^o^");
        readCats.setOnAction(event -> readCategoriesFromDB());
        this.add(readCats, 0, 2);

        GridPane form = new GridPane();
        form.add(new Label("ID: "), 0, 0);
        form.add(new Label("Name: "), 0, 1);
        form.add(categoryID, 1, 0);
        form.add(categoryName, 1, 1);

        Button createButton = new Button("Create New");
        Button saveButton = new Button("Save");
        Button deleteButton = new Button("Delete");

        createButton.setOnAction(this::createCategory);
        saveButton.setOnAction(this::saveCategory);
        deleteButton.setOnAction(this::deleteCategory);

        FlowPane buttonGroup = new FlowPane(createButton, saveButton, deleteButton);
        buttonGroup.setHgap(5);
        form.add(buttonGroup, 0, 2, 2, 1);
        form.add(errorText, 0, 3, 2, 1);

        this.add(form, 1, 1);
    }

    private void readCategoriesFromDB() {
        table.getItems().addAll(service.getCategories());
    }

    private void itemSelected(ObservableValue<? extends Category> observableValue, Category previousSelection, Category newSelection) {
        this.categoryID.setText(newSelection.getId().toString());
        this.categoryName.setText(newSelection.getCategoryName());
    }

    private void createCategory(ActionEvent event) {
        Category newCat = null;
        try {
            newCat = service.createCategory(new Category(null, this.categoryName.getText()));
            this.table.getItems().add(newCat);
        } catch (ValidationException e) {
            errorText.setText(e.getMessage());
        }
    }

    private void saveCategory(ActionEvent event) {
        System.out.println("Save button pressed");
        Category saved = service.updateCategory(new Category(Integer.parseInt(this.categoryID.getText()), this.categoryName.getText()));
        this.table.getItems().stream()
                .filter(category -> category.getId().equals(Integer.parseInt(this.categoryID.getText())))
                .findFirst()
                .ifPresentOrElse(
                        category -> {
                            category.setId(saved.getId());
                            category.setCategoryName(saved.getCategoryName());
                        },
                        () -> errorText.setText("Could not save category. Record not found in db.")
                );
        this.table.refresh();

    }

    private void deleteCategory(ActionEvent event) {
        boolean deleted = service.deleteCategory(new Category(
                Integer.parseInt(this.categoryID.getText()),
                this.categoryName.getText()
        ));

        if (deleted) {
            this.table.getItems().stream()
                    .filter(category -> category.getId().equals(Integer.parseInt(this.categoryID.getText())))
                    .findFirst()
                    .ifPresentOrElse(
                            category -> this.table.getItems().remove(category),
                            () -> errorText.setText("Selected category was not found in view")
                    );
        }
    }

}
