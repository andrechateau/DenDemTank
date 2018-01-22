package com.silvercoffee.network;


        import com.esotericsoftware.kryo.Kryo;
        import com.esotericsoftware.kryonet.EndPoint;
// This class is a convenient place to keep things common to both the client and server.

public class Network {

    static public final int port = 54555;

    // This registers objects that are going to be sent over the network.
    static public void register(EndPoint endPoint) {
        Kryo kryo = endPoint.getKryo();
        kryo.register(Login.class);
        kryo.register(AddCharacter.class);
        kryo.register(UpdateCharacter.class);
        kryo.register(RemoveCharacter.class);
        kryo.register(Player.class);
        kryo.register(MoveCharacter.class);
        kryo.register(HitEffect.class);
    }

    static public class Login {

        public String name;
    }

    static public class UpdateCharacter {

        public long id;
        public int x, y;
        public int desiredX, desiredY;
        public char direction;
        public int hp;
    }

    static public class AddCharacter {

        public Player character;
    }

    static public class RemoveCharacter {

        public long id;
    }

    static public class HitEffect {

        public int x, y;
        public String sprite;
        public String number;
    }

    static public class MoveCharacter {

        public int x, y;
        public int desiredX, desiredY;
        public char direction;
        public int hp;
    }


    static public class Player {

        private long id;
        private String name;
        private String password;
        private int X;
        private int Y;
        private int desiredX;
        private int desiredY;
        private int HP;
        private char direction;
        private int damage = 5;
        private long lastMeelee = 0;
        private int cdMeelee = 800;
        private String outfit;

        public Player(long id, String name, String password, int X, int Y, int desiredX, int desiredY, int HP, char direction, String outfit) {
            this.id = id;
            this.name = name;
            this.password = password;
            this.X = X;
            this.Y = Y;
            this.desiredX = desiredX;
            this.desiredY = desiredY;
            this.HP = HP;
            this.direction = direction;
            this.outfit = outfit;
        }

        public Player() {
        }

        /**
         * @return the id
         */
        public long getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(long id) {
            this.id = id;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the password
         */
        public String getPassword() {
            return password;
        }

        /**
         * @param password the password to set
         */
        public void setPassword(String password) {
            this.password = password;
        }

        /**
         * @return the X
         */
        public int getX() {
            return X;
        }

        /**
         * @param X the X to set
         */
        public void setX(int X) {
            this.X = X;
        }

        /**
         * @return the Y
         */
        public int getY() {
            return Y;
        }

        /**
         * @param Y the Y to set
         */
        public void setY(int Y) {
            this.Y = Y;
        }

        /**
         * @return the desiredX
         */
        public int getDesiredX() {
            return desiredX;
        }

        /**
         * @param desiredX the desiredX to set
         */
        public void setDesiredX(int desiredX) {
            this.desiredX = desiredX;
        }

        /**
         * @return the desiredY
         */
        public int getDesiredY() {
            return desiredY;
        }

        /**
         * @param desiredY the desiredY to set
         */
        public void setDesiredY(int desiredY) {
            this.desiredY = desiredY;
        }

        /**
         * @return the HP
         */
        public int getHP() {
            return HP;
        }

        /**
         * @param HP the HP to set
         */
        public void setHP(int HP) {
            this.HP = HP;
        }

        /**
         * @return the direction
         */
        public char getDirection() {
            return direction;
        }

        /**
         * @param direction the direction to set
         */
        public void setDirection(char direction) {
            this.direction = direction;
        }

        /**
         * @return the outfit
         */
        public String getOutfit() {
            return outfit;
        }

        /**
         * @param outfit the outfit to set
         */
        public void setOutfit(String outfit) {
            this.outfit = outfit;
        }

        /**
         * @return the damage
         */
        public int getDamage() {
            return damage;
        }

        /**
         * @param damage the damage to set
         */
        public void setDamage(int damage) {
            this.damage = damage;
        }

        /**
         * @return the lastMeelee
         */
        public long getLastMeelee() {
            return lastMeelee;
        }

        /**
         * @param lastMeelee the lastMeelee to set
         */
        public void setLastMeelee(long lastMeelee) {
            this.lastMeelee = lastMeelee;
        }

        /**
         * @return the cdMeelee
         */
        public int getCdMeelee() {
            return cdMeelee;
        }

        /**
         * @param cdMeelee the cdMeelee to set
         */
        public void setCdMeelee(int cdMeelee) {
            this.cdMeelee = cdMeelee;
        }

    }

}
