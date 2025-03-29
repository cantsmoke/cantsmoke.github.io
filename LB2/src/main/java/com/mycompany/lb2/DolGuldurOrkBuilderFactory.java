/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lb2;

import com.mycompany.lb2.gear.DolGuldurGearFactory;

/**
 *
 * @author Arseniy
 */
public class DolGuldurOrkBuilderFactory implements OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        return new DolGuldurOrkBuilder(new DolGuldurGearFactory());
    }
}