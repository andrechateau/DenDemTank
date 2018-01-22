package com.silvercoffee.network;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.silvercoffee.ecs.components.AngleRotation;
import com.silvercoffee.ecs.components.Cannon;
import com.silvercoffee.ecs.components.Position;
import com.silvercoffee.ecs.components.Velocity;
// This class is a convenient place to keep things common to both the client and server.

public class Network {

    static public final int port = 54555;

    // This registers objects that are going to be sent over the network.
    static public void register(EndPoint endPoint) {
        Kryo kryo = endPoint.getKryo();
        kryo.register(Login.class);
        kryo.register(UpdatePlayer.class);
        kryo.register(AddPlayer.class);
        kryo.register(RemovePlayer.class);

    }

    static public class Login {

        public String name;
    }

    static public class UpdatePlayer {
        public long id;
        public int x, y;
        public int desiredX, desiredY;
        public char direction;
        public int hp;
    }

    static public class AddPlayer {
        public Player character;
    }

    static public class RemovePlayer {
        public long id;
    }

    static public class AddBullet {
        public long id;
        public int x, y;
        public int desiredX, desiredY;
        public char direction;
        public int hp;    }

    public class Player {
        public long id;
        public float x;
        public float y;
        public float xVelocity;
        public float yVelocity;
        public float cannonAngle;
        public float angleRotation;
    }


}
