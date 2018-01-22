package com.silvercoffee.ecs.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.silvercoffee.ecs.components.*;
import com.silvercoffee.ecs.entities.ShotFactory;
import com.silvercoffee.ecs.entities.TankFactory;
import com.silvercoffee.gamestates.Game;
import com.silvercoffee.uitl.Util;
import org.newdawn.slick.Color;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Point;

public class ControllSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<AngleRotation> ag;

    @Mapper
    ComponentMapper<Cannon> cn;

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
        if (Game.gc.getInput().isKeyDown(Input.KEY_RIGHT) || Game.gc.getInput().isKeyDown(Input.KEY_D)) {
            angle.setAngle(angle.getAngle() + 2);
//            Point p = Util.polToRec(angle.getAngle(), 2);
//            Velocity velocity = vl.get(entity);
//            velocity.setX(p.getX());
//            velocity.setY(p.getY());
            Velocity velocity = vl.get(entity);
            velocity.setX(0);
            velocity.setY(0);
        }
        if (Game.gc.getInput().isKeyDown(Input.KEY_LEFT) || Game.gc.getInput().isKeyDown(Input.KEY_A)) {
            angle.setAngle(angle.getAngle() - 2);
//            Point p = Util.polToRec(angle.getAngle(), 2);
//            Velocity velocity = vl.get(entity);
//            velocity.setX(p.getX());
//            velocity.setY(p.getY());
            Velocity velocity = vl.get(entity);
            velocity.setX(0);
            velocity.setY(0);
        }
        if (Game.gc.getInput().isKeyDown(Input.KEY_UP) || Game.gc.getInput().isKeyDown(Input.KEY_W)) {
            Point p = Util.polToRec(angle.getAngle(), 1.5f);
            Velocity velocity = vl.get(entity);
            velocity.setX(p.getX());
            velocity.setY(p.getY());
        } else {
            Velocity velocity = vl.get(entity);
            velocity.setX(0);
            velocity.setY(0);
        }
        //if(Game.gc.getInput().isMouseButtonDown(0)){
        if (Game.gc.getInput().isKeyDown(Input.KEY_SPACE)) {
            Cannon cannon = cn.get(entity);
            if (cannon != null) {
                if (cannon.getLastShot() + Cannon.COOLDOWN <= System.currentTimeMillis()) {
                    Entity e = Game.world.createEntity();
                    Point ponto = Util.polToRec(cannon.getAngle(), 10);
                    Point posi = Util.polToRec(cannon.getAngle(), 30);

                    Game.world.addEntity(ShotFactory.createShot(Game.world, position.getX() - posi.getX(), position.getY() - posi.getY(), ponto.getX() * (-1), ponto.getY() * (-1)));
                    cannon.setLastShot(System.currentTimeMillis());
                }
            }
        }
    }
}
