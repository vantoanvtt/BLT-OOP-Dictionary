package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListCellController extends ListCell<String> implements Initializable {
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private GridPane gridPane;

    @Override
    protected void updateItem(String word, boolean empty) {
        super.updateItem(word, empty);
        Parent Hbox = null;
        if(empty || word == null) {

            setText(null);
            setGraphic(null);

        } else {
            FXMLLoader mLLoader = new FXMLLoader(getClass().getResource("/components/ListCell.fxml"));
            mLLoader.setController(this);

            try {
                Hbox = mLLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            label.setText(word);

            setText(null);
            setGraphic(Hbox);
        }

    }

    public void setLabel(String s) {
        this.label.setText(s);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }
}
