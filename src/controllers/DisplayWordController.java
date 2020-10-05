package controllers;

import dictionary.Word;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ResourceBundle;

public class DisplayWordController implements Initializable {
    private Word resultWord;

    @FXML
    private Label word_target, word_spelling, word_explain;

    public void initData(Word selectedWord) {
        resultWord = selectedWord;
        System.out.println("spellingggggggg" + resultWord.getWord_spelling());

        word_target.setText(resultWord.getWord_target());
        word_spelling.setText(resultWord.getWord_spelling());
        word_explain.setText(resultWord.getWord_explain());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }
}
