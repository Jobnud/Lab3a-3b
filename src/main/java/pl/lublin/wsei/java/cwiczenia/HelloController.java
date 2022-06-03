package pl.lublin.wsei.java.cwiczenia;

import javafx.application.HostServices;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class HelloController {
    private Infografika selInfografika;
    private HostServices hostServices;
    private Stage stage;

    public TextField txtAdresStrony;
    public Label lbFile;
    public Button btnPokazInfografike;
    public Button btnZaladujStrone;
    public ImageView imgMiniaturka;

    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("Pliki XML (*.xml)", "*.xml");

    public ListView lstInfografiki;
    ObservableList<String> tytuly = FXCollections.observableArrayList();
    GusInfoGraphicList igList;

    @FXML
    public void initialize() {
        fileChooser.getExtensionFilters().add(xmlFilter);
        lstInfografiki.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number old_val, Number new_val) {
                        int index = new_val.intValue();
                        if(index != -1){
                            selInfografika = igList.Infografiki.get(index);
                            txtAdresStrony.setText(igList.Infografiki.get(index).adresStrony);
                            Image image = new Image(igList.Infografiki.get(index).adresMiniaturki);
                            imgMiniaturka.setImage(image);
                        } else {
                            txtAdresStrony.setText("");
                            imgMiniaturka.setImage(null);
                            selInfografika = null;
                        }
                    }
                }
        );
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setHostServices(HostServices hostServices){
        this.hostServices = hostServices;
    }

    public void btnOpenFileAction(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            igList = new GusInfoGraphicList(file.getAbsolutePath());
            lbFile.setText(file.getAbsolutePath());
            for(Infografika ig: igList.Infografiki) tytuly.add(ig.tytul);
            lstInfografiki.setItems(tytuly);
        } else {
            lbFile.setText("Proszę wczytać plik ...");
        }
    }

    public void setBtnZaladujStrone(ActionEvent actionEvent){
        if(selInfografika != null)
            hostServices.showDocument(selInfografika.adresStrony);
    }
}