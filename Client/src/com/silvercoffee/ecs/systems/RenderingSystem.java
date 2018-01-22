package com.silvercoffee.ecs.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.silvercoffee.ecs.components.*;
import com.silvercoffee.gamestates.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class RenderingSystem extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> pm;

    @Mapper
    ComponentMapper<Cannon> cn;

    @Mapper
    ComponentMapper<AngleRotation> ar;

    @Mapper
    ComponentMapper<Damage> dm;

    @SuppressWarnings("unchecked")
    public RenderingSystem() {
        super(Aspect.getAspectForAll(Position.class));
    }

    protected void process(Entity e) {
        Position position = pm.get(e);
        Damage damage = dm.get(e);
        if (damage == null) {
            Game.gc.getGraphics().setColor(Color.gray);
            Game.gc.getGraphics().fillRect(position.getX() - 10, position.getY() - 10, 20, 20);
            Image img = Game.images.get("res/tank_vermelha.png");
            img = img.getScaledCopy(50, 50);
            Image img2 = Game.images.get("res/arma_vermelha.png");
            img2 = img2.getScaledCopy(50, 50);

            Cannon canhao = cn.get(e);
            if (canhao != null) {
                img2.setCenterOfRotation(img2.getWidth()/2,(img2.getHeight()/10)*8);
                img2.rotate((float) canhao.getAngle());
                img2.rotate(-90);
            }

            AngleRotation angle = ar.get(e);

            if (angle != null) {
                img.rotate(angle.getAngle());
            }
            img.rotate(-90);
            if (img != null) {
                Game.gc.getGraphics().drawImage(img, position.getX() - img.getWidth() / 2, position.getY() - img.getHeight() / 2);
            }
            if (img2 != null) {
                Game.gc.getGraphics().drawImage(img2, position.getX() - img2.getWidth() / 2, position.getY() - img2.getHeight() / 2 - (img.getHeight() / 3));
            }
        } else {
            Game.gc.getGraphics().setColor(Color.red);
            Game.gc.getGraphics().fillOval(position.getX() - 5, position.getY() - 5, 10, 10);
        }
        Game.gc.getGraphics().setColor(Color.white);

    }

}
