package view;

import controller.LoginMenuController;
import model.Customer;
import model.FileManager;
import model.ResturantOwner;

import java.io.File;

public class Main {
     static FileManager fileManager;
    public static void main(String[] args) {
         FileManager.loadAllDatas();
        LoginMenuController loginMenuController = new LoginMenuController();
        LoginMenu loginMenu = new LoginMenu(loginMenuController);
        loginMenu.run();
        FileManager.saveAllDatas();
    }
}