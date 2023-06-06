package view;

import controller.LoginMenuController;

public class Main {
    public static void main(String[] args) {

        LoginMenuController loginMenuController = new LoginMenuController();
        LoginMenu loginMenu = new LoginMenu(loginMenuController);
        loginMenu.run();
    }
}