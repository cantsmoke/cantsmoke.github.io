/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lb2.gear;

import com.mycompany.lb2.gear.MoonBanner;
import com.mycompany.lb2.gear.OrcGearFactory;
import com.mycompany.lb2.gear.Weapon;
import com.mycompany.lb2.gear.Armor;

/**
 *
 * @author Arseniy
 */
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