package com.silvercoffee.ecs.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.silvercoffee.ecs.components.AngleRotation;
import com.silvercoffee.ecs.components.Damage;
import com.silvercoffee.ecs.components.Position;
import com.silvercoffee.ecs.components.Velocity;
import com.silvercoffee.gamestates.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class MovementSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> pm;

    @Mapper
    ComponentMapper<Velocity> vm;

    @Mapper
    ComponentMapper<AngleRotation> ar;

    @Mapper
    ComponentMapper<Damage> dm;

    @SuppressWarnings("unchecked")
    public MovementSystem() {
        super(Aspect.getAspectForAll(Position.class, Velocity.class));
    }

    protected void process(Entity e) {
        Position position = pm.get(e);
        Velocity velocity = vm.get(e);

        //Alterar para considerar o Delta
        position.setX(position.getX() + velocity.getX());
        position.setY(position.getY() + velocity.getY());

        if (position.getX() < 0 || position.getY() < 0 || position.getX() > Game.MAP_WIDTH || position.getY() > Game.gc.getHeight()) {
            e.deleteFromWorld();
        }
    }

}
