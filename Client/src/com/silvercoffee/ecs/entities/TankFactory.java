package com.silvercoffee.ecs.entities;


import com.artemis.Entity;
import com.artemis.World;
import com.silvercoffee.ecs.components.Cannon;
import com.silvercoffee.ecs.components.PlayerControlled;
import com.silvercoffee.ecs.components.Position;

public abstract class TankFactory {

    private static long tankId = 0;

    public static Entity createTank(World world, int xPosition, int yPosition) {
        System.out.println(world);

        Entity e = world.createEntity();
        //System.out.println(e);

        e.addComponent(new Position(250, 250));
        e.addComponent(new PlayerControlled());
        e.addComponent(new Cannon());

        return e;
    }
}
