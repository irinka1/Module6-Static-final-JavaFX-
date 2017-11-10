/*Create a window application in JavaFX
It is necessary to draw a snowman based on the user's wishes. The snowman consists of circles.
Each subsequent circle is above the previous one, touching it (!).
 If the circle is pushed to another circle, or there is a space between them, then the snowman is not correctly drawn. Radii of circles are randomized.
Circle colors should be randomized.
On the head of a snowman (the upper circle) from the circles should be drawn a nose and 2 eyes (less than the head).
Circles on the body should be randomized. There is no sequence to decrease or increase.
Data is entered via the console:
number of circles
min. radius of a circle
Max. radius of a circle

*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.Random;
import java.util.Scanner;


public class Snowman_ extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        Pane root = new Pane();

        System.out.printf("Enter the number of circles \n");
        Scanner sc = new Scanner(System.in);
        int countCircle = sc.nextInt();

        root.getChildren().addAll(generateCircles(countCircle));

        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        Pane root1 = new Pane();

        // construction of the first line
        Star line = new Star(new Point(50, 150), new Point(250, 100));

        line.show(root1).setStrokeWidth(10);

        // rendering the application window
        primaryStage.setScene(new Scene(root1));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }


    private Circle[] generateCircles(int count) {
        Random random = new Random();

        System.out.printf("Enter the maximum radius \n");
        Scanner sc2 = new Scanner(System.in);
        int maxRadius = sc2.nextInt();


        System.out.printf("Enter the minimum radius \n");
            Scanner sc1 = new Scanner(System.in);
            int minRadius = sc1.nextInt();

        Circle[] circles = new Circle[count];

        double y1 = 20;

        for (int i = 0; i < circles.length; i++) {
            Color color = Color.color(random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble());


            double radius = minRadius+Math.random()*maxRadius;
            double y = radius + y1;
            y1 = y + radius;



            circles[i] = new Circle(
                    200, y, radius, Paint.valueOf(color.toString()));

            if(i==circles.length-1){
                circles[i] = new Circle(200-(circles[0].getRadius())/2,
                        circles[0].getCenterY()-(circles[0].getRadius())/2,
                        (circles[0].getRadius()*Math.random())/4, Paint.valueOf(color.toString()));
            }

            if(i==circles.length-2){
                circles[i] = new Circle(200+(circles[0].getRadius()*Math.random())/2,
                        circles[0].getCenterY()-(circles[0].getRadius())/2,
                        (circles[0].getRadius()*Math.random())/4, Paint.valueOf(color.toString()));
            }

            if(i==circles.length-3){
                circles[i] = new Circle(200,
                        circles[0].getCenterY()+circles[0].getRadius()*Math.random(),
                        (circles[0].getRadius()*Math.random())/4, Paint.valueOf(color.toString()));
            }

        }
        return circles;
    }
}
