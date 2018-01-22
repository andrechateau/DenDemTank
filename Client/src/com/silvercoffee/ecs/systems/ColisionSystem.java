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

import java.util.Map;

public class ColisionSystem extends EntityProcessingSystem {

    private static final double MIN_DIST = 10;
    @Mapper
    ComponentMapper<Position> ps;
    @Mapper
    ComponentMapper<Damage> dm;

    @SuppressWarnings("unchecked")
    public ColisionSystem() {
        super(Aspect.getAspectForAll(Position.class, Damage.class));
    }

    private boolean isColided(Position shotPosition, Position tankPosition){
        double dist = Math.pow(shotPosition.getX() - tankPosition.getX(), 2);
        dist += Math.pow(shotPosition.getY() - tankPosition.getY(), 2);
        dist = Math.sqrt(dist);
        return dist < MIN_DIST;
    }

    private void decreaseTankHealth(Health tankHealth, Damage shotDamage){
        tankHealth.setHP(tankHealth.getHP() - shotDamage.getDamage());
    }

    protected void process(Entity e) {
        Damage shotDamage = dm.get(e);
        Position shotPosition = ps.get(e);
        for(Map.Entry<Long, Position> entry : Game.tanksPosition.entrySet()){
            Position tankPosition = entry.getValue();
//            System.out.println("Posição do tanque: "+tankPosition.getX()+"-"+tankPosition.getY());
            long tankId = entry.getKey();
            if(isColided(tankPosition, shotPosition)){
                decreaseTankHealth(Game.tanksHealth.get(tankId), shotDamage);
            }
        }
    }
}
