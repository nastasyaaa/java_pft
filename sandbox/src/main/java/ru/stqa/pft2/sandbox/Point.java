package ru.stqa.pft2.sandbox;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;

    }
    public double distance(Point second) {
        return Math.sqrt(Math.pow((this.x - second.x),2) + Math.pow((this.y - second.y),2));
            }

     }



