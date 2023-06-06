package controller;

import view.LoginMenu;
import view.Menu;

public class LoginMenuController {
    private final LoginMenu loginMenu;
    public LoginMenuController(){
        loginMenu = new LoginMenu(this);
    }

}
