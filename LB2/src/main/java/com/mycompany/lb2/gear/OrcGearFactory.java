/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.lb2.gear;

import com.mycompany.lb2.gear.Weapon;
import com.mycompany.lb2.gear.Armor;

/**
 *
 * @author Arseniy
 */
public interface OrcGearFactory {
    Weapon createWeapon();
    Armor createArmor();
    Banner createBanner();
}