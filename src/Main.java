import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


//This is an art project, designed to display a set of random black and white squares.
public class Main extends Application{



    //This sets up the visual aspect of the program.
    @Override
    public void start(Stage primaryStage){

        //http://stackoverflow.com/questions/3680221/how-can-i-get-the-monitor-size-in-java
        //Gets the size of the screen, and uses the size of the screen to create the appropriate size for the squares
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screen.getWidth();
        double height = screen.getHeight();
        double squareWidth = width/100;
        double squareHeight = height/100;


        //Sets up the basics of the display.
        Group root = new Group();
        Scene scene = new Scene(root, width, height, Color.BLACK);

        //This creates the rectangles that will be used by the display. and places them in the group.
        ArrayList<Rectangle> rectangleArrayList = createRectangleArray(width, height, squareWidth, squareHeight);
        for (Rectangle rectangle: rectangleArrayList){
            root.getChildren().add(rectangle);
        }

        //activates and shows the rectangle display.
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


    public ArrayList<Rectangle> createRectangleArray(double width, double height, double squareWidth, double squareHeight) {


        //These are the basic variables that the square creation needs in order to function.
        ArrayList<Rectangle> rectangleArrayList = new ArrayList<Rectangle>();
        double widthLocation = 0;
        double heightLocation = 0;
        Color color;
        Random r = new Random();

        //this creates new squares until the conditions are satisfied.
        while (true) {

            //randomizes the color.
            int i = r.nextInt(2);
            if (i % 2 == 0){
                color = Color.BLACK;
            }
            else{
                color = Color.WHITE;
            }

            //creates the squares.
            Rectangle rectangle = new Rectangle(widthLocation, heightLocation, squareWidth, squareHeight);
            rectangle.setFill(color);
            rectangleArrayList.add(rectangle);


            //checkes to see if end condition is met. If not, continues creating new squares.
            if (widthLocation > width && heightLocation > height){
                break;
            }
            else if (widthLocation > width){
                widthLocation = 0;
                heightLocation += squareHeight;
            }
            else{
                widthLocation += squareWidth;
            }
        }

        return rectangleArrayList;
    }
}
