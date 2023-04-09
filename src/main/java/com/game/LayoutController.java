package com.game;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class LayoutController {
    
    //WARNING: CHANGE PATHS TO APPROPIATE IMAGES
    static String O =  LayoutController.class.getResource("images/o.png").toString();
                  X =  LayoutController.class.getResource("images/x.png").toString(); 
    @FXML private Text theOnlyTextField;


    @FXML
    private void press(Event event) throws IOException {
        ImageView button = (ImageView)event.getSource();
        if(button.getImage() == null){
            
            button.setImage(new Image(App.player=='O'?O:X));
            App.assignLetter(button.getId());
            App.tictactoe();
            
            //declaration of win, lose or draw
            if(App.win == true)
            theOnlyTextField.setText(App.str);
        }
    }

    @FXML
    private void closeProgram(){
        System.exit(0);
    }
}
