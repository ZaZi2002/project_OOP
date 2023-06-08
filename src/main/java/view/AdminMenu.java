package view;

import controller.AdminMenuController;
import controller.CustomerMenuController;
import model.Customer;
import model.ResturantOwner;

import java.util.regex.Matcher;

public class AdminMenu {
    private AdminMenuController adminMenuController;
    private ResturantOwner resturantOwner;
    public AdminMenu(ResturantOwner loggedResturantOwner) {
        this.adminMenuController = new AdminMenuController(this);
        this.resturantOwner=loggedResturantOwner;
    }
    public static void run()
    {
        Matcher matcher;
        String command ;
        System.out.println("Hi");
        }
    }

