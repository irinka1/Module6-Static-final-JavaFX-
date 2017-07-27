/*Задание 1
Создать оконное приложение на JavaFX
Необходимо нарисовать снеговика исходя из пожеланий пользователя. Снеговик состоит из кругов.
Каждый последующий круг находиться над предыдущим, касаясь его(!).
 Если круг будет налазить на другой круг, либо между ними будет пробел - значит снеговик отрисован не верно. Радиусы кругов рандомизированы.
Цвета кругов должны быть рандомизированы.
На голове снеговика(верхний круг) из кругов должен быть отрисован нос и 2 глаза (меньше головы).
Круги на теле должны быть рандомизированы. Нет последовательности на уменьшение или увеличение.
Данные вводятся через консоль:
кол-во кругов
мин. радиус круга
макс. радиус круга

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

import static javafx.application.Application.launch;

public class модуль6дз extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        Pane root = new Pane();

        System.out.printf("Введите количество кругов \n");
        Scanner sc = new Scanner(System.in);
        int countCircle = sc.nextInt();

        root.getChildren().addAll(generateCircles(countCircle));

       /* System.out.printf("Введите мин. радиус круга \n");
        Scanner sc1 = new Scanner(System.in);
        int minRadius = sc1.nextInt();


        System.out.printf("Введите макс. радиус круга \n");
        Scanner sc2 = new Scanner(System.in);
        int maxRadius = sc2.nextInt();*/


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

    //

    private Circle[] generateCircles(int count) {
        Random random = new Random();

        Circle[] circles = new Circle[count];
        for (int i = 0; i < circles.length; i++) {
            Color color = Color.color(random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble());

                /*int y;
                int radius;
                for(i=0; i<circles.length; i++)
                    radius[i] = new*/


            for (int j = 0; j < circles.length; j++) {
                circles[j] = new Circle(
                        200,
                        10 * j,
                        Math.random()* j,
                        Paint.valueOf(color.toString()));

            }}
            return circles;
        }


    }
