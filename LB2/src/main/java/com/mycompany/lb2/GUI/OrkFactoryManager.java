package com.mycompany.lb2.GUI;

import com.mycompany.lb2.DolGuldurOrkBuilderFactory;
import com.mycompany.lb2.MistyMountainsOrkBuilderFactory;
import com.mycompany.lb2.MordorOrkBuilderFactory;
import com.mycompany.lb2.OrcDirector;
import com.mycompany.lb2.Ork;
import com.mycompany.lb2.OrkBuilderFactory;

public class OrkFactoryManager {
    public static Ork createOrk(String tribe, String role) {
        OrkBuilderFactory factory = switch (tribe) {
            case "Мордор" -> new MordorOrkBuilderFactory();
            case "Дол Гулдур" -> new DolGuldurOrkBuilderFactory();
            case "Мглистые горы" -> new MistyMountainsOrkBuilderFactory();
            default -> throw new IllegalArgumentException("Неизвестное племя");
        };

        OrcDirector director = new OrcDirector(factory.createOrkBuilder());

        return switch (role) {
            case "Базовый" -> director.createBasicOrk();
            case "Командир" -> director.createLeaderOrk();
            case "Разведчик" -> director.createScoutOrk();
            default -> throw new IllegalArgumentException("Неизвестная роль");
        };
    }
}