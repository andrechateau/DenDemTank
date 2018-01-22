package com.silvercoffee.ecs.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.silvercoffee.ecs.components.Damage;
import com.silvercoffee.ecs.components.Position;
import com.silvercoffee.ecs.components.Velocity;
import com.silvercoffee.gamestates.Game;
import org.newdawn.slick.Color;

public class MovementSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> pm;

    @Mapper
    ComponentMapper<Velocity> vm;

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
        position.setX(position.getX() + ((int) velocity.getX()));
        position.setY(position.getY() + ((int) velocity.getY()));

        Damage damage = dm.get(e);
        if(damage==null){
            Game.gc.getGraphics().setColor(Color.gray);
            Game.gc.getGraphics().fillRect(position.getX() - 10, position.getY() - 10, 20, 20);
        }else{
            Game.gc.getGraphics().setColor(Color.red);
            Game.gc.getGraphics().fillOval(position.getX() - 5,position.getY() - 5,10,10);
        }

        if (position.getX() < 0 || position.getY() < 0 || position.getX() > Game.MAP_WIDTH || position.getY() > Game.gc.getHeight()) {
            e.deleteFromWorld();
        }
    }

}
