package controller;

import model.Customer;
import model.ResturantOwner;
import view.AdminMenu;
import view.CostumerMenu;
import view.LoginMenu;
import view.Menu;

public class LoginMenuController {
    private final LoginMenu loginMenu;
    public LoginMenuController(){
        loginMenu = new LoginMenu(this);
    }
    public static void logginCustomer(String name,String password){
        if(Customer.printindexbycustomname(name)<0){
            System.out.println("There is no account with this name");
        }
        else{
            if(!Customer.checkpasswor(password,Customer.printindexbycustomname(name))){
                System.out.println("your password is wrong");
            }
            else{
                Customer customer;
                customer = Customer.returncustomerbyname(name);
                CostumerMenu costumerMenu = new CostumerMenu(customer);
                costumerMenu.run();
            }
        }
    }
    public static void logginResturantOwner(String name,String password){
        if(ResturantOwner.printindexbyResturantOwnername(name)<0){
            System.out.println("There is no account with this name");
        }
        else{
            if(!ResturantOwner.checkpasswor(password,ResturantOwner.printindexbyResturantOwnername(name))){
                System.out.println("your password is wrong");
            }
            else{
                ResturantOwner resturantOwner;
                resturantOwner=ResturantOwner.returnResturantOwnerbyname(name);
                AdminMenu adminMenu = new AdminMenu(resturantOwner);
                adminMenu.run();
            }
        }
    }
    public String setANewPassword(String newPassword) {
        newPassword = newPassword.trim();
        if (newPassword.length() < 6 || !newPassword.matches(".*[a-z].*") || !newPassword.matches(".*[A-Z].*") || !newPassword.matches(".*[0-9].*") || !newPassword.matches(".*[^a-zA-Z0-9|_].*"))
            return handlePasswordErrors(newPassword);
        System.out.println("Please re-enter your password");
        String checkpassword = Menu.getScanner().nextLine();
        if (!checkpassword.equals(newPassword)) {
            return "Your password does not match";
        }
        return "Your account has been successfully created";
    }
    public String handlePasswordErrors(String password) {
        if (password.length() < 6)
            return "Weak password! Password length should be more than 5.";

        if (!password.matches(".*[a-z].*"))
            return "Weak password! Password should have at least one small English letter.";

        if (!password.matches(".*[A-Z].*"))
            return "Weak password! Password should have at least one capital English letter.";

        if (!password.matches(".*[0-9].*"))
            return "Weak password! Password should have at least one digit.";

        if (!password.matches(".*[^a-zA-Z0-9|_].*"))
            return "Weak password! Password should have at least one character except english letters and digits.";

        else return "";
    }
}
