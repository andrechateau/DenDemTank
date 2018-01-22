package com.silvercoffee.ecs.components;

import com.artemis.Component;

public class Cannon extends Component {
    public static final int COOLDOWN = 1;
    private double angle;
    private long lastShot;

    public long getLastShot() {
        return lastShot;
    }

    public void setLastShot(long lastShot) {
        this.lastShot = lastShot;
    }

    public Cannon() {
        lastShot = System.currentTimeMillis()-COOLDOWN;
    }

    public Cannon(double angle) {
        this.angle = angle%360;
        lastShot = System.currentTimeMillis()-COOLDOWN;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle%360;
    }
}
