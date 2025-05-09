package com.mycompany.lb2;

import com.github.javafaker.Faker;
import com.mycompany.lb2.gear.Bow;
import com.mycompany.lb2.gear.WarHammer;

public class OrcDirector {
    private OrkBuilder orkBuilder;

    public OrcDirector(OrkBuilder orkBuilder) {
        this.orkBuilder = orkBuilder;
    }

    public Ork createBasicOrk() {
        Faker faker = new Faker();
        orkBuilder.setStrength(faker.number().numberBetween(40, 50));
        orkBuilder.setAgility(faker.number().numberBetween(40, 50));
        orkBuilder.setIntelligence(faker.number().numberBetween(20, 30));
        orkBuilder.setHealth(faker.number().numberBetween(80, 110));
        return orkBuilder.build();
    }

    public Ork createLeaderOrk() {
        Faker faker = new Faker();
        orkBuilder.setStrength(faker.number().numberBetween(70, 90));
        orkBuilder.setAgility(faker.number().numberBetween(50, 60));
        orkBuilder.setIntelligence(faker.number().numberBetween(40, 50));
        orkBuilder.setHealth(faker.number().numberBetween(150, 200));
        orkBuilder.setWeapon(new WarHammer());
        orkBuilder.setBanner();
        return orkBuilder.build();
    }

    public Ork createScoutOrk() {
        Faker faker = new Faker();
        orkBuilder.setStrength(faker.number().numberBetween(20, 40));
        orkBuilder.setAgility(faker.number().numberBetween(80, 100));
        orkBuilder.setIntelligence(faker.number().numberBetween(30, 40));
        orkBuilder.setHealth(faker.number().numberBetween(65, 75));
        orkBuilder.setWeapon(new Bow());
        return orkBuilder.build();
    }
}