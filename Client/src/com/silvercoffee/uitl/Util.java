package com.silvercoffee.uitl;


import org.newdawn.slick.geom.Point;

public class Util {

    public static double scalarProduct(Point u, Point v) {
        return u.getX() * v.getX() + u.getY() + v.getY();
    }


    public static double module(Point u) {
        return Math.sqrt(Math.pow(u.getX(), 2) + Math.pow(u.getY(), 2));
    }

    public static Point polToRec(double angle, double amplitude) {
        return new Point((float) (Math.cos(angle) * amplitude), (float) (Math.sin(angle) * amplitude)   );
    }

}
