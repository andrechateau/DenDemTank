package com.silvercoffee.ecs.components;

import com.artemis.Component;

public class AngleRotation extends Component {

    private float angle;

    public AngleRotation() {
    }

    public AngleRotation(float angle) {
        this.angle = angle%360;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle%360;
    }
}
