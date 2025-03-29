/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lb2;

import com.mycompany.lb2.gear.Armor;
import com.mycompany.lb2.gear.Banner;
import com.mycompany.lb2.gear.Weapon;

/**
 *
 * @author Arseniy
 */
public class Ork {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;
    private Weapon weapon;
    private Armor armor;
    private Banner banner;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Banner getBanner() {
        return banner;
    }

    public void setBanner(Banner banner) {
        this.banner = banner;
    }
    
    @Override
    public String toString() {
        return name != null 
            ? name + (banner != null ? " (" + banner.getName() + ")" : "") 
            : "Безымянный орк";
    }
    
}