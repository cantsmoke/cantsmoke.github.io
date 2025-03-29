/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lb2.gear;

import com.mycompany.lb2.gear.OrcGearFactory;
import com.mycompany.lb2.gear.Spear;
import com.mycompany.lb2.gear.SpiderBanner;
import com.mycompany.lb2.gear.Weapon;
import com.mycompany.lb2.gear.Armor;

/**
 *
 * @author Arseniy
 */
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