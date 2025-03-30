package com.mycompany.lb2.gear;

public class MordorGearFactory implements OrcGearFactory {
    @Override
    public Weapon createWeapon() {
        return new HeavySword();
    }

    @Override
    public Armor createArmor() {
        return new SteelArmor();
    }

    @Override
    public Banner createBanner() {
        return new RedEyeBanner();
    }
}