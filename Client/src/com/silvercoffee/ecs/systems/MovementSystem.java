package com.silvercoffee.ecs.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.silvercoffee.ecs.components.Position;
import com.silvercoffee.ecs.components.Velocity;
import com.silvercoffee.gamestates.Game;

public class MovementSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> pm;

    @Mapper
    ComponentMapper<Velocity> vm;



    @SuppressWarnings("unchecked")
    public MovementSystem() {
        super(Aspect.getAspectForAll(Position.class, Velocity.class));
    }

    protected void process(Entity e) {
        Position position = pm.get(e);
        Velocity velocity = vm.get(e);

        //Alterar para considerar o Delta
        position.setX(position.getX()+((int)velocity.getX()));
        position.setY(position.getY()+((int)velocity.getY()));

        Game.gc.getGraphics().fillRect(position.getX()-5,position.getY()-5,position.getX()+5,position.getY()+5);
    }

}
