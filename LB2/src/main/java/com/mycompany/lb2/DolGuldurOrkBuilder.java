package com.mycompany.lb2;

import com.mycompany.lb2.gear.OrcGearFactory;

import com.mycompany.lb2.gear.Weapon;

public class DolGuldurOrkBuilder extends OrkBuilder {
    private final OrcGearFactory gearFactory;
    private static boolean weaponChoiceflag = true;

    public DolGuldurOrkBuilder(OrcGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }

    @Override
    public void setStrength(int strength) {
        this.ork.setStrength(strength);
    }

    @Override
    public void setAgility(int agility) {
        this.ork.setAgility(agility);
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.ork.setIntelligence(intelligence);
    }

    @Override
    public void setHealth(int health) {
        this.ork.setHealth(health);
    }
    
    @Override
    public void setWeapon(Weapon weapon) {
        this.ork.setWeapon(weapon);
        weaponChoiceflag = false;
    }

    @Override
    public Ork build() {
        this.ork.setName(comeUpWithName());
        if (weaponChoiceflag) {
            this.ork.setWeapon(gearFactory.createWeapon());
        }
        this.ork.setArmor(gearFactory.createArmor());
        weaponChoiceflag = true;
        return this.ork;
    }

    @Override
    public void setBanner() {
        this.ork.setBanner(gearFactory.createBanner());
    }

}