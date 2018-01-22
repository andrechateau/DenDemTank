package com.silvercoffee.ecs.components;

import com.artemis.Component;

public class Cannon extends Component {

    private double angle;

    public Cannon() {
    }

    public Cannon(double angle) {
        this.angle = angle%360;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle%360;
    }
}
