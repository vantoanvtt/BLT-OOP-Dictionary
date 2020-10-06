package controllers;

import com.jfoenix.controls.JFXTextArea;
import dictionary.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DisplayWordController implements Initializable {
    private Word resultWord;

    @FXML
    private Label word_target, word_spelling;
    @FXML
    private JFXTextArea word_explain;

    @FXML
    private Button btn_nav_back;

    public void initData(Word selectedWord) {
        resultWord = selectedWord;
        System.out.println("spellingggggggg" + resultWord.getWord_spelling());

        word_target.setText(resultWord.getWord_target());
        word_spelling.setText(resultWord.getWord_spelling());
        word_explain.setText(resultWord.getWord_explain());
    }

    @FXML
    private void handleBackButtonAction (ActionEvent event) throws IOException {
        Stage stage = null;
        Parent myNewScene = null;

        if (event.getSource() == btn_nav_back){
            stage = (Stage) btn_nav_back.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("/screens/SearchScreen.fxml"));
        }

        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("Search Screen");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }
}
