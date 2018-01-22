package com.silvercoffee.ecs.entities;

import com.artemis.Entity;
import com.artemis.World;
import com.silvercoffee.ecs.components.*;


public abstract class TankFactory {
    public static Entity createTank(World world) {
        System.out.println(world);

        Entity e = world.createEntity();
        System.out.println(e);

        e.addComponent(new Position(250, 250));
        e.addComponent(new PlayerControlled());
        e.addComponent(new Cannon());
        return e;
    }
}
