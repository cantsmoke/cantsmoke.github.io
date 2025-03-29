/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lb2;

import com.mycompany.lb2.gear.OrcGearFactory;

/**
 *
 * @author Arseniy
 */
import com.github.javafaker.Faker;

public class MistyMountainsOrkBuilder implements OrkBuilder {
    private final OrcGearFactory gearFactory;
    private Ork ork;

    public MistyMountainsOrkBuilder(OrcGearFactory gearFactory) {
        this.gearFactory = gearFactory;
        this.ork = new Ork();
    }

    //@Override
    public String comeUpWithName(/*String name*/) {
        //if (name == null || name.isEmpty()) {
            Faker faker = new Faker();
            return faker.lordOfTheRings().character();//this.ork.setName(faker.lordOfTheRings().character()); // Генерация имени из Lord of the Rings
        //} else {
        //    this.ork.setName(name);
        //}
    }

    @Override
    public void setStrength(int strength) {
        this.ork.setStrength((int) (strength * 0.9)); // Снижение силы на 10%
    }

    @Override
    public void setAgility(int agility) {
        this.ork.setAgility((int) (agility * 1.3)); // Увеличение ловкости на 30%
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.ork.setIntelligence((int) (intelligence * 0.7)); // Снижение интеллекта на 30%
    }

    @Override
    public void setHealth(int health) {
        this.ork.setHealth(health);
    }

    @Override
    public Ork build() {
        this.ork.setName(comeUpWithName());
        this.ork.setWeapon(gearFactory.createWeapon());
        this.ork.setArmor(gearFactory.createArmor());
        this.ork.setBanner(gearFactory.createBanner());
        return this.ork;
    }
}