/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lb2.gear;

import com.mycompany.lb2.gear.OrcGearFactory;
import com.mycompany.lb2.gear.RedEyeBanner;
import com.mycompany.lb2.gear.SteelArmor;
import com.mycompany.lb2.gear.Weapon;
import com.mycompany.lb2.gear.Armor;

/**
 *
 * @author Arseniy
 */
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