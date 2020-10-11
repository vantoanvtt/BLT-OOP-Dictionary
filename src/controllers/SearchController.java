package controllers;

import actions.HistoryAction;
import dictionary.DictionaryManagement;
import dictionary.Word;
import helper.HandleDataFileV_A;
import helper.HandleDataFromFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class SearchController implements Initializable {
    @FXML
    private Button btn_nav_back, btn_search, btn_history;
    @FXML
    private TextField textField;

    @FXML
    private ComboBox<String> language;

    HandleDataFileV_A v = new HandleDataFileV_A();
    HandleDataFromFile data = new HandleDataFromFile();

    ObservableList cb = FXCollections.observableArrayList("EN", "VI");

    HashMap<String, Word> WordList = new HashMap<>();
    ObservableList<String> autoList = FXCollections.observableArrayList();

    HistoryAction history = new HistoryAction();

    @FXML
    private void handleBackButtonAction (ActionEvent event) throws IOException {
        Stage stage = null;
        Parent myNewScene = null;

        if (event.getSource() == btn_nav_back){
            stage = (Stage) btn_nav_back.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("/screens/Home.fxml"));
        } else if(event.getSource() == btn_search) {
            stage = (Stage) btn_search.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/screens/DisplayWordInfomation.fxml"));
            myNewScene = loader.load();

            DisplayWordController controller = loader.getController();
            DictionaryManagement db = new DictionaryManagement(WordList);

            controller.initData(db.getWordSearch(textField.getText()));
            history.insertHistory(textField.getText());

        } else if (event.getSource() == btn_history) {
            stage = (Stage) btn_search.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/screens/HistoryScreen.fxml"));
            myNewScene = loader.load();
        }

        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("Search Screen");
        stage.show();
    }

    @FXML
    public void HandleCombobox(ActionEvent event) throws FileNotFoundException {
        String lg = language.getValue();
        System.out.println(lg);
        if (lg == "VI") {
            System.out.println("entered");
            autoList.addAll(v.getVNList());
            WordList = v.getWordList();
        } else {
            autoList.addAll(data.getListWordTarget());
            //autoList = data.getListWordTarget();
            WordList = data.getWordList();
        }
        TextFields.bindAutoCompletion(textField, autoList);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TextFields.bindAutoCompletion(textField, autoList);
       language.setItems(cb);
    }
}
