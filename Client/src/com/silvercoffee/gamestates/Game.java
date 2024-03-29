package com.silvercoffee.gamestates;

import com.artemis.World;
import com.silvercoffee.ecs.components.Health;
import com.silvercoffee.ecs.components.Position;
import com.silvercoffee.ecs.entities.PlayerEntity;
import com.silvercoffee.ecs.entities.ShotFactory;
import com.silvercoffee.ecs.entities.TankFactory;
import com.silvercoffee.ecs.systems.*;
import com.silvercoffee.network.GameClient;
import javafx.geometry.Pos;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends BasicGameState {

    public static final int MAP_WIDTH = 800;
    public static final int MAP_HEIGTH = 600;
    public static HashMap<String, Image> images;
    public static HashMap<Long, Position> tanksPosition = new HashMap<>();
    public static HashMap<Long, Health> tanksHealth = new HashMap<>();
    public static GameClient client;



    public static World world;
    /**
     * The ID given to this state
     */
    public static final int ID = 3;
//    public static Player play;
//    public static PlayerEntity player;
    public static GameContainer gc;
//    public static GameMap map;
//    public static GameMap ground;
//    public static GameClient client;
    public static TextField tf;
    public static List<String> msgRecord;
    private static boolean clientConnected = false;
    public static PlayerEntity player;

    public Game() {
        //super("Mundus Profundis");
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        msgRecord = new LinkedList<>();
        world = new World();
        world.setSystem(new MovementSystem());
        world.setSystem(new AimSystem());
        world.setSystem(new DeathSystem());
        world.setSystem(new ColisionSystem());
        world.setSystem(new ControllSystem());
        world.setSystem(new RenderingSystem());

        // Set World Systems
        world.initialize();
        world.addEntity(TankFactory.createControlledTank(world, 50, 50));
        world.addEntity(TankFactory.createTank(world, 200, 200));
        world.addEntity(ShotFactory.createShot(world, 400, 400));

        loadImages();
//        Font font = new AngelCodeFont("res/small_font.fnt", "res/small_font_0.tga");
//        tf = new TextField(gc, font, 5, gc.getHeight() - 25, 300, 20, new ComponentListener() {
//            public void componentActivated(AbstractComponent source) {
//                Game.client.sendChat(tf.getText());
//                tf.setText("");
//            }
//        });
        Color invisible = new Color(0, 0, 0, 0);
        //tf.setBackgroundColor(invisible);
//        tf.setBorderColor(Color.white);
        // tf.setFocus(false);
//        Entity e = world.createEntity();
//        e = world.createEntity();
//        e.addComponent(new Position(640, 640));
//        e.addComponent(new ActorSprite(new Image("res/troll.png")));
//        e.addComponent(new Velocity(70, 70));
//        e.addComponent(new Creature("Goblinho", "troll", 100));
//        e.addComponent(new Enemy());
//        e.addToWorld();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //g.setColor(Color.white);

        g.fillRect(0, 0, gc.getWidth(), gc.getHeight());

        drawDebugLines(g, 50);
        Game.gc = gc;
        world.process();
//        if (Game.client == null || !Game.client.isConnected()) {
//            g.setColor(new Color(150, 150, 150, 150));
//        g.setColor(Color.white);
//
//        g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
//            String msg = "Connecting to server...";
//            int x = gc.getWidth() / 2 - g.getFont().getWidth(msg) / 2;
//            int y = gc.getHeight() / 2 - g.getFont().getHeight(msg) / 2;
//            g.fillRect(x - 2, y - 2, g.getFont().getWidth(msg) + 4, g.getFont().getHeight(msg) + 4);
//            g.setColor(Color.white);
//            g.drawString(msg, x, y);
//        }
//        g.setColor(Color.white);
//
//        tf.render(gc, g);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
            world.setDelta((delta / 1000.0f));
//        if (!clientConnected) {
//            clientConnected = true;
//            Game.client = new GameClient("Player");
//        } else {
//            world.setDelta((delta / 1000.0f));
//            Game.client.clientUpdate(player.getPlayer());
//
//        }

    }

    // Draw a grid on the screen for easy positioning
    public void drawDebugLines(Graphics g, int size) {
        int resolution = 2000;
        g.setColor(Color.blue);
        for (int i = 0; i < resolution; i += size) {
            g.drawLine(i, 0, i, resolution);
            g.drawLine(0, i, resolution, i);
        }
    }
//
//    @Override
//    public boolean closeRequested() {
//        // PlayerDAO.savePlayer(player.getPlayer());
//        Game.client.close();
//        System.exit(0);
////super.closeRequested();
//        return true;//To change body of generated methods, choose Tools | Templates.
//    }

    public void loadImages() {
        //Load Images here
        try {
            images = new HashMap<>();
            Image img =  new Image("res/tank_vermelha.png");
            if(img!=null) {
                images.put("res/tank_vermelha.png",img);

            }else{
                System.exit(0);
            }
            images.put("res/arma_vermelha.png", new Image("res/arma_vermelha.png"));

        } catch (SlickException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public int getID() {
        return ID;
    }

    public void keyReleased(int key, char c) {
        if (key == Input.KEY_ENTER) {
            if (!tf.hasFocus()) {
                tf.setFocus(true);
            } else {
                tf.setFocus(false);
            }
        }
    }

    public static void addTank(long id, Position pos, Health health){
        tanksPosition.put(id, pos);
        tanksHealth.put(id, health);
    }

}
