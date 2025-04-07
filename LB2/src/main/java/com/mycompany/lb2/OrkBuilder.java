package com.mycompany.lb2;

import com.github.javafaker.Faker;
import com.mycompany.lb2.gear.Weapon;

public abstract class OrkBuilder {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;
    protected Weapon weapon;
    protected boolean hasBanner;

    public String comeUpWithName() {
        Faker faker = new Faker();
        return faker.lordOfTheRings().character();
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setBanner() {
        this.hasBanner = true;
    }

    public abstract Ork build();
}
