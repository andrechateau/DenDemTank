package com.silvercoffee.uitl;


import org.newdawn.slick.geom.Point;

public class Util {

    public static double scalarProduct(Point u, Point v) {
        return u.getX()*v.getX()+u.getY()+v.getY();
    }


    public static double module(Point u){
        return  Math.sqrt(Math.pow(u.getX(),2)+Math.pow(u.getY(),2));
    }

}
