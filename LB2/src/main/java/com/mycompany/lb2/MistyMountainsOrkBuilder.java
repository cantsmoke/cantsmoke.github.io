package com.mycompany.lb2;

import com.mycompany.lb2.gear.OrcGearFactory;

import com.mycompany.lb2.gear.Weapon;

public class MistyMountainsOrkBuilder extends OrkBuilder {
    private final OrcGearFactory gearFactory;
    private static boolean weaponChoiceflag = true;

    public MistyMountainsOrkBuilder(OrcGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }

    @Override
    public void setStrength(int strength) {
        this.ork.setStrength((int) (strength * 0.9));
    }

    @Override
    public void setAgility(int agility) {
        this.ork.setAgility((int) (agility * 1.3));
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.ork.setIntelligence((int) (intelligence * 0.7));
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