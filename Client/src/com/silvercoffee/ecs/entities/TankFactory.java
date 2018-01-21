package com.silvercoffee.ecs.entities;

import com.artemis.Entity;
import com.artemis.World;
import com.silvercoffee.ecs.components.Health;
import com.silvercoffee.ecs.components.Position;
import com.silvercoffee.ecs.components.Velocity;


public abstract class TankFactory{
    public static Entity createTank(World world){
        System.out.println(world);

        Entity e = world.createEntity();
        System.out.println(e);

        e.addComponent(new Position(100,100));
        e.addComponent(new Velocity(1,1));
        e.addComponent(new Health(100));
        return e;
    }
}
