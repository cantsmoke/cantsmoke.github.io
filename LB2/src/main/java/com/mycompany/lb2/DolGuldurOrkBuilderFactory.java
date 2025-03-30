package com.mycompany.lb2;

import com.mycompany.lb2.gear.DolGuldurGearFactory;

public class DolGuldurOrkBuilderFactory implements OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        return new DolGuldurOrkBuilder(new DolGuldurGearFactory());
    }
}