package com.mycompany.lb2.gear;

public class DolGuldurGearFactory implements OrcGearFactory {
    @Override
    public Weapon createWeapon() {
        return new Spear();
    }

    @Override
    public Armor createArmor() {
        return new ChainArmor();
    }

    @Override
    public Banner createBanner() {
        return new SpiderBanner();
    }
}