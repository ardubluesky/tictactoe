package com.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
            
import java.io.IOException;

/**
* JavaFX App
*/
public class App extends Application {
    
    private static Scene scene;
    //class variables
    public static boolean win = false;
    static int count = 0;
    static char arr[][] = new char[3][3];
    static char player = 'O';
    static String str = null;
    
    //loading up the window
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        scene = new Scene(root, 600, 650);
        //adding the icon here
        stage.getIcons().add(new Image(getClass().getResource("images/icon.png").toString()));
        //self explainatory
        stage.setTitle("Tictactoe");
        stage.setScene(scene);
        stage.show();
    }
    
    //function used to assign player character to the array grid
    static void assignLetter(String id){
        int choice = (id.charAt(2)-49); //takes the 3rd character of id, and corresponds it with array
        arr[choice/3][choice%3] = player;
    }
    
    static boolean checkGrid(){
        //used for checking the grid with current players to see for chances of win, or draw
        for(int i = 0; i < 3; i++){
            if(arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2] && arr[i][2] == player)
            return true;
            else if(arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i] && arr[2][i] == player)
            return true;
        }
        if(arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[2][2] == player)
            return true;
        else if(arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2] && arr[0][2] == player)
            return true;
        return false;
    }
    
    static void displayGrid(){
        //use this when having difficulties by placing them in appropiate functions to understand the array grid
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++)
            System.out.print(arr[i][j]+((j == 2)?"\n":"|"));
            System.out.println(i==2?"":"------");
        }
    }
    
    static void tictactoe(){
        //displayGrid();
        if(win == true)
            return;
        //above function is stop more checking of the grid, and call it a day
        else if(checkGrid()){
            win = true;
            str = "player "+player+" won! press the text to close.";  
            return; 
        }
        //if a player wins, then the text will be show above and hopefully break
        else if(count == 8){
            win = true;    
            str = "its a draw! press this text to close the program.";
        }
        //and if the program ends in a draw, well, get better
        App.player = (App.player=='O')?'X':(App.player=='X'?'O':App.player);
        count++; 
        //if the program continues, switch the player and allow him to pick a position
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}