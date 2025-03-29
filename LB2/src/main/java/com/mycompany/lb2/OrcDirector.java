/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lb2;

import com.github.javafaker.Faker;
import com.mycompany.lb2.gear.Bow;

/**
 *
 * @author Arseniy
 */
public class OrcDirector {
    private OrkBuilder orkBuilder;

    public OrcDirector(OrkBuilder orkBuilder) {
        this.orkBuilder = orkBuilder;
    }

    public Ork createBasicOrk() {
        //orkBuilder.setName("Базовый орк");
        Faker faker = new Faker();
        orkBuilder.setStrength(faker.number().numberBetween(40, 50));
        orkBuilder.setAgility(faker.number().numberBetween(40, 50));
        orkBuilder.setIntelligence(faker.number().numberBetween(20, 30));
        orkBuilder.setHealth(faker.number().numberBetween(80, 110));
        return orkBuilder.build();
    }

    public Ork createLeaderOrk() {
        //orkBuilder.setName("Командир орков");
        Faker faker = new Faker();
        orkBuilder.setStrength(faker.number().numberBetween(70, 90));
        orkBuilder.setAgility(faker.number().numberBetween(50, 60));
        orkBuilder.setIntelligence(faker.number().numberBetween(40, 50));
        orkBuilder.setHealth(faker.number().numberBetween(150, 200));
        orkBuilder.setBanner();
        return orkBuilder.build();
    }

    public Ork createScoutOrk() {
        //orkBuilder.setName("Разведчик орков");
        Faker faker = new Faker();
        orkBuilder.setStrength(faker.number().numberBetween(20, 40));
        orkBuilder.setAgility(faker.number().numberBetween(80, 100));
        orkBuilder.setIntelligence(faker.number().numberBetween(30, 40));
        orkBuilder.setHealth(faker.number().numberBetween(65, 75));
        orkBuilder.setWeapon(new Bow());
        return orkBuilder.build();
    }
}