package com.game;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class LayoutController {
    
    //following lines get the apt resources to for image O and image X
    static String O =  LayoutController.class.getResource("images/o.png").toString(),
                  X =  LayoutController.class.getResource("images/x.png").toString(); 
    @FXML private Text theOnlyTextField;

    @FXML
    private void press(Event event) throws IOException {
        //this function is used to determine and understand which button was pressed, gives an output of the entire of object of the button.
        //by this, we can understand the status of the button, the icon of the button and most importantly the id of the button.
        ImageView button = (ImageView)event.getSource();

        //on initialization, the image of the buttons is none, hence null. when the player selects a null grid, only then can the program bring up apt functions
        //this prevents already taken positions from being replaced by other icons
        if(button.getImage() == null){
            //sets image of player icon when selectd.
            button.setImage(new Image(App.player=='O'?O:X));
            App.assignLetter(button.getId());
            App.tictactoe();
            
            //declaration of win, lose or draw
            if(App.win == true)
            theOnlyTextField.setText(App.str);
        }
    }

    //small script for text, when pressed, the entire program will stop and exit. however you can use the close button too.
    @FXML
    void closeProgram(){
        System.exit(0);
    }
}
