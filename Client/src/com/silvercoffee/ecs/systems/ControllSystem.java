package com.silvercoffee.ecs.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.silvercoffee.ecs.components.*;
import com.silvercoffee.gamestates.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.Input;

public class ControllSystem extends EntityProcessingSystem {
    @Mapper
    ComponentMapper<AngleRotation> ag;

    @Mapper
    ComponentMapper<Position> ps;

    public ControllSystem() {
        super(Aspect.getAspectForAll(Position.class, PlayerControlled.class, Velocity.class, AngleRotation.class));
    }

    @Override
    protected void process(Entity entity) {
        AngleRotation angle = ag.get(entity);

        if (Game.gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
            angle.setAngle(angle.getAngle() + 15);
        }
        if (Game.gc.getInput().isKeyDown(Input.KEY_LEFT)) {
            angle.setAngle(angle.getAngle() - 15);
        }

        Position pos = ps.get(entity);
        Game.gc.getGraphics().setColor(Color.red);
        Game.gc.getGraphics().drawString(angle.getAngle() + "", pos.getX()-15, pos.getY()-30);
    }
}
