package com.silvercoffee.ecs.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.silvercoffee.ecs.components.Damage;
import com.silvercoffee.ecs.components.Health;
import com.silvercoffee.ecs.components.Position;
import com.silvercoffee.ecs.components.Velocity;
import com.silvercoffee.gamestates.Game;
import javafx.geometry.Pos;

import java.util.Map;
import java.util.Random;

public class DeathSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Health> ht;
    @Mapper
    ComponentMapper<Velocity> vel;
    @Mapper
    ComponentMapper<Position> pos;

    @SuppressWarnings("unchecked")
    public DeathSystem() {
        super(Aspect.getAspectForAll(Health.class, Velocity.class, Position.class));
    }

    private void spawn(Position position){
        Random random = new Random();
        position.setX(random.nextInt(Game.MAP_WIDTH));
        position.setY(random.nextInt(Game.MAP_HEIGTH));
    }

    protected void process(Entity e) {
        Health health = ht.get(e);
        if(health.getHP() <= 0){
            Velocity velocity = vel.get(e);
            velocity.setX(0);
            velocity.setY(0);
            spawn(pos.get(e));
            health.setHP(100);
        }
    }
}
