package com.mycompany.lb2;

import com.mycompany.lb2.gear.Banner;
import com.mycompany.lb2.gear.Weapon;

public interface OrkBuilder {
    String comeUpWithName();
    void setStrength(int strength);
    void setAgility(int agility);
    void setIntelligence(int intelligence);
    void setHealth(int health);
    void setWeapon(Weapon weapon);
    void setBanner();
    Ork build();
}