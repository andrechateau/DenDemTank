package com.silvercoffee.ecs.entities;

import com.artemis.Entity;
import com.artemis.World;
import com.silvercoffee.ecs.components.Damage;
import com.silvercoffee.ecs.components.Position;
import com.silvercoffee.ecs.components.Velocity;

import java.util.Random;

public class ShotFactory {

    public static Entity createShot(World world, float xPosition, float yPosition){
        Entity e = world.createEntity();
        e.addComponent(new Position(xPosition, yPosition));
        e.addComponent(new Velocity(-1,-1));
        Random random = new Random();
        //e.addComponent(new Damage(random.nextInt(11) + 10)); //random de 10 ~~ 20
        e.addComponent(new Damage(200));
        return e;
    }
    public static Entity createShot(World world, float xPosition, float yPosition,float xVelocity, float yVelocity){
        Entity e = world.createEntity();
        e.addComponent(new Position(xPosition, yPosition));
        e.addComponent(new Velocity(xVelocity,yVelocity));
        Random random = new Random();
        //e.addComponent(new Damage(random.nextInt(11) + 10)); //random de 10 ~~ 20
        e.addComponent(new Damage(200));
        return e;
    }
}
