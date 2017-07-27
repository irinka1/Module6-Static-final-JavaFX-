/*Задание 1
Создать оконное приложение на JavaFX
Необходимо нарисовать снеговика исходя из пожеланий пользователя. Снеговик состоит из кругов.
Каждый последующий круг находиться над предыдущим, касаясь его(!).
 Если круг будет налазить на другой круг, либо между ними будет пробел - значит снеговик отрисован не верно. Радиусы кругов рандомизированы.
Цвета кругов должны быть рандомизированы.
На голове снеговика(верхний круг) из кругов должен быть отрисован нос и 2 глаза (меньше головы).
Круги на теле должны быть рандомизированы. Нет последовательности на уменьшение или увеличение.
*/


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

import static javafx.application.Application.launch;

public class модуль6дз {


    public class Program extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setWidth(400);
            primaryStage.setHeight(400);

            Pane root = new Pane();

           root.getChildren().addAll(generateCircles(5));



           Scene scene = new Scene(root);
           primaryStage.setScene(scene);

            primaryStage.show();
        }}

        public static void main(String[] args) {

        launch(args);
        }

        //

       private Circle[] generateCircles(int count) {
            Random random = new Random();

            Circle[] circles = new Circle[count];
            for(int i = 0; i < circles.length; i++) {
                Color color = Color.color(random.nextDouble(),
                        random.nextDouble(),
                        random.nextDouble(),
                        0.6f);

                circles[i] = new Circle(
                        random.nextInt(400),
                        random.nextInt(400),
                        random.nextInt(80),
                        Paint.valueOf(color.toString()));
                // 0 1 2 3 4 5 6 7 8 9 a b c d e f
            }
            return circles;
        }


    }

