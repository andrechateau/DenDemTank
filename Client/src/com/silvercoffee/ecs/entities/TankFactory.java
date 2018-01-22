package com.silvercoffee.ecs.entities;


import com.artemis.Entity;
import com.artemis.World;
import com.silvercoffee.ecs.components.*;
import com.silvercoffee.gamestates.Game;

public abstract class TankFactory {

    private static long tankId = 0;

    public static Entity createTank(World world, int xPosition, int yPosition) {
        System.out.println(world);

        Entity e = world.createEntity();
        //System.out.println(e);

        Position position = new Position(xPosition, yPosition);
        Health health = new Health(100);
        e.addComponent(position);
        e.addComponent(new Velocity(1, 1));
        e.addComponent(health);
        e.addComponent(new AngleRotation());
        e.addComponent(new Cannon());
        tankId++;
        Game.addTank(tankId, position, health);
        return e;
    }

    public static Entity createControlledTank(World world, int xPosition, int yPosition) {
        System.out.println(world);

        Entity e = world.createEntity();
        //System.out.println(e);

        Position position = new Position(xPosition, yPosition);
        Health health = new Health(100);
        e.addComponent(position);
        e.addComponent(new Velocity(1, 1));
        e.addComponent(health);
        e.addComponent(new Cannon());
        e.addComponent(new AngleRotation());
        e.addComponent(new PlayerControlled());
        tankId++;
        Game.addTank(tankId, position, health);
        return e;
    }

}