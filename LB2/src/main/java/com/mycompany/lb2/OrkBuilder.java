/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.lb2;

import com.mycompany.lb2.gear.Banner;
import com.mycompany.lb2.gear.Weapon;

/**
 *
 * @author Arseniy
 */
public interface OrkBuilder {
    //void setName(String name);
    void setStrength(int strength);
    void setAgility(int agility);
    void setIntelligence(int intelligence);
    void setHealth(int health);
    void setWeapon(Weapon weapon);
    void setBanner();
    Ork build();
}