package com.mycompany.lb2.gear;

public class MistyMountainsGearFactory implements OrcGearFactory {
    @Override
    public Weapon createWeapon() {
        return new Axe();
    }

    @Override
    public Armor createArmor() {
        return new LeatherArmor();
    }

    @Override
    public Banner createBanner() {
        return new MoonBanner();
    }
}