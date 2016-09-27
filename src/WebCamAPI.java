import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class WebCamAPI {
    Webcam webcam;
    WebcamMotionDetector detector;

    //sets up the webcam for use in the program.
    public WebCamAPI(Group root, Squares square, Stage primaryStage, Scene scene) {
        webcam = Webcam.getDefault();

        //this responds to the use of the motionso f the webcam.
        WebcamMotionListener wml = new WebcamMotionListener() {
            @Override
            public void motionDetected(WebcamMotionEvent webcamMotionEvent) {

            }
        };
        //sets up the detector for use by the program.
        detector =new WebcamMotionDetector(webcam);
        detector.setInterval(100);
        detector.addMotionListener(wml);
        detector.start();
    }


    //This checks to make sure a webcam is connected. Stops the program if it is not.
    public void checkWebCamExists() {
        if (webcam == null){
            System.out.println("No webcam detected.");
            System.exit(-1);
        }
    }
}
