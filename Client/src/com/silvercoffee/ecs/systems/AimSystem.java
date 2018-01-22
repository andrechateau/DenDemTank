package com.silvercoffee.ecs.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.silvercoffee.ecs.components.*;
import com.silvercoffee.gamestates.Game;
import com.silvercoffee.uitl.Util;
import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Point;


public class AimSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> position;

    @Mapper
    ComponentMapper<Cannon> cannon  ;


    @SuppressWarnings("unchecked")
    public AimSystem() {
        super(Aspect.getAspectForAll(Position.class, Cannon.class, PlayerControlled.class));
    }

    @Override
    protected void process(Entity entity) {
        int mouseX = Game.gc.getInput().getMouseX();
        int mouseY = Game.gc.getInput().getMouseY();


        Position pos = position.get(entity);
        Cannon can = cannon.get(entity);


        Point vetMouse = new Point(mouseX - pos.getX(), mouseY - pos.getY());
        Point vetRef = new Point(-100000, 0);


        double sinAngle = Util.scalarProduct(vetRef, vetMouse) / (Util.module(vetRef) * Util.module(vetMouse));

        double angle = Math.toDegrees(Math.acos(sinAngle));

        angle = (vetMouse.getY() < 0)? angle : 360 - angle;
        can.setAngle(angle);

    }
}
