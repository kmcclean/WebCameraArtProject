import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


//This is an art project, designed to display a set of random black and white squares.
public class Main extends Application{
    //This sets up the visual aspect of the program.
    @Override
    public void start(Stage primaryStage) {

        //http://stackoverflow.com/questions/3680221/how-can-i-get-the-monitor-size-in-java
        //Gets the size of the screen, and uses the size of the screen to create the appropriate size for the squares
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        //Sets up the basics of the display.
        Group root = new Group();
        Scene scene = new Scene(root, screen.getWidth(), screen.getHeight(), javafx.scene.paint.Color.BLACK);

        //This sets up the square class with information that is used by the program.
        Squares square = new Squares(screen.getWidth(), screen.getHeight(), screen.getWidth() / 100, screen.getHeight() / 100);

        Webcam webcam = Webcam.getDefault();
        WebcamMotionDetector detector = new WebcamMotionDetector(webcam);


        //checks to make sure a webcam exists, stops the program if there is none.
        if (webcam == null) {
            System.out.println("No webcam detected.");
            System.exit(-1);
        }
        //this responds to the use of the motionso f the webcam.
        WebcamMotionListener wml = new WebcamMotionListener() {
            @Override
            public void motionDetected(WebcamMotionEvent webcamMotionEvent) {
                addSquareArray(root, square);
                showStage(primaryStage, scene);
            }
        };
        //sets up the detector for use by the program.
        detector.setInterval(100);
        detector.addMotionListener(wml);
        detector.start();
        addSquareArray(root, square);
        showStage(primaryStage, scene);

    }

    public void addSquareArray(Group root, Squares square) {
        //This creates the rectangles that will be used by the display. and places them in the group.
        ArrayList<javafx.scene.shape.Rectangle> rectangleArrayList = square.createRectangleArray();
        for (javafx.scene.shape.Rectangle rectangle : rectangleArrayList) {
            root.getChildren().add(rectangle);
        }
    }

    public void setUpWebCam(Webcam webcam, WebcamMotionDetector detector, Group root, Squares square, Stage primaryStage, Scene scene) {

        //checks to make sure a webcam exists, stops the program if there is none.
        if (webcam == null) {
            System.out.println("No webcam detected.");
            System.exit(-1);
        }
        //this responds to the use of the motionso f the webcam.
        WebcamMotionListener wml = new WebcamMotionListener() {
            @Override
            public void motionDetected(WebcamMotionEvent webcamMotionEvent) {
                addSquareArray(root, square);
            }
        };
        //sets up the detector for use by the program.
        detector = new WebcamMotionDetector(webcam);
        detector.setInterval(100);
        detector.addMotionListener(wml);
        detector.start();
    }




    public void showStage(Stage primaryStage, Scene scene){
        //activates and shows the rectangle display.
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);

    }
}
