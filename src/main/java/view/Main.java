package view;

import controller.LoginMenuController;
import model.FileManager;

import java.io.File;

public class Main {
     static FileManager fileManager;
    public static void main(String[] args) {
         fileManager=new FileManager();
        LoginMenuController loginMenuController = new LoginMenuController();
        LoginMenu loginMenu = new LoginMenu(loginMenuController);
        loginMenu.run();
    }
}