package com.mycompany.lb2;

import com.mycompany.lb2.gear.MordorGearFactory;

public class MordorOrkBuilderFactory implements OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        return new MordorOrkBuilder(new MordorGearFactory());
    }
}