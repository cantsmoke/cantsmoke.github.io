package com.mycompany.lb2;

import com.github.javafaker.Faker;
import com.mycompany.lb2.gear.Weapon;

public abstract class OrkBuilder {
    protected Ork ork;
    private static String[] prefixes = {"Orc", "Grim", "Gul", "Uruk", "Zug"};
    
    public OrkBuilder() {
        this.ork = new Ork();
    }

    public String comeUpWithName() {
        Faker faker = new Faker();
        String orcName = faker.lordOfTheRings().character();
        int randomIndex = faker.random().nextInt(prefixes.length);
        String prefix = prefixes[randomIndex];
        return prefix + " " + orcName;
    }

    public abstract void setStrength(int strength);
    public abstract void setAgility(int agility);
    public abstract void setIntelligence(int intelligence);
    public abstract void setHealth(int health);
    public abstract void setWeapon(Weapon weapon);
    public abstract void setBanner();

    public abstract Ork build();
}
