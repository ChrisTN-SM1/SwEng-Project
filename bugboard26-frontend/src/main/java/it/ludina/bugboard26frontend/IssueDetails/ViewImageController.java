package it.ludina.bugboard26frontend.IssueDetails;

import it.ludina.bugboard26frontend.HTTPRequestManager;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

@Getter
@Setter
public class ViewImageController {
    @FXML
    private ImageView imageView;
    @FXML
    private AnchorPane anchorPane;
    private int idIssue;


    public void getImage() {
        File file = new File("src/main/resources/images/Diana.jpeg");
        try {
            String encodedImage = HTTPRequestManager.getIssueImage(idIssue);
            byte[] decodedImage = Base64.getDecoder().decode(encodedImage);
            if (decodedImage.length > 0) {
                file = File.createTempFile("trmp-", "-file");
                FileUtils.writeByteArrayToFile(file, decodedImage);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Image image;

        image = new Image(file.toURI().toString(), 500, 500, true, true);
        imageView.setImage(image);

        anchorPane.getScene().getWindow().sizeToScene();
    }
}
