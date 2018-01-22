package com.silvercoffee.network;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Listener.ThreadedListener;
import com.silvercoffee.network.Network.*;
import com.artemis.Entity;
import com.esotericsoftware.minlog.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.newdawn.slick.Color;

public class GameClient {

    public static String host;
    Client client;
    String name;
//    public static HashMap<Long, CharacterEntity> characters = new HashMap();
//    public static HashMap<Long, MonsterEntity> monsters = new HashMap();

    public GameClient(String name) {
        client = new Client();
        client.start();
        Network.register(client);
        Log.set(com.esotericsoftware.minlog.Log.LEVEL_INFO);
        // ThreadedListener runs the listener methods on a different thread.
        client.addListener(new ThreadedListener(new Listener() {
            public void connected(Connection connection) {
            }

            public void received(Connection connection, Object object) {

                if (object instanceof AddPlayer) {
                    AddPlayer msg = (AddPlayer) object;
                    //addCharacter(msg.character);
                    return;
                }

                if (object instanceof UpdatePlayer) {
                    //updateCharacter((UpdatePlayer) object);
                    return;
                }

                if (object instanceof RemovePlayer) {
                    RemovePlayer msg = (RemovePlayer) object;
                    removeCharacter(msg.id);
                    return;
                }

                if (object instanceof AddBullet) {
                    RemovePlayer msg = (RemovePlayer) object;
                    removeCharacter(msg.id);
                    return;
                }
            }

            public void disconnected(Connection connection) {
                System.exit(0);
            }
        }));
        new Thread() {
            public void run() {
                try {
                    //client.connect(50000, "10.0.2.2", 54557, 54777);
                    client.connect(5000, host, Network.port);// 10.0.2.2 is addres for connecting localhost from emulator.
                    Login login = new Login();
                    login.name = name;
                    client.sendTCP(login);

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro com a conexão ao servidor.");
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        }.start();
        // Server communication after connection can go here, or in Listener#connected().
    }

    public void clientUpdate(Player player) {
//        CharacterEntity cha = characters.get(player.getId());
//        if (cha != null) {
//            Player oldplayer = cha.getPlayer();
//            if (oldplayer.getDesiredX() != player.getDesiredX() || oldplayer.getDesiredY() != player.getDesiredY() || oldplayer.getDirection() != player.getDirection() || oldplayer.getHP() != player.getHP()) {
//                MoveCharacter msg = new MoveCharacter();
//                msg.x = player.getX();
//                cha.setX(msg.x);
//                msg.y = player.getY();
//                cha.setY(msg.y);
//                msg.desiredX = player.getDesiredX();
//                cha.setDesiredX(msg.desiredX);
//                msg.desiredY = player.getDesiredY();
//                cha.setDesiredY(msg.desiredY);
//                msg.direction = player.getDirection();
//                cha.setDirection(msg.direction);
//                msg.hp = player.getHP();
//                characters.replace(player.getId(), cha);
//                client.sendTCP(msg);
//            }
//        }
    }

    private String inputOtherStuff() {
        String input = (String) JOptionPane.showInputDialog(null, "Other Stuff:", "Create account", JOptionPane.QUESTION_MESSAGE,
                null, null, "other stuff");
        if (input == null || input.trim().length() == 0) {
            System.exit(1);
        }
        return input.trim();
    }

    public void addCharacter(Player character) {
//        CharacterEntity cha = new CharacterEntity(character, Game.world);
//        GameClient.characters.put(character.getId(), cha);
    }

    public void updateCharacter(Network.UpdatePlayer msg) {
//        CharacterEntity character = GameClient.characters.get(msg.id);
//        if (character == null) {
//            return;
//        }
//        if (character.getName().equals(Game.player.getName())) {
//            if (Game.player.getHP() < msg.hp && msg.hp == 100) {
//                Game.player.setX(msg.x);
//                Game.player.setY(msg.y);
//                Game.player.setDesiredX(msg.desiredX);
//                Game.player.setDesiredY(msg.desiredY);
//                Game.player.setDirection(msg.direction);
//            }
//            Game.player.setHP(msg.hp);
//
//        }
//        character.setX(msg.x);
//        character.setY(msg.y);
//        character.setDesiredX(msg.desiredX);
//        character.setDesiredY(msg.desiredY);
//        character.setDirection(msg.direction);
//        character.setHP(msg.hp);
    }

    public void removeCharacter(long id) {
//        CharacterEntity character = GameClient.characters.remove(id);
//        character.getEntity().deleteFromWorld();
//        if (character != null) {
//            System.out.println(character.getName() + " removed");
//        }
    }



    public void sendChat(String message) {
        if (message != null && message.length() > 0) {
//            ChatMessage msg = new ChatMessage();
//            msg.id = Game.player.getId();
//            msg.msg = message;
//            msg.name = Game.player.getName();
//            client.sendTCP(msg);
        }
    }


    public void close() {
        client.stop();
        client.close();
    }

    public boolean isConnected() {
        return client.isConnected();
    }
}
