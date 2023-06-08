package controller;
import model.Customer;
import model.ResturantOwner;
import view.AdminMenu;
import view.CostumerMenu;
import view.Menu;
import view.RegisterMenu;



public class RegisterMenuController {
    private RegisterMenu registerMenu;

    public RegisterMenuController() {
        registerMenu = new RegisterMenu(this);
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

    public void setnewCustomer(String name, String password, int node,String securityquestion) {
        if (Customer.printindexbycustomname(name) < 0) {
            System.out.println("Registration was successful");
            Customer customer = new Customer(name, password, node,securityquestion);
            CostumerMenu costumerMenu = new CostumerMenu(customer);
            costumerMenu.run();
        }
        else
        {
            System.out.println("This name already exists");
        }
    }
    public void setnewResturantOwner(String name, String password, int node,String securityquestion) {
        if (ResturantOwner.printindexbyResturantOwnername(name) < 0) {
            System.out.println("Registration was successful");
            ResturantOwner resturantOwner = new ResturantOwner(name, password, node,securityquestion);
            AdminMenu adminMenu = new AdminMenu(resturantOwner);
            adminMenu.run();
        }
        else
        {
            System.out.println("This name already exists");
        }
    }

}


