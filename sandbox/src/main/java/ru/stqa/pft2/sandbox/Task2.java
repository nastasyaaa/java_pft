package ru.stqa.pft2.sandbox;

import ru.stqa.pft2.sandbox.Point;

public class Task2 {

    public static void main(String[] args) {
        Point first = new Point(5, 2);
        Point second = new Point(9, 2);
        System.out.println("Расстояние между двумя точками а(x1,y1) и b(x2,y2) c координатами x1:" + first.x + " y1:" + first.y + " и x2:" + second.x + " y1:" + second.y + " = " + first.distance(second));
    }



}

