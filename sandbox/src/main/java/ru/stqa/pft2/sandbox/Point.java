package ru.stqa.pft2.sandbox;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;

    }
    public double distance(Point second) {
        return Math.sqrt(Math.pow((this.x - this.x),2) + Math.pow((this.y - this.y),2));
            }

     }



