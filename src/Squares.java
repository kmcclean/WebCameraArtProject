import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Squares {

    double width;
    double height;
    double squareWidth;
    double squareHeight;

    public Squares(double newWidth, double newHeight, double newSquareWidth, double newSquareHeight){
        this.width = newWidth;
        this.height = newHeight;
        this.squareWidth = newSquareWidth;
        this.squareHeight = newSquareHeight;

    }

    public ArrayList<Rectangle> createRectangleArray() {

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
