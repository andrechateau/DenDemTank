package com.silvercoffee.ecs.components;

import com.artemis.Component;

public class Damage extends Component {

    private int damage;

    public Damage(){

    }

    public Damage(int damage){
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
}
