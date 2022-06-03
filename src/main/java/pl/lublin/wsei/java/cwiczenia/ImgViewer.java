package pl.lublin.wsei.java.cwiczenia;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ImgViewer {
    public ImageView imgView;
    public Infografika selInfografika;

    public void btnPokazOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("imgViewer.fxml"));
            Parent root = loader.load();
            ImgViewer viewer = loader.getController();
            if(selInfografika != null){
                Image img = new Image(selInfografika.adresGrafiki);
                viewer.imgView.setFitWidth(img.getWidth());
                viewer.imgView.setFitHeight(img.getHeight());
                viewer.imgView.setImage(img);
            }

            Stage stage = new Stage();
            stage.setTitle("Poglad infografiki");
            stage.setScene(new Scene(root, 900, 800));
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
