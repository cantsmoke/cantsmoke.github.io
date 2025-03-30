package com.mycompany.lb2;

import com.mycompany.lb2.gear.MistyMountainsGearFactory;

public class MistyMountainsOrkBuilderFactory implements OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        return new MistyMountainsOrkBuilder(new MistyMountainsGearFactory());
    }
}