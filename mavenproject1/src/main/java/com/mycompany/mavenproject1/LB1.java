package com.mycompany.mavenproject1;

public class LB1 {
    public static void main(String[] args) {
        MainView mainView = new MainView();
        ModelController modelController = new ModelController(null, null);
        MainController mainController = new MainController(mainView, modelController);
    }
}