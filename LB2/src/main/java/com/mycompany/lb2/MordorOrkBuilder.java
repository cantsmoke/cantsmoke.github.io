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
import com.mycompany.lb2.gear.Banner;
import com.mycompany.lb2.gear.Weapon;

public class MordorOrkBuilder implements OrkBuilder {
    private final OrcGearFactory gearFactory;
    private Ork ork;
    private static boolean flag = true;

    public MordorOrkBuilder(OrcGearFactory gearFactory) {
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
        this.ork.setStrength((int) (strength * 1.3)); // Увеличение силы на 30% для Мордора
    }

    @Override
    public void setAgility(int agility) {
        this.ork.setAgility((int) (agility * 0.7)); // Снижение ловкости на 30%
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.ork.setIntelligence(intelligence); // Интеллект без изменений
    }

    @Override
    public void setHealth(int health) {
        this.ork.setHealth(health);
    }
    
    @Override
    public void setWeapon(Weapon weapon) {
        this.ork.setWeapon(weapon);
        flag = false;
    }

    @Override
    public Ork build() {
        this.ork.setName(comeUpWithName());
        if (flag) {
            this.ork.setWeapon(gearFactory.createWeapon());
        }
        this.ork.setArmor(gearFactory.createArmor());
        //this.ork.setBanner(gearFactory.createBanner());
        flag = true;
        return this.ork;
    }

    @Override
    public void setBanner() {
        this.ork.setBanner(gearFactory.createBanner());
    }
}