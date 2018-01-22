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
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Point;

public class ControllSystem extends EntityProcessingSystem {
    @Mapper
    ComponentMapper<AngleRotation> ag;

    @Mapper
    ComponentMapper<Position> ps;

    @Mapper
    ComponentMapper<Velocity> vl;

    public ControllSystem() {
        super(Aspect.getAspectForAll(Position.class, PlayerControlled.class, Velocity.class, AngleRotation.class));
    }

    @Override
    protected void process(Entity entity) {
        AngleRotation angle = ag.get(entity);

        Position position = ps.get(entity);
        if (Game.gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
            angle.setAngle(angle.getAngle() + 1);
            Point p = Util.polToRec(angle.getAngle(), 2);
            Velocity velocity = vl.get(entity);
            velocity.setX(p.getX());
            velocity.setY(p.getY()*(-1));
        }
        if (Game.gc.getInput().isKeyDown(Input.KEY_LEFT)) {
            angle.setAngle(angle.getAngle() - 1);
            Point p = Util.polToRec(angle.getAngle(), 2);
            Velocity velocity = vl.get(entity);
            velocity.setX(p.getX());
            velocity.setY(p.getY()*(-1));
        }
        if (Game.gc.getInput().isKeyDown(Input.KEY_UP)) {
            Point p = Util.polToRec(angle.getAngle(), 2);
            Velocity velocity = vl.get(entity);
            velocity.setX(p.getX());
            velocity.setY(p.getY()*(-1));
        }
        if (Game.gc.getInput().isKeyDown(Input.KEY_DOWN)) {

            Velocity velocity = vl.get(entity);
            velocity.setX(0);
            velocity.setY(0);
        }
        Game.gc.getGraphics().setColor(Color.red);
        //Game.gc.getGraphics().drawLine();

        Position pos = ps.get(entity);
        Game.gc.getGraphics().setColor(Color.red);
        Game.gc.getGraphics().drawString(angle.getAngle() + "", pos.getX()-15, pos.getY()-30);
    }
}
