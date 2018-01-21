package com.silvercoffee.ecs.components;

import com.artemis.Component;

public class Health extends Component {
    private int HP;

    public Health() {
    }

    public Health(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
