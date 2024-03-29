package helper;

import controllers.DisplayWordController;
import dictionary.DictionaryManagement;
import dictionary.Word;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

import java.io.IOException;
import java.util.HashMap;

public class GotoDisplay {
    HandleDataFileV_A v = new HandleDataFileV_A();
    HandleDataFromFile data = new HandleDataFromFile();
    DictionaryManagement db = new DictionaryManagement(data.getWordList());

    //HashMap<String, Word> merge = db.addList(v.getWordList());

    public GotoDisplay(String word, MouseEvent event) {
        try {
            Stage stage = null;
            Parent myNewScene = null;

            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/screens/DisplayWordInfomation.fxml"));
            myNewScene = loader.load();

            DisplayWordController controller = loader.getController();
            db.addList(v.getWordList());
            controller.initData(db.getWordSearch(word));


            Scene scene = new Scene(myNewScene);
            //Stage stage = new Stage(scene);
            stage.setScene(scene);
            stage.setTitle("Display Word");
            stage.show();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
