package com.silvercoffee.ecs.entities;

import com.artemis.Entity;
import com.artemis.World;
import com.silvercoffee.ecs.components.Health;
import com.silvercoffee.ecs.components.Position;
import com.silvercoffee.ecs.components.Velocity;
import com.silvercoffee.gamestates.Game;


public abstract class TankFactory{

    private static long tankId = 0;
    public static Entity createTank(World world, int xPosition, int yPosition){
        System.out.println(world);

        Entity e = world.createEntity();
        //System.out.println(e);

        Position position = new Position(xPosition, yPosition);
        Health health = new Health(100);
        e.addComponent(position);
        e.addComponent(new Velocity(1,1));
        e.addComponent(health);

        tankId++;
        Game.addTank(tankId, position, health);
        return e;
    }
}
