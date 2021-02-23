package be.infernalwhale.view;

import be.infernalwhale.service.ConnectionManager;
import be.infernalwhale.service.ServiceFactory;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.SQLException;

/**
 * Do not change ANYTHING in this class
 */
public class ConnectionView extends GridPane {
    private ConnectionManager connectionManager = ServiceFactory.createConnectionManager();

    // View components
    private final TextField urlField = new TextField();
    private final TextField usernameField = new TextField();
    private final TextField passwordField = new TextField();

    private final Button connectButton = new Button("Open connection");
    private final Button closeButton = new Button("Close connection");
    private final Circle status = new Circle(8);
    private final Label errorOutput = new Label();

    public ConnectionView() {
        this.setPadding(new Insets(10, 10, 10 , 10));

        Label catLabel = new Label("Connection View");
        catLabel.setFont(Font.font(
                catLabel.getFont().getName(),
                FontWeight.BOLD,
                catLabel.getFont().getSize() + 4
        ));
        this.add(catLabel, 0, 0);

        this.add(new Label("URL: "), 0, 1);
        this.add(new Label("User:"), 0, 2);
        this.add(new Label("PWD: "), 0, 3);

        this.add(urlField, 1, 1);
        this.add(usernameField, 1, 2);
        this.add(passwordField, 1, 3);

        status.setStroke(Color.GRAY);
        status.setStrokeWidth(2);
        status.setFill(Color.RED);

        connectButton.setOnAction(this::openConnection);
        closeButton.setOnAction(this::closeConnection);

        FlowPane buttonGroup = new FlowPane(connectButton, closeButton, status);
        buttonGroup.setPadding(new Insets(5, 0, 0, 0));
        buttonGroup.setHgap(4);
        this.add(buttonGroup, 0, 4, 2, 1);
        this.add(errorOutput, 0, 5, 2, 1);
    }

    private void openConnection(ActionEvent event) {
        try {
            errorOutput.setText("");
            connectionManager.createConnection(urlField.getText(), usernameField.getText(), passwordField.getText());
            status.setFill(Color.GREEN);
        } catch (SQLException exception) {
            exception.printStackTrace();
            errorOutput.setText("You received an SQL exception.. Check the console for more information");
        } catch (NullPointerException e) {
            errorOutput.setText("You got a NullPointer.. check the console for more information");
            e.printStackTrace();
        }
    }

    private void closeConnection(ActionEvent event) {
        try {
            errorOutput.setText("");
            connectionManager.closeConnection();
            status.setFill(Color.RED);
        } catch (SQLException exception) {
            exception.printStackTrace();
            errorOutput.setText("You received an SQL exception.. Check the console for more information");
        } catch (NullPointerException e) {
            errorOutput.setText("You got a NullPointer.. check the console for more information");
            e.printStackTrace();
        }

    }
}
